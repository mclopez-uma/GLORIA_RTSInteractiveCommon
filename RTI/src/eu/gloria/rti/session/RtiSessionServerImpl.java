package eu.gloria.rti.session;

import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.handler.MessageContext;


import eu.gloria.rti.tool.http.AuthorizationHTTP;
import eu.gloria.tools.cert.CertManager;
import eu.gloria.tools.configuration.Config;
import eu.gloria.tools.log.LogUtil;

/**
 * Session management based on HttpSession.
 * CAN BE USED WITHIN A CLUSTER ENVIRONMENT.
 * @author jcabello
 *
 */
public class RtiSessionServerImpl extends RtiSession{
	
	private HttpSession session; 
	
	/**
	 * Session implementation over HttpSession
	 * @param wsContext WebService context
	 * @throws InvalidSessionException If the session does not exist in the Application server
	 */
	public RtiSessionServerImpl(WebServiceContext wsContext) throws InvalidSessionException{
		
		MessageContext mc = wsContext.getMessageContext();
        session = ((javax.servlet.http.HttpServletRequest)mc.get(MessageContext.SERVLET_REQUEST)).getSession();
        
        if (session == null)
            throw new InvalidSessionException("Server Session does not exist.");
        
        if (session.getAttribute(RtiSession.SESSION_PARAM_STATE) == null){
        	session.setAttribute(RtiSession.SESSION_PARAM_STATE, RtiSessionState.UNLOGGED);
        }
        
        //HTTP-AUTORIZATION
        RtiSessionState sessionState = (RtiSessionState)session.getAttribute(RtiSession.SESSION_PARAM_STATE);
        if (sessionState == RtiSessionState.UNLOGGED){
        	//Try to execute HTTP authentication
        	if (isEnabledLoginAuthenticationHTTP()){
        		try{
        			AuthorizationHTTP authorizationData = new AuthorizationHTTP((javax.servlet.http.HttpServletRequest)mc.get(MessageContext.SERVLET_REQUEST));
        			session.setAttribute(RtiSession.SESSION_PARAM_STATE, RtiSessionState.LOGGED);
        			session.setAttribute(RtiSession.SESSION_PARAM_USER, authorizationData.getUser());
        			LogUtil.info(this, "RtiSessionServerImpl.AuthenticationHTTP. user:" + authorizationData.getUser());
        		}catch(Exception ex){
            		//Maintain the session invalid
            	}
        	}
        }
 
	}
	
	
	/**
	 * Validates the current session is valid:
	 * -The session exists.
	 * -The user has been logged in the system.
	 * @throws InvalidSessionException If the session is not initialized.
	 */
	public void rtiValidateSession() throws InvalidSessionException  {
		RtiSessionState sessionState = (RtiSessionState)session.getAttribute(RtiSession.SESSION_PARAM_STATE);
		if (sessionState != RtiSessionState.LOGGED){
			throw new InvalidSessionException("The user is not logged.");
		}
	}
	
	/**
	 * Authenticates the user using X509 private key of Gloria System.
	 * @param user User name.
	 * @param time Client datetime.
	 * @param sign Sign using private key of Gloria System. The sign content is: SIGN[user + time].
	 * @returnToken or "USING_SERVER_SESSION" is token mechanism is not used.
	 * @throws AuthenticationException If the authentication fails.
	 * @throws InvalidUsrPwException If the user login or pw are wrong.
	 */
	@Override
	public String rtiLoginCert(String user, Date date, String sign)
			throws AuthenticationException, InvalidUsrPwException {
		
		try{
			
			if (isEnabledLoginAuthenticationHTTP()){
				throw new AuthenticationException("This operation is unavailable due to configuration reasons.");
			}
			
			if (user == null) user = "";
			
			String dateFormat = Config.getProperty("rti_config", "login.signature.date.format");
			SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
			String clearContent = user + sdf.format(date);
			
			
			CertManager manager = new CertManager();
			KeyStore ks = manager.getKeyStore(Config.getProperty("rti_config", "login.signature.cacert.file"), Config.getProperty("rti_config", "login.signature.cacert.pw"));
			
			PublicKey publicKey = manager.getPublicKey(ks, Config.getProperty("rti_config", "login.signature.cacert.ca.alias"));
			boolean verified = manager.signatureVerify(sign.getBytes("UTF-8"), clearContent.getBytes("UTF-8"), publicKey, null);
			
			if (verified){
				
				session.setAttribute(RtiSession.SESSION_PARAM_STATE, RtiSessionState.LOGGED);
				session.setAttribute(RtiSession.SESSION_PARAM_USER, user);
				
				return RtiSession.SESSION_SERVER_TOKEN;
				
			}else{
				throw new AuthenticationException("Invalid Signature.");
			}
			
		}catch(AuthenticationException ex){
			throw ex;
		}catch(Exception ex){
			LogUtil.severe(this, "RtiSessionServerImpl.loginCert().Error: " + ex.getMessage());
			throw new AuthenticationException("It is impossible to verify the signature.");
		}
	}
	
	/**
	 * Authenticate the user into the system.
	 * @param user User name.
	 * @param pw Password.
	 * @return "USING_SERVER_SESSION" is token mechanism is not used.
	 * @throws AuthenticationException If the authentication fails.
	 * @throws InvalidUsrPwException If the user login or pw are wrong.
	 */
	public String rtiLogin(String user, String pw) throws AuthenticationException, InvalidUsrPwException{
		
		if (isEnabledLoginAuthenticationHTTP()){
			throw new AuthenticationException("This operation is unavailable due to configuration reasons.");
		}
		
		String configUser = Config.getProperty("rti_config", "login.ws.method.user");
		String configPW = Config.getProperty("rti_config", "login.ws.method.pw");
		
		if (configUser == null || configPW == null || configUser.trim().length() == 0 || configPW.trim().length() == 0){
			LogUtil.severe(this, "RtiSessionServerImpl.rtiLogin(). USER/PW are mandatory in the configuration.......!!!!!");
			throw new AuthenticationException("This operation is unavailable.");
		}
		
		if (configUser.equals(user) && configPW.equals(pw)){
			
			this.setAttribute(RtiSession.SESSION_PARAM_STATE, RtiSessionState.LOGGED);
			this.setAttribute(RtiSession.SESSION_PARAM_USER, user);
			
			return RtiSession.SESSION_SERVER_TOKEN;
			
		}else{
			
			throw new InvalidUsrPwException("Failed Authentication.");
		}
		
	}
	
	/**
	 * Invalidates the RtiSession.
	 */
	public void rtiLogout(){
		session.invalidate();
	}

	/**
	 * Returns the object bound with the specified name in this session, or null if no object is bound under the name.
	 * @param arg0 Name.
	 * @return Value.
	 */
	public Object getAttribute(String arg0) {
		
		return session.getAttribute(arg0);
	}

	/**
	 * Returns an Enumeration of String objects containing the names of all the objects bound to this session.
	 * @return Enumeration.
	 */
	public Enumeration getAttributeNames() {
		return session.getAttributeNames();
	}

	/**
	 * Returns the time when this session was created, measured in milliseconds since midnight January 1, 1970 GMT.
	 * @return Time.
	 */
	public long getCreationTime() {
		return session.getCreationTime();
	}

	/**
	 *  Returns a string containing the unique identifier assigned to this session.
	 * @return Id.
	 */
	public String getId() {
		return session.getId();
	}

	/**
	 * Returns the last time the client sent a request associated with this session, as the number of milliseconds since midnight January 1, 1970 GMT, and marked by the time the container received the request.
	 * @return Accessed Time.
	 */
	public long getLastAccessedTime() {
		return session.getLastAccessedTime();
	}

	/**
	 * Returns the maximum time interval, in seconds, that the servlet container will keep this session open between client accesses.
	 * @return MaxInactiveInterval.
	 */
	public int getMaxInactiveInterval() {
		return session.getMaxInactiveInterval();
	}

	/**
	 * Returns the ServletContext to which this session belongs.
	 * @return ServletContext.
	 */
	public ServletContext getServletContext() {
		return session.getServletContext();
	}

	/**
	 * Invalidates this session then unbinds any objects bound to it.
	 */
	public void invalidate() {
		session.invalidate();		
	}

	/**
	 * Returns true if the client does not yet know about the session or if the client chooses not to join the session.
	 * @return Boolean.
	 */
	public boolean isNew() {
		return session.isNew();
	}

	/**
	 * Removes the object bound with the specified name from this session.
	 * @param arg0 Name.
	 */
	public void removeAttribute(String arg0) {
		session.removeAttribute(arg0);
	}

	/**
	 *  Binds an object to this session, using the name specified.
	 * @param arg0 Name.
	 * @param arg1 Value.
	 */
	public void setAttribute(String arg0, Object arg1) {
		session.setAttribute(arg0, arg1);
	}

	/**
	 * Specifies the time, in seconds, between client requests before the servlet container will invalidate this session.
	 * @param arg0 MaxInactiveInterval
	 */
	public void setMaxInactiveInterval(int arg0) {
		session.setMaxInactiveInterval(arg0);
	}

}
