package eu.gloria.rtc;

import eu.gloria.rt.entity.device.Device;
import eu.gloria.rt.entity.device.DeviceCamera;
import eu.gloria.rt.entity.device.DeviceRotator;
import eu.gloria.rt.entity.device.DeviceType;
import eu.gloria.rt.exception.RTException;
import eu.gloria.rtc.DeviceDiscoverer;
import eu.gloria.rtc.RotatorInterface;
import eu.gloria.rtd.RTDRotatorInterface;

/**
 * RTS2 RotatorInterface implementation
 * 
 * @author mclopez
 *
 */
public class RotatorControl extends DeviceManager implements RotatorInterface {

	/**
	 * Returns the DeviceCamera of the specified device identifier.
	 * 
	 * @param deviceId Device identifier.
	 * @return {@link DeviceCamera}
	 * @throws RTException In error case.
	 */
	private DeviceRotator getRotatorDevice (String deviceId) throws RTException{
		
		Device dev =  this.devGetDevice(deviceId, false);

		if (dev.getType() != DeviceType.ROTATOR) 
			throw new RTException("The device type is not correct.");
		
		return (DeviceRotator) dev;
	}

	/**
	 * Constructor
	 */
	public RotatorControl () {
		
	}
	
	@Override
	public double rttGetCurrentPosition(String deviceId) throws RTException {
		
		getRotatorDevice (deviceId);
		return  ((RTDRotatorInterface) DeviceDiscoverer.getRTD(deviceId)).rttGetCurrentPosition();
	}

	@Override
	public void rttSetTargetPosition(String deviceId, double position)
			throws RTException {
		
		checkPreconditionOpRunning();

		getRotatorDevice (deviceId);
		((RTDRotatorInterface) DeviceDiscoverer.getRTD(deviceId)).rttSetTargetPosition(position);

	}

}
