package eu.gloria.rtc;

import java.util.List;

import eu.gloria.rt.entity.device.MeasureUnit;
import eu.gloria.rt.entity.device.SensorStateIntervalDouble;
import eu.gloria.rt.exception.RTException;
import eu.gloria.rtd.RTDTemperatureSensorInterface;

/**
 * Generic TemperatureSensorControlInterface implementation
 * 
 * @author jcabello
 *
 */
public class TemperatureSensorControl extends DeviceManager implements TemperatureSensorControlInterface {
	
	/**
	 * Constructor
	 */
	public TemperatureSensorControl() {
		
	}

	@Override
	public MeasureUnit tempGetMeasureUnit(String deviceId) throws RTException {

		return  ((RTDTemperatureSensorInterface) DeviceDiscoverer.getRTD(deviceId)).tempGetMeasureUnit();
	}

	@Override
	public double tempGetMeasure(String deviceId) throws RTException {

		return  ((RTDTemperatureSensorInterface) DeviceDiscoverer.getRTD(deviceId)).tempGetMeasure();
	}

	@Override
	public void tempSetMeasureStates(String deviceId, List<SensorStateIntervalDouble> states) throws RTException {
		
		checkPreconditionOpRunning();

		((RTDTemperatureSensorInterface) DeviceDiscoverer.getRTD(deviceId)).tempSetMeasureStates(states);
		
	}

	@Override
	public List<SensorStateIntervalDouble> tempGetMeasureStates(String deviceId)
			throws RTException {
		
		return ((RTDTemperatureSensorInterface) DeviceDiscoverer.getRTD(deviceId)).tempGetMeasureStates();
	}	

}
