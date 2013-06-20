package eu.gloria.rtc;

import java.util.List;

import eu.gloria.rt.entity.device.MeasureUnit;
import eu.gloria.rt.entity.device.SensorStateIntervalDouble;
import eu.gloria.rt.entity.device.SensorStateIntervalLong;
import eu.gloria.rt.exception.RTException;
import eu.gloria.rtd.RTDStormSensorInterface;

public class StormSensorControl extends DeviceManager implements
		StormSensorControlInterface {

	@Override
	public boolean strIsAvailableOrientation(String deviceId)
			throws RTException {

		return  ((RTDStormSensorInterface) DeviceDiscoverer.getRTD(deviceId)).strIsAvailableOrientation();
	}

	@Override
	public MeasureUnit strGetDistanceMeasureUnit(String deviceId)
			throws RTException {
		
		return  ((RTDStormSensorInterface) DeviceDiscoverer.getRTD(deviceId)).strGetDistanceMeasureUnit();
	}

	@Override
	public long strGetDistanceMeasure(String deviceId) throws RTException {

		return  ((RTDStormSensorInterface) DeviceDiscoverer.getRTD(deviceId)).strGetDistanceMeasure();
	}

	@Override
	public double strGetDegrees(String deviceId) throws RTException {

		return  ((RTDStormSensorInterface) DeviceDiscoverer.getRTD(deviceId)).strGetDegrees();
	}

	@Override
	public double strGetAbosoluteDegrees(String deviceId) throws RTException {

		return  ((RTDStormSensorInterface) DeviceDiscoverer.getRTD(deviceId)).strGetAbosoluteDegrees();
	}

	@Override
	public void strSetDistanceMeasureStates(String deviceId,
			List<SensorStateIntervalLong> states) throws RTException {
		
		checkPreconditionOpRunning();

		((RTDStormSensorInterface) DeviceDiscoverer.getRTD(deviceId)).strSetDistanceMeasureStates(states);
	}

	@Override
	public List<SensorStateIntervalLong> strGetDistanceMeasureStates(String deviceId)
			throws RTException {

		return  ((RTDStormSensorInterface) DeviceDiscoverer.getRTD(deviceId)).strGetDistanceMeasureStates();
	}

	@Override
	public void strSetOrientationMeasureStates(String deviceId,
			List<SensorStateIntervalDouble> states) throws RTException {
		
		checkPreconditionOpRunning();

		((RTDStormSensorInterface) DeviceDiscoverer.getRTD(deviceId)).strSetOrientationMeasureStates(states);

	}

	@Override
	public List<SensorStateIntervalDouble> strGetOrientationMeasureStates(
			String deviceId) throws RTException {

		return  ((RTDStormSensorInterface) DeviceDiscoverer.getRTD(deviceId)).strGetOrientationMeasureStates();
	}

}
