package eu.gloria.rti.session;

import eu.gloria.rt.exception.RTException;

/**
 * The user name or/and password is/are wrong.
 *  
 * @author jcabello
 *
 */
public class InvalidUsrPwException extends RTException {

	public InvalidUsrPwException(){
	} 
	
	public InvalidUsrPwException(String message){
		super(message); 
	} 
	
	public InvalidUsrPwException(Throwable cause) { 
		super(cause); 
	}
	
}
