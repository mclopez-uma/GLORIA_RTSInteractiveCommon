package eu.gloria.rtc;

import java.util.List;

import eu.gloria.rt.entity.device.MeasureUnit;
import eu.gloria.rt.entity.device.SensorStateIntervalDouble;
import eu.gloria.rt.exception.RTException;
import eu.gloria.rtc.DeviceDiscoverer;
import eu.gloria.rtc.RainDetectorControlInterface;
import eu.gloria.rtd.RTDRainDetectorInterface;

/**
 * Generic RainDetectorControlInterface implementation
 * 
 * @author mclopez
 *
 */
public class RainSensorControl extends DeviceManager implements RainDetectorControlInterface{

	/**
	 * Constructor
	 */
	public RainSensorControl() {
		
	}

	@Override
	public MeasureUnit rndGetMeasureUnit(String deviceId) throws RTException {
		
		return  ((RTDRainDetectorInterface) DeviceDiscoverer.getRTD(deviceId)).rndGetMeasureUnit();
	}

	@Override
	public double rndGetMeasure(String deviceId) throws RTException {

		return  ((RTDRainDetectorInterface) DeviceDiscoverer.getRTD(deviceId)).rndGetMeasure();
	}

	@Override
	public void rndSetMeasureStates(String deviceId, List<SensorStateIntervalDouble> states) throws RTException {
		
		checkPreconditionOpRunning();

		((RTDRainDetectorInterface) DeviceDiscoverer.getRTD(deviceId)).rndSetMeasureStates(states);
		
	}

	@Override
	public List<SensorStateIntervalDouble> rndGetMeasureStates(String deviceId)
			throws RTException {

		return  ((RTDRainDetectorInterface) DeviceDiscoverer.getRTD(deviceId)).rndGetMeasureStates();
	}

	@Override
	public boolean rndIsRaining(String deviceId) throws RTException {

		return  ((RTDRainDetectorInterface) DeviceDiscoverer.getRTD(deviceId)).rndIsRaining();
	}

}
