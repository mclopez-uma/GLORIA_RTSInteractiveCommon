package eu.gloria.rtc;

import eu.gloria.rt.entity.device.Device;
import eu.gloria.rt.entity.device.DeviceFocuser;
import eu.gloria.rt.entity.device.DeviceProperty;
import eu.gloria.rt.entity.device.DeviceType;
import eu.gloria.rt.exception.RTException;
import eu.gloria.rtc.DeviceDiscoverer;
import eu.gloria.rtc.FocuserInterface;
import eu.gloria.rtd.RTDFocuserInterface;

public class FocuserControl extends DeviceManager implements FocuserInterface {
	
	
	/**
	 * Returns the DeviceMount of the specified device identifier.
	 * 
	 * @param deviceId Device identifier.
	 * @return {@link DeviceFocuser }
	 * @throws RTException In error case.
	 */
	private DeviceFocuser getFocuserDevice (String deviceId) throws RTException{
		
		Device dev =  this.devGetDevice(deviceId, true);
		
		if (dev.getType() != DeviceType.FOCUS)
			throw new RTException("The device type is not correct.");
		
		return (DeviceFocuser) dev;
	}
	
	
	/**
	 * Constructor
	 */
	public FocuserControl () {
		
	}
	
	@Override
	public boolean focIsAbsolute(String deviceId) throws RTException {
				
		getFocuserDevice (deviceId);
		return  ((RTDFocuserInterface) DeviceDiscoverer.getRTD(deviceId)).focIsAbsolute();
		
	}

	@Override
	public double focGetStepSize(String deviceId) throws RTException {
		
		getFocuserDevice (deviceId);
		return  ((RTDFocuserInterface) DeviceDiscoverer.getRTD(deviceId)).focGetStepSize();
	}

	@Override
	public long focGetMaxIncrement(String deviceId) throws RTException {
		getFocuserDevice (deviceId);
		return  ((RTDFocuserInterface) DeviceDiscoverer.getRTD(deviceId)).focGetMaxIncrement();
	}

	@Override
	public long focGetMaxStep(String deviceId) throws RTException {
		getFocuserDevice (deviceId);
		return  ((RTDFocuserInterface) DeviceDiscoverer.getRTD(deviceId)).focGetMaxStep();
	}

	//Falla pq devuelve un double!!
	@Override
	public long focGetPosition(String deviceId) throws RTException {
		
		getFocuserDevice (deviceId);
		return  ((RTDFocuserInterface) DeviceDiscoverer.getRTD(deviceId)).focGetPosition();
	}

	@Override
	public boolean focIsTempCompAvailable(String deviceId) throws RTException {
		
		getFocuserDevice (deviceId);
		return  ((RTDFocuserInterface) DeviceDiscoverer.getRTD(deviceId)).focIsTempCompAvailable();
	}

	@Override
	public double focGetTemperature(String deviceId) throws RTException {
		
		getFocuserDevice (deviceId);
		return  ((RTDFocuserInterface) DeviceDiscoverer.getRTD(deviceId)).focGetTemperature();
	}

	@Override
	public void focSetTempComp(String deviceId, boolean trackingMode) throws RTException {
		
		checkPreconditionOpRunning();

		getFocuserDevice (deviceId);
		((RTDFocuserInterface) DeviceDiscoverer.getRTD(deviceId)).focSetTempComp(trackingMode);

	}


	@Override
	public void focHalt(String deviceId) throws RTException {
		
		checkPreconditionOpRunning();

		getFocuserDevice (deviceId);
		((RTDFocuserInterface) DeviceDiscoverer.getRTD(deviceId)).focHalt();

	}

	@Override
	public void focMove(String deviceId, long position) throws RTException {
		
		checkPreconditionOpRunning();

		getFocuserDevice (deviceId);
		((RTDFocuserInterface) DeviceDiscoverer.getRTD(deviceId)).focMove(position);

	}


	@Override
	public String focGetCamera(String deviceId) throws RTException {
		
		getFocuserDevice (deviceId);
		return ((RTDFocuserInterface) DeviceDiscoverer.getRTD(deviceId)).focGetCamera();
	}


	@Override
	public long focGetMinStep(String deviceId) throws RTException {

		getFocuserDevice (deviceId);
		return ((RTDFocuserInterface) DeviceDiscoverer.getRTD(deviceId)).focGetMinStep();
	}

}
