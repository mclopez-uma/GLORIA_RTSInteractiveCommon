package eu.gloria.rti.session;

import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletContext;


/**
 * Invalid session implementation.
 * This class is used when a session expired.
 * Its rtiValidateSession raises an InvalidSessionException (always).
 * 
 * @author jcabello
 *
 */
public class RtiSessionInvalid extends RtiSession {

	@Override
	public void rtiValidateSession() throws InvalidSessionException {
		throw new InvalidSessionException("The session is invalid.");
	}
	
	@Override
	public String rtiLoginCert(String user, Date date, String sign)
			throws AuthenticationException, InvalidUsrPwException {
		// TODO Auto-generated method stub
		
		if (isEnabledLoginAuthenticationHTTP()){
			throw new AuthenticationException("This operation is unavailable due to configuration reasons.");
		}
		
		return null;
	}

	@Override
	public String rtiLogin(String user, String pw)
			throws AuthenticationException, InvalidUsrPwException {
		// TODO Auto-generated method stub
		
		if (isEnabledLoginAuthenticationHTTP()){
			throw new AuthenticationException("This operation is unavailable due to configuration reasons.");
		}
		
		return null; 
	}

	@Override
	public void rtiLogout() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getAttribute(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Enumeration getAttributeNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getCreationTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getLastAccessedTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxInactiveInterval() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ServletContext getServletContext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void invalidate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isNew() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeAttribute(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAttribute(String arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMaxInactiveInterval(int arg0) {
		// TODO Auto-generated method stub
		
	}



}
