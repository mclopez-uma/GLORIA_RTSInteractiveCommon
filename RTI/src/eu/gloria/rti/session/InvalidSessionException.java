package eu.gloria.rti.session;

import eu.gloria.rt.exception.RTException;

/**
 * The session is invalid (expired or uninitialized).
 * 
 * @author jcabello
 *
 */
public class InvalidSessionException extends RTException {

	public InvalidSessionException(){
	} 
	
	public InvalidSessionException(String message){
		super(message); 
	} 
	
	public InvalidSessionException(Throwable cause) { 
		super(cause); 
	}
}
