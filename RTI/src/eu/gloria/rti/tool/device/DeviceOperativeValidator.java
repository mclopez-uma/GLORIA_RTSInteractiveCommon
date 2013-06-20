package eu.gloria.rti.tool.device;

import eu.gloria.rt.exception.RTException;
import eu.gloria.rtc.device.validation.DeviceStateManager;
import eu.gloria.rtc.device.validation.RTCDeviceActivityException;
import eu.gloria.rtc.device.validation.RTCDeviceCommunicationException;
import eu.gloria.rtc.device.validation.RTCDeviceInAlarmException;
import eu.gloria.rti.RtiError;
import eu.gloria.rti.fault.ErrorDetail;
import eu.gloria.rti.fault.ErrorType;
import eu.gloria.rti.tool.Singleton;

public class DeviceOperativeValidator {
	
	/**
	 * Checks the device is operative.
	 * @param deviceId Device identifier
	 * @throws RtiError Error. 
	 */
	public static void checkIsOperative(String deviceId) throws RtiError{
		
		try{
			
			DeviceStateManager manager = new DeviceStateManager(Singleton.getRTC().devGetDevice(deviceId, true));
			manager.checkIsOperative();
			
		}catch(RTCDeviceCommunicationException ex){
			ErrorDetail detail = new ErrorDetail();
			detail.setType(ErrorType.DEVICE_COMMUNICATION);
			detail.setDesc(ex.getMessage());
			RtiError newEx = new RtiError(ex.getMessage(), detail);
			throw newEx;
		}catch(RTCDeviceInAlarmException ex){
			ErrorDetail detail = new ErrorDetail();
			detail.setType(ErrorType.DEVICE_IN_ALARM_STATE);
			detail.setDesc(ex.getMessage());
			RtiError newEx = new RtiError(ex.getMessage(), detail);
			throw newEx;
		}catch(RTCDeviceActivityException ex){
			ErrorDetail detail = new ErrorDetail();
			detail.setType(ErrorType.DEVICE_IN_WRONG_ACTIVITY_STATE);
			detail.setDesc(ex.getMessage());
			RtiError newEx = new RtiError(ex.getMessage(), detail);
			throw newEx;
		}catch(RTException ex){
			ErrorDetail detail = new ErrorDetail();
			detail.setType(ErrorType.GENERAL);
			detail.setDesc(ex.getMessage());
			RtiError newEx = new RtiError(ex.getMessage(), detail);
			throw newEx;
		}
		
		
		
	}

}
