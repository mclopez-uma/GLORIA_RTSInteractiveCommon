package eu.gloria.rti.session;

import javax.xml.ws.WebServiceContext;

import eu.gloria.rt.exception.RTException;
import eu.gloria.tools.cache.Cache;
import eu.gloria.tools.cache.CacheManager;
import eu.gloria.tools.log.LogUtil;

/**
 * Factory to recover the RTI session.
 * This version USES RtiServerImpl sessions.
 * @author jcabello
 *
 */
public class RtiSessionFactory {
	
	/**
	 * Invalid session (singleton).
	 */
	private static RtiSessionInvalid invalidSession;
	
	/**
	 * Static constructor.
	 */
	static {
		invalidSession = new RtiSessionInvalid();
	}
	
	/**
	 * Returns the current RtiSession.
	 * @param wsContext WebServiceContext
	 * @param sessionToken Token representing the session
	 * @return The current session.
	 * @throws InvalidSessionException If the session is not initialized.
	 */
	public static RtiSession getSession(WebServiceContext wsContext, String sessionToken) throws InvalidSessionException{
		
		if (sessionToken == null || 
			sessionToken.trim().isEmpty() || 
			RtiSessionServerImpl.SESSION_SERVER_TOKEN.equals(sessionToken)){ //Server implementation
			
			return getSession(wsContext);
			
		}else{ //Token implementation
			
			Cache sessionCache = CacheManager.getCache(RtiSessionMemoryImpl.SESSION_CACHE_NAME);
			Object sessionObj = null;
			if (RtiSessionMemoryImpl.TOKEN_FOR_CREATING_NEW_SESSION.equals(sessionToken)){ 
				 
				//Create a new session and put it into the cache.
				LogUtil.info (null, "SessionType: RtiSessionMemoryImpl");
				RtiSessionMemoryImpl tmpSession = new RtiSessionMemoryImpl();
				sessionCache.putObject(tmpSession.getUuid(), tmpSession);
				sessionObj = tmpSession;
				
			}else{ //The session token exists 
				
				try{
					sessionObj = sessionCache.getObject(sessionToken, null /*params*/);
					if (sessionObj == null){
						//The session is expired -> return an invalid RtiSessionImplementation
						sessionObj = invalidSession;
					}
				}catch(RTException ex){
					sessionObj = invalidSession;
				}
				
				
			}
			return (RtiSession) sessionObj ;
			
		}
		
	}
	
	/**
	 * Returns the current RtiSession.
	 * @param wsContext WebServiceContext
	 * @return The current session.
	 * @throws InvalidSessionException If the session is not initialized.
	 */
	public static RtiSession getSession(WebServiceContext wsContext)  throws InvalidSessionException{
		LogUtil.info (null, "SessionType: RtiSessionServerImpl");
		return new RtiSessionServerImpl(wsContext);
	}

}
