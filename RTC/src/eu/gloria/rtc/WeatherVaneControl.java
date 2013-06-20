package eu.gloria.rtc;

import java.util.List;

import eu.gloria.rt.entity.device.MeasureUnit;
import eu.gloria.rt.entity.device.SensorStateIntervalDouble;
import eu.gloria.rt.exception.RTException;
import eu.gloria.rtd.RTDWeatherVaneInterface;

public class WeatherVaneControl extends DeviceManager implements
		WeatherVaneControlInterface {

	@Override
	public MeasureUnit wvnGetMeasureUnit(String deviceId) throws RTException {
		
		return  ((RTDWeatherVaneInterface) DeviceDiscoverer.getRTD(deviceId)).wvnGetMeasureUnit();
	}

	@Override
	public double wvnGetMeasure(String deviceId) throws RTException {

		return  ((RTDWeatherVaneInterface) DeviceDiscoverer.getRTD(deviceId)).wvnGetMeasure();
	}

	@Override
	public double wvnGetAbosluteDegrees(String deviceId) throws RTException {

		return  ((RTDWeatherVaneInterface) DeviceDiscoverer.getRTD(deviceId)).wvnGetAbosluteDegrees();
	}

	@Override
	public void wvnSetMeasureStates(String deviceId,
			List<SensorStateIntervalDouble> states) throws RTException {
		
		checkPreconditionOpRunning();

		((RTDWeatherVaneInterface) DeviceDiscoverer.getRTD(deviceId)).wvnSetMeasureStates(states);

	}

	@Override
	public List<SensorStateIntervalDouble> wvnGetMeasureStates(String deviceId)
			throws RTException {

		return  ((RTDWeatherVaneInterface) DeviceDiscoverer.getRTD(deviceId)).wvnGetMeasureStates();
	}

}
