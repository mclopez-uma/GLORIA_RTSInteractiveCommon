package eu.gloria.rti.tool;

import java.math.BigInteger;

import eu.gloria.rt.exception.CommunicationException;
import eu.gloria.rt.exception.ExecutorWrongState;
import eu.gloria.rt.exception.RTException;
import eu.gloria.rt.exception.UnsupportedOpException;
import eu.gloria.rti.RtiError;
import eu.gloria.rti.fault.ErrorDetail;
import eu.gloria.rti.fault.ErrorType;
import eu.gloria.tools.log.LogUtil;


/**
 * RtiError Factory. 
 * 
 * @author jcabello
 *
 */
public class RtiExceptionFactory {
	
	/**
	 * This class builds RtiException taking into account the Input Exception.
	 * @param inEx Generated input exception.
	 * @return RtiError for WebService.
	 */
	public static RtiError getRtiException(Exception inEx){
		
		ErrorDetail detail = new ErrorDetail();
		
		detail.setDesc(inEx.getMessage());
		
		try{
			
			throw inEx;
			
		} catch (ExecutorWrongState e) {
			detail.setCode(e.getErrorCode());
			detail.setType(ErrorType.EXECUTOR_WRONG_STATE);
			LogUtil.severe(null, "ErrorType.EXECUTOR_WRONG_STATE. ErrorCode=" + e.getErrorCode() + ". " + inEx.getMessage());
		} catch (UnsupportedOpException e) {
			detail.setCode(e.getErrorCode());
			detail.setType(ErrorType.UNSUPPORTED);
			LogUtil.severe(null, "ErrorType.UNSUPPORTED. ErrorCode=" + e.getErrorCode() + ". " + inEx.getMessage());
		} catch (CommunicationException e) {
			detail.setCode(e.getErrorCode());
			detail.setType(ErrorType.DEVICE_COMMUNICATION);
			LogUtil.severe(null, "ErrorType.DEVICE_COMMUNICATION. ErrorCode=" + e.getErrorCode() + ". " + inEx.getMessage());
		} catch (RTException e) {
			detail.setCode(e.getErrorCode());
			detail.setType(ErrorType.GENERAL);
			LogUtil.severe(null, "ErrorType.GENERAL. ErrorCode=" + e.getErrorCode() + ". " + inEx.getMessage());
		} catch (Exception e) {
			detail.setCode(new BigInteger("1"));
			detail.setType(ErrorType.GENERAL);
			LogUtil.severe(null, "ErrorType.GENERAL" + inEx.getMessage());
		}
		
		//inEx.printStackTrace();
		
		RtiError error = new RtiError(inEx.getMessage(), detail);
		return error;
	}

}
