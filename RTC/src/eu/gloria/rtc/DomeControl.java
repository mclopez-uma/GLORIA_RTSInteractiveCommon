package eu.gloria.rtc;

import eu.gloria.rt.entity.device.ActivityStateDomeOpening;
import eu.gloria.rt.entity.device.Device;
import eu.gloria.rt.entity.device.DeviceDome;
import eu.gloria.rt.entity.device.DeviceMount;
import eu.gloria.rt.entity.device.DeviceProperty;
import eu.gloria.rt.entity.device.DeviceType;
import eu.gloria.rt.exception.RTException;
import eu.gloria.rtc.DeviceDiscoverer;
import eu.gloria.rtc.DomeControlInterface;
import eu.gloria.rtd.RTDDomeInterface;

public class DomeControl extends DeviceManager implements DomeControlInterface{

	/**
	 * Returns the DeviceDome of the specified device identifier.
	 * 
	 * @param deviceId Device identifier.
	 * @return {@link DeviceDome}
	 * @throws RTException In error case.
	 */
	private DeviceDome getDomeDevice (String deviceId) throws RTException{
		
		Device dev =  this.devGetDevice(deviceId, true);
		
		if ((dev.getType() != DeviceType.DOME) & (dev.getType() != DeviceType.CUPOLA))
			throw new RTException("The device type is not correct.");

		
		return (DeviceDome) dev;
	}
		
	
	
	/**
	 * Constructor
	 */
	public DomeControl () {
		
	}
	
	@Override
	public int domGetNumberElement(String deviceId) throws RTException {
		
		getDomeDevice (deviceId);
		return  ((RTDDomeInterface) DeviceDiscoverer.getRTD(deviceId)).domGetNumberElement();
	}

	@Override
	public boolean domCanSetAltitude(String deviceId) throws RTException {
		
		getDomeDevice (deviceId);
		return  ((RTDDomeInterface) DeviceDiscoverer.getRTD(deviceId)).domCanSetAltitude();

	}

	@Override
	public boolean domCanSetAzimuth(String deviceId) throws RTException {
		
		getDomeDevice (deviceId);
		return  ((RTDDomeInterface) DeviceDiscoverer.getRTD(deviceId)).domCanSetAzimuth();

	}

	@Override
	public boolean domCanSetPark(String deviceId) throws RTException {

		getDomeDevice (deviceId);
		return  ((RTDDomeInterface) DeviceDiscoverer.getRTD(deviceId)).domCanSetPark();
	}

	@Override
	public boolean domIsAtHome(String deviceId) throws RTException {

		getDomeDevice (deviceId);
		return  ((RTDDomeInterface) DeviceDiscoverer.getRTD(deviceId)).domIsAtHome();
	}

	@Override
	public boolean domIsAtPark(String deviceId) throws RTException {

		getDomeDevice (deviceId);
		return  ((RTDDomeInterface) DeviceDiscoverer.getRTD(deviceId)).domIsAtPark();
	}

	@Override
	public double domGetAltitude(String deviceId) throws RTException {

		getDomeDevice (deviceId);
		return  ((RTDDomeInterface) DeviceDiscoverer.getRTD(deviceId)).domGetAltitude();
	}

	@Override
	public double domGetAzimuth(String deviceId) throws RTException {

		getDomeDevice (deviceId);
		return  ((RTDDomeInterface) DeviceDiscoverer.getRTD(deviceId)).domGetAzimuth();
	}

	@Override
	public void domOpen(String deviceId, int element) throws RTException {
		
		checkPreconditionOpRunning();

		getDomeDevice (deviceId);
		((RTDDomeInterface) DeviceDiscoverer.getRTD(deviceId)).domOpen(element);
		
	}

	@Override
	public void domClose(String deviceId, int element) throws RTException {
		
		checkPreconditionOpRunning();

		getDomeDevice (deviceId);
		((RTDDomeInterface) DeviceDiscoverer.getRTD(deviceId)).domClose(element);

	}

	@Override
	public void domGoHome(String deviceId) throws RTException {
		
		checkPreconditionOpRunning();

		getDomeDevice (deviceId);
		((RTDDomeInterface) DeviceDiscoverer.getRTD(deviceId)).domGoHome();
		
	}

	@Override
	public void domSetPark(String deviceId, double altitude, double azimuth)
			throws RTException {
		
		checkPreconditionOpRunning();

		getDomeDevice (deviceId);
		((RTDDomeInterface) DeviceDiscoverer.getRTD(deviceId)).domSetPark(altitude, azimuth);
		
	}

	@Override
	public void domPark(String deviceId) throws RTException {
		
		checkPreconditionOpRunning();

		getDomeDevice (deviceId);
		((RTDDomeInterface) DeviceDiscoverer.getRTD(deviceId)).domPark();
		
	}

	@Override
	public void domMoveAzimuth(String deviceId, double azimuth)
			throws RTException {
		
		checkPreconditionOpRunning();

		getDomeDevice (deviceId);
		((RTDDomeInterface) DeviceDiscoverer.getRTD(deviceId)).domMoveAzimuth(azimuth);
		
	}

	@Override
	public void domMoveAltitude(String deviceId, double altitude)
			throws RTException {
		
		checkPreconditionOpRunning();

		getDomeDevice (deviceId);
		((RTDDomeInterface) DeviceDiscoverer.getRTD(deviceId)).domMoveAltitude(altitude);
		
	}



	@Override
	public void domSetTracking(String deviceId, boolean value)
			throws RTException {
		
		checkPreconditionOpRunning();

		getDomeDevice (deviceId);
		((RTDDomeInterface) DeviceDiscoverer.getRTD(deviceId)).domSetTracking(value);
		
	}



	@Override
	public boolean domGetTracking(String deviceId) throws RTException {

		getDomeDevice (deviceId);
		return ((RTDDomeInterface) DeviceDiscoverer.getRTD(deviceId)).domGetTracking();
		
	}



	@Override
	public void domSlewObject(String deviceId, String object)
			throws RTException {
		
		checkPreconditionOpRunning();

		getDomeDevice (deviceId);
		((RTDDomeInterface) DeviceDiscoverer.getRTD(deviceId)).domSlewObject(object);
		
	}

}
