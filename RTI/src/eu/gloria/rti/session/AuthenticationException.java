package eu.gloria.rti.session;

import eu.gloria.rt.exception.RTException;

/**
 * An error happened in the authentication process.
 * 
 * @author jcabello
 *
 */
public class AuthenticationException extends RTException {

	public AuthenticationException(){
	} 
	
	public AuthenticationException(String message){
		super(message); 
	} 
	
	public AuthenticationException(Throwable cause) { 
		super(cause); 
	}
	
}
