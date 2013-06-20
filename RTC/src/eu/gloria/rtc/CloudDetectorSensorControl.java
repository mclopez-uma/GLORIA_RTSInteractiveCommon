package eu.gloria.rtc;

import java.util.List;

import eu.gloria.rt.entity.device.MeasureUnit;
import eu.gloria.rt.entity.device.SensorStateIntervalDouble;
import eu.gloria.rt.exception.RTException;
import eu.gloria.rtc.CloudDetectorInterface;
import eu.gloria.rtc.DeviceDiscoverer;
import eu.gloria.rtd.RTDCloudDetectorInterface;
import eu.gloria.rtd.RTDWindSpeedInterface;

/**
 * Generic CloudDetectorInterface implementation
 * 
 * @author mclopez
 *
 */
public class CloudDetectorSensorControl extends DeviceManager implements CloudDetectorInterface {

	
	@Override
	public MeasureUnit cldGetMeasureUnit(String deviceId) throws RTException {
		
		return  ((RTDCloudDetectorInterface) DeviceDiscoverer.getRTD(deviceId)).cldGetMeasureUnit();
	}
	
	@Override
	public double cldGetMeasure(String deviceId) throws RTException {
		
		return ((RTDCloudDetectorInterface) DeviceDiscoverer.getRTD(deviceId)).cldGetMeasure();
	}

	@Override
	public void cldSetMeasureStates(String deviceId, List<SensorStateIntervalDouble> states) throws RTException {
		
		checkPreconditionOpRunning();
		
		((RTDCloudDetectorInterface) DeviceDiscoverer.getRTD(deviceId)).cldSetMeasureStates(states);
	}

	@Override
	public List<SensorStateIntervalDouble> cldGetMeasureStates(String deviceId)	throws RTException {
		
		return ((RTDCloudDetectorInterface) DeviceDiscoverer.getRTD(deviceId)).cldGetMeasureStates();
	}
	

}
