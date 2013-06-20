package eu.gloria.rti.session;

import java.security.KeyStore;
import java.security.PublicKey;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.ServletContext;

import eu.gloria.tools.cache.Cache;
import eu.gloria.tools.cache.CacheManager;
import eu.gloria.tools.cert.CertManager;
import eu.gloria.tools.configuration.Config;
import eu.gloria.tools.log.LogUtil;

/**
 * Session management based on server memory and session token. This implementation DOES NOT SUPPORT CLUSTER ENVIRONMENT.
 * If you need a cluster implementation, it's necessary a new implementation based on shared memory or data base.
 * @author jcabello
 *
 */
public class RtiSessionMemoryImpl extends RtiSession {
	
	public final static String SESSION_CACHE_NAME = "SESSION_TOKEN_IMPLEMENTATION";
	
	/**
	 * Session UUID
	 */
	private String uuid;
	
	private HashMap<String, Object> attributes;
	
	/**
	 * Creation date
	 */
	private Date creationDate;
	
	/**
	 * Static constructor
	 */
	static{
		
		//Creates the session Cache
		long sessionExpiration = Config.getPropertyLog("rti_config", "session.memory.implementation.expirationtime", 300000 /*5 minutes*/);
		CacheManager.createCache(SESSION_CACHE_NAME, sessionExpiration, null /*Retriever*/ );
	}
	
	/**
	 * Constructor.
	 */
	public RtiSessionMemoryImpl(){
		
		uuid = UUID.randomUUID().toString();
		attributes = new HashMap<String, Object>();
		creationDate = new Date();
		
		if (this.getAttribute(RtiSession.SESSION_PARAM_STATE) == null){
	     	this.setAttribute(RtiSession.SESSION_PARAM_STATE, RtiSessionState.UNLOGGED);
	    }
		 
	}
	
	
	
	/**
	 * Validates the current session is valid:
	 * -The session exists.
	 * -The user has been logged in the system.
	 * @throws InvalidSessionException If the session is not initialized.
	 */
	@Override
	public void rtiValidateSession() throws InvalidSessionException {
		RtiSessionState sessionState = (RtiSessionState)this.getAttribute(RtiSession.SESSION_PARAM_STATE);
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
				
				this.setAttribute(RtiSession.SESSION_PARAM_STATE, RtiSessionState.LOGGED);
				this.setAttribute(RtiSession.SESSION_PARAM_USER, user);
				
				return this.getUuid();
				
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
	 * @return Token.
	 * @throws AuthenticationException If the authentication fails.
	 * @throws InvalidUsrPwException If the user login or pw are wrong.
	 */
	@Override
	public String rtiLogin(String user, String pw)
			throws AuthenticationException, InvalidUsrPwException {
		
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
			
			return this.getUuid();
			
		}else{
			
			throw new InvalidUsrPwException("Failed Authentication.");
		}
		
		
	}

	/**
	 * Invalidates the RtiSession.
	 */
	@Override
	public void rtiLogout() {
		this.invalidate();

	}

	/**
	 * Returns the object bound with the specified name in this session, or null if no object is bound under the name.
	 * @param arg0 Name.
	 * @return Value.
	 */
	@Override
	public Object getAttribute(String arg0) {
		return attributes.get(arg0);
	}

	/**
	 * Returns an Enumeration of String objects containing the names of all the objects bound to this session.
	 * @return Enumeration.
	 */
	@Override
	public Enumeration getAttributeNames() {
		throw new RuntimeException("Unsupported method.");
	}

	/**
	 * Returns the time when this session was created, measured in milliseconds since midnight January 1, 1970 GMT.
	 * @return Time.
	 */
	@Override
	public long getCreationTime() {
		return creationDate.getTime();
	}

	/**
	 *  Returns a string containing the unique identifier assigned to this session.
	 * @return Id.
	 */
	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return this.uuid;
	}

	/**
	 * Returns the last time the client sent a request associated with this session, as the number of milliseconds since midnight January 1, 1970 GMT, and marked by the time the container received the request.
	 * @return Accessed Time.
	 */
	@Override
	public long getLastAccessedTime() {
		throw new RuntimeException("Unsupported method.");
	}

	/**
	 * Returns the maximum time interval, in seconds, that the servlet container will keep this session open between client accesses.
	 * @return MaxInactiveInterval.
	 */
	@Override
	public int getMaxInactiveInterval() {
		throw new RuntimeException("Unsupported method.");
	}

	/**
	 * Returns the ServletContext to which this session belongs.
	 * @return ServletContext.
	 */
	@Override
	public ServletContext getServletContext() {
		throw new RuntimeException("Unsupported method.");
	}

	/**
	 * Invalidates this session then unbinds any objects bound to it.
	 */
	@Override
	public void invalidate() {
		//Removes from cache
		Cache cache = CacheManager.getCache(SESSION_CACHE_NAME);
		cache.deleteObject(this.getUuid());
		
	}

	/**
	 * Returns true if the client does not yet know about the session or if the client chooses not to join the session.
	 * @return Boolean.
	 */
	@Override
	public boolean isNew() {
		throw new RuntimeException("Unsupported method.");
	}

	/**
	 * Removes the object bound with the specified name from this session.
	 * @param arg0 Name.
	 */
	@Override
	public void removeAttribute(String arg0) {
		attributes.remove(arg0);

	}

	/**
	 *  Binds an object to this session, using the name specified.
	 * @param arg0 Name.
	 * @param arg1 Value.
	 */
	@Override
	public void setAttribute(String arg0, Object arg1) {
		attributes.put(arg0, arg1);
	}

	/**
	 * Specifies the time, in seconds, between client requests before the servlet container will invalidate this session.
	 * @param arg0 MaxInactiveInterval
	 */
	@Override
	public void setMaxInactiveInterval(int arg0) {
		throw new RuntimeException("Unsupported method.");

	}

	/**
	 * Access method.
	 * @return UUID.
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * Access method
	 * @param uuid UUID
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}



}
