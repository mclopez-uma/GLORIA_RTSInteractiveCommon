package eu.gloria.rtc;

import java.util.List;

import eu.gloria.rt.entity.device.DeviceProperty;
import eu.gloria.rt.entity.device.MeasureUnit;
import eu.gloria.rt.entity.device.SensorStateIntervalDouble;
import eu.gloria.rt.exception.RTException;
import eu.gloria.rtc.DeviceDiscoverer;
import eu.gloria.rtc.RHSensorControlInterface;
import eu.gloria.rtd.RTDRHSensorInterface;
import eu.gloria.rtd.RTDRainDetectorInterface;

/**
 * Generic RHSensorControlInterface implementation
 * 
 * @author mclopez
 *
 */
public class RHSensorControl extends DeviceManager implements RHSensorControlInterface {

	/**
	 * Constructor
	 */
	public RHSensorControl() {
		
	}

	@Override
	public MeasureUnit rhsGetMeasureUnit(String deviceId) throws RTException {

		return  ((RTDRHSensorInterface) DeviceDiscoverer.getRTD(deviceId)).rhsGetMeasureUnit();
	}

	@Override
	public double rhsGetMeasure(String deviceId) throws RTException {

		return  ((RTDRHSensorInterface) DeviceDiscoverer.getRTD(deviceId)).rhsGetMeasure();
	}

	@Override
	public void rhsSetMeasureStates(String deviceId, List<SensorStateIntervalDouble> states) throws RTException {
		
		checkPreconditionOpRunning();

		((RTDRHSensorInterface) DeviceDiscoverer.getRTD(deviceId)).rhsSetMeasureStates(states);
		
	}

	@Override
	public List<SensorStateIntervalDouble> rhsGetMeasureStates(String deviceId)
			throws RTException {
		
		return ((RTDRHSensorInterface) DeviceDiscoverer.getRTD(deviceId)).rhsGetMeasureStates();
	}	

	
}
