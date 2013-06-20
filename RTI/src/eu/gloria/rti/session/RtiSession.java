package eu.gloria.rti.session;

import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import eu.gloria.tools.configuration.Config;

/**
 * RTI Session Superclass.
 * All Session Controller must inherit from this class
 * @author jcabello
 *
 */
public abstract class RtiSession { 
	
	public static final String SESSION_SERVER_TOKEN = "USING_SERVER_SESSION";
	public static final String SESSION_PARAM_STATE = "SESSION_STATE";
	public static final String SESSION_PARAM_USER = "SESSION_USER";
	
	public static final String SESSION_UNKNOWN_USER = "UNKNOWN_USER";
	
	public final static String TOKEN_FOR_CREATING_NEW_SESSION = "CREATE_NEW_SESSION";
	
	public static final String CONFIG_CONSTANT_LOGIN_HTTP_AUTH = "LOGIN_HTTP_AUTH";
	public static final String CONFIG_CONSTANT_LOGIN_WS_METHOD = "LOGIN_WS_METHOD";
	
	/**
	 * Recovers the user login.
	 * 
	 * @return User login.
	 */
	public String rtiGetUser(){
		
		String result = (String)this.getAttribute(RtiSession.SESSION_PARAM_USER);
		if (result == null){
			result = SESSION_UNKNOWN_USER;
		}
		return result;
		
	}
	
	/**
	 * Returns true if the authentication method is based on user/pw into the HTTP head.
	 * @return boolean
	 */
	public boolean isEnabledLoginAuthenticationHTTP(){
		String mode =  Config.getProperty("rti_config", "login.mode", CONFIG_CONSTANT_LOGIN_WS_METHOD);
		return mode.equals(CONFIG_CONSTANT_LOGIN_HTTP_AUTH); 
	}
	
	/**
	 * Returns true if the authentication method is based on web service methods.
	 * @return boolean
	 */
	public boolean isEnabledLoginWsMethod(){
		String mode =  Config.getProperty("rti_config", "login.mode", CONFIG_CONSTANT_LOGIN_WS_METHOD);
		return mode.equals(CONFIG_CONSTANT_LOGIN_WS_METHOD); 
	}
	

	/**
	 * Validates the current session is valid:
	 * -The session exists.
	 * -The user has been logged in the system.
	 * @throws InvalidSessionException If the session is not initialized.
	 */
	public abstract void rtiValidateSession() throws InvalidSessionException;
	
	
	/**
	 * Authenticates the user using X509 private key of Gloria System.
	 * @param user User name.
	 * @param time Client datetime.
	 * @param sign Sign using private key of Gloria System. The sign content is: SIGN[user + time].
	 * @returnToken or "USING_SERVER_SESSION" is token mechanism is not used.
	 * @throws AuthenticationException If the authentication fails.
	 * @throws InvalidUsrPwException If the user login or pw are wrong.
	 */
	public abstract String rtiLoginCert(String user, Date date, String sign) throws AuthenticationException, InvalidUsrPwException;
	
	
	
	/**
	 * Authenticate the user into the system.
	 * @param user User name.
	 * @param pw Password.
	 * @returnToken or "USING_SERVER_SESSION" is token mechanism is not used.
	 * @throws AuthenticationException If the authentication fails.
	 * @throws InvalidUsrPwException If the user login or pw are wrong.
	 */
	public abstract String rtiLogin(String user, String pw) throws AuthenticationException, InvalidUsrPwException;
	
	
	
	/**
	 * Invalidates the RtiSession.
	 */
	public abstract void rtiLogout();

	/**
	 * Returns the object bound with the specified name in this session, or null if no object is bound under the name.
	 * @param arg0 Name.
	 * @return Value.
	 */
	public abstract Object getAttribute(String arg0);

	/**
	 * Returns an Enumeration of String objects containing the names of all the objects bound to this session.
	 * @return Enumeration.
	 */
	public abstract Enumeration getAttributeNames() ;

	/**
	 * Returns the time when this session was created, measured in milliseconds since midnight January 1, 1970 GMT.
	 * @return Time.
	 */
	public abstract long getCreationTime();

	/**
	 *  Returns a string containing the unique identifier assigned to this session.
	 * @return Id.
	 */
	public abstract String getId();

	/**
	 * Returns the last time the client sent a request associated with this session, as the number of milliseconds since midnight January 1, 1970 GMT, and marked by the time the container received the request.
	 * @return Accessed Time.
	 */
	public abstract long getLastAccessedTime();

	/**
	 * Returns the maximum time interval, in seconds, that the servlet container will keep this session open between client accesses.
	 * @return MaxInactiveInterval.
	 */
	public abstract int getMaxInactiveInterval();

	/**
	 * Returns the ServletContext to which this session belongs.
	 * @return ServletContext.
	 */
	public abstract ServletContext getServletContext();

	/**
	 * Invalidates this session then unbinds any objects bound to it.
	 */
	public abstract void invalidate();

	/**
	 * Returns true if the client does not yet know about the session or if the client chooses not to join the session.
	 * @return Boolean.
	 */
	public abstract boolean isNew();

	/**
	 * Removes the object bound with the specified name from this session.
	 * @param arg0 Name.
	 */
	public abstract void removeAttribute(String arg0);

	/**
	 *  Binds an object to this session, using the name specified.
	 * @param arg0 Name.
	 * @param arg1 Value.
	 */
	public abstract void setAttribute(String arg0, Object arg1);

	/**
	 * Specifies the time, in seconds, between client requests before the servlet container will invalidate this session.
	 * @param arg0 MaxInactiveInterval
	 */
	public abstract void setMaxInactiveInterval(int arg0);
	
}
