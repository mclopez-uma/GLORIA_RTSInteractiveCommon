package eu.gloria.rtc;

import java.util.List;

import eu.gloria.rt.entity.device.MeasureUnit;
import eu.gloria.rt.entity.device.SensorStateIntervalDouble;
import eu.gloria.rt.exception.RTException;
import eu.gloria.rtc.DeviceDiscoverer;
import eu.gloria.rtc.WindSpeedControlInterface;
import eu.gloria.rtd.RTDRainDetectorInterface;
import eu.gloria.rtd.RTDWindSpeedInterface;

/**
 * Generic WindSpeedSensorControlInterface implementation
 * 
 * @author mclopez
 *
 */
public class WindSpeedSensorControl extends DeviceManager implements WindSpeedControlInterface {

	/**
	 * Constructor
	 */
	public WindSpeedSensorControl() {
		
	}

	@Override
	public MeasureUnit wspGetMeasureUnit(String deviceId) throws RTException {
		
		return  ((RTDWindSpeedInterface) DeviceDiscoverer.getRTD(deviceId)).wspGetMeasureUnit();
	}

	@Override
	public double wspGetMeasure(String deviceId) throws RTException {

		return  ((RTDWindSpeedInterface) DeviceDiscoverer.getRTD(deviceId)).wspGetMeasure();
	}

	@Override
	public void wspSetMeasureStates(String deviceId, List<SensorStateIntervalDouble> states) throws RTException {
		
		checkPreconditionOpRunning();

		((RTDWindSpeedInterface) DeviceDiscoverer.getRTD(deviceId)).wspSetMeasureStates(states);

	}

	@Override
	public List<SensorStateIntervalDouble> wspGetMeasureStates(String deviceId)
			throws RTException {
		
		return ((RTDWindSpeedInterface) DeviceDiscoverer.getRTD(deviceId)).wspGetMeasureStates();
	}

}
