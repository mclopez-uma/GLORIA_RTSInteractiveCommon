package eu.gloria.rtc;

import java.util.List;

import eu.gloria.rt.entity.device.MeasureUnit;
import eu.gloria.rt.entity.device.SensorStateIntervalDouble;
import eu.gloria.rt.exception.RTException;
import eu.gloria.rtd.RTDBarometerInterface;

/**
 * Generic BarometerControlInterface implementation
 * 
 * @author jcabello
 *
 */
public class BarometerControl extends DeviceManager implements BarometerControlInterface {
	
	/**
	 * Constructor
	 */
	public BarometerControl() {
		
	}

	@Override
	public MeasureUnit barGetMeasureUnit(String deviceId) throws RTException {

		return  ((RTDBarometerInterface) DeviceDiscoverer.getRTD(deviceId)).barGetMeasureUnit();
	}

	@Override
	public double barGetMeasure(String deviceId) throws RTException {

		return  ((RTDBarometerInterface) DeviceDiscoverer.getRTD(deviceId)).barGetMeasure();
	}

	@Override
	public void barSetMeasureStates(String deviceId, List<SensorStateIntervalDouble> states) throws RTException {
		
		checkPreconditionOpRunning();

		((RTDBarometerInterface) DeviceDiscoverer.getRTD(deviceId)).barSetMeasureStates(states);
		
	}

	@Override
	public List<SensorStateIntervalDouble> barGetMeasureStates(String deviceId)
			throws RTException {
		
		return ((RTDBarometerInterface) DeviceDiscoverer.getRTD(deviceId)).barGetMeasureStates();
	}	

}
