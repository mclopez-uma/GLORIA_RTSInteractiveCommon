package eu.gloria.rti.tool.http;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.codec.binary.Base64;

/**
 * Recovers the HTTP Authorization header ("authorization")
 * 
 * The value into the header is: 'USER:PW'
 * 
 * @author jcabello
 *
 */
public class AuthorizationHTTP {

	/**
	 * User login inside the HTTP header
	 */
	private String user;
	
	/**
	 * User pw inside the HTTP header
	 */
	private String pw;
	
	/**
	 * Flag indicatin if the information is inside the header.
	 */
	private boolean sentData; 
	
	/**
	 * Constructor
	 * @param request HTTP REQUEST
	 * @throws Exception In error case
	 */
	public AuthorizationHTTP(HttpServletRequest request) throws Exception{
		
		user = null;
		pw = null;
		sentData = false;
		
		String authHeader = request.getHeader("authorization");
		String encodedValue = authHeader.split(" ")[1];
		byte[] decodeBytes = Base64.decodeBase64(encodedValue.getBytes());
		String decodedValue = new String(decodeBytes, "UTF8"); //USER:PW
		String[] parts = decodedValue.split(":");
		if (parts.length > 2) throw new Exception("AuthorizationHTTP:: User or PW has the character ':'");
		if (parts.length < 2) throw new Exception("AuthorizationHTTP:: User and PW are needed");
		
		user = parts[0];
		pw = parts[1];
		
		sentData = true;
		
	}

	/**
	 * Access method.
	 * @return User who access throw HTTP
	 */
	public String getUser() {
		return user;
	}


	/**
	 * Access method.
	 * @return Password of the user who access throw HTTP.
	 */
	public String getPw() {
		return pw;
	}

	/**
	 * Access method 
	 * @return true if user information exists on the http header
	 */
	public boolean isSentData() {
		return sentData;
	}
	
}
