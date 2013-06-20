package eu.gloria.rtc;


import java.util.Date;
import java.util.List;


import eu.gloria.rt.entity.device.AxisRateType;
import eu.gloria.rt.entity.device.Device;
import eu.gloria.rt.entity.device.DeviceMount;
import eu.gloria.rt.entity.device.DeviceType;
import eu.gloria.rt.entity.device.MountPointingModel;
import eu.gloria.rt.entity.device.TrackingRateType;
import eu.gloria.rt.exception.RTException;
import eu.gloria.rtc.DeviceDiscoverer;
import eu.gloria.rtc.MountControlInterface;
import eu.gloria.rtd.RTDMountInterface;

/**
 * Generic MountInterface implementation
 * 
 * @author mclopez
 *
 */
public class MountControl extends DeviceManager implements MountControlInterface {
	
	
	/**
	 * Returns the DeviceMount of the specified device identifier.
	 * 
	 * @param deviceId Device identifier.
	 * @return {@link DeviceMount }
	 * @throws RTException In error case.
	 */
	private DeviceMount getMountDevice (String deviceId) throws RTException{
		
		Device dev =  this.devGetDevice(deviceId, true);
		
		if (dev.getType() != DeviceType.MOUNT)
			throw new RTException("The device type is not correct.");
		
		return (DeviceMount) dev;
	}	
	
	
	
	/**
	 * Constructor
	 */
	public MountControl () {
		
	}

	@Override
	public Date mntGetUtcClock(String deviceId) throws RTException {
		
		getMountDevice(deviceId);
		return  ((RTDMountInterface) DeviceDiscoverer.getRTD(deviceId)).mntGetUtcClock();
	}

	@Override
	public void mntSetUtcClock(String deviceId, Date date) throws RTException {
		
		checkPreconditionOpRunning();

		getMountDevice(deviceId);
		((RTDMountInterface) DeviceDiscoverer.getRTD(deviceId)).mntSetUtcClock(date);
	}

	@Override
	public double mntGetSiderealDate(String deviceId) throws RTException {

		getMountDevice(deviceId);
		return  ((RTDMountInterface) DeviceDiscoverer.getRTD(deviceId)).mntGetSiderealDate();
	}

	@Override
	public boolean mntIsAtHome(String deviceId) throws RTException {

		getMountDevice(deviceId);
		return  ((RTDMountInterface) DeviceDiscoverer.getRTD(deviceId)).mntIsAtHome();
	}

	@Override
	public boolean mntIsParked(String deviceId) throws RTException {

		getMountDevice(deviceId);
		return  ((RTDMountInterface) DeviceDiscoverer.getRTD(deviceId)).mntIsParked();
		
	}
	

	@Override
	public double mntGetTargetRightAscension(String deviceId) throws RTException {


		getMountDevice(deviceId);
		return  ((RTDMountInterface) DeviceDiscoverer.getRTD(deviceId)).mntGetTargetRightAscension();
	}

	@Override
	public double mntGetTrackingDeclinationRate(String deviceId) throws RTException {

		getMountDevice(deviceId);
		return  ((RTDMountInterface) DeviceDiscoverer.getRTD(deviceId)).mntGetTrackingDeclinationRate();
	}

	@Override
	public double mntGetTrackingAscensionRate(String deviceId)
			throws RTException {

		getMountDevice(deviceId);
		return  ((RTDMountInterface) DeviceDiscoverer.getRTD(deviceId)).mntGetTrackingAscensionRate();
	}

	@Override
	public TrackingRateType mntGetTrackingRate(String deviceId) throws RTException {

		getMountDevice(deviceId);
		return  ((RTDMountInterface) DeviceDiscoverer.getRTD(deviceId)).mntGetTrackingRate();
	}

	@Override
	public void mntSetTrackingRate(String deviceId, TrackingRateType rate)
			throws RTException {
		
		checkPreconditionOpRunning();

		getMountDevice(deviceId);
		((RTDMountInterface) DeviceDiscoverer.getRTD(deviceId)).mntSetTrackingRate(rate);
		
	}

	@Override
	public boolean mntGetTracking(String deviceId) throws RTException {

		getMountDevice(deviceId);
		return  ((RTDMountInterface) DeviceDiscoverer.getRTD(deviceId)).mntGetTracking();
	}

	@Override
	public void mntSetTracking(String deviceId, boolean value)
			throws RTException {
		
		checkPreconditionOpRunning();

		getMountDevice(deviceId);
		((RTDMountInterface) DeviceDiscoverer.getRTD(deviceId)).mntSetTracking(value);
		
	}

	@Override
	public double mntGetGuideRateDeclination(String deviceId)
			throws RTException {

		getMountDevice(deviceId);
		return  ((RTDMountInterface) DeviceDiscoverer.getRTD(deviceId)).mntGetGuideRateDeclination();
	}

	@Override
	public double mntGetDeclinationRateRightAscension(String deviceId)
			throws RTException {

		getMountDevice(deviceId);
		return  ((RTDMountInterface) DeviceDiscoverer.getRTD(deviceId)).mntGetDeclinationRateRightAscension();
	}

	@Override
	public boolean mntIsSlewing(String deviceId) throws RTException {

		getMountDevice(deviceId);
		return  ((RTDMountInterface) DeviceDiscoverer.getRTD(deviceId)).mntIsSlewing();
	}

	@Override
	public double mntGetPosAxis1(String deviceId) throws RTException {


		getMountDevice(deviceId);
		return  ((RTDMountInterface) DeviceDiscoverer.getRTD(deviceId)).mntGetPosAxis1();
	}
	

	@Override
	public double mntGetPosAxis2(String deviceId) throws RTException {


		getMountDevice(deviceId);
		return  ((RTDMountInterface) DeviceDiscoverer.getRTD(deviceId)).mntGetPosAxis2();
	}

	@Override
	public double mntGetPosAxis3(String deviceId) throws RTException {

		getMountDevice(deviceId);
		return  ((RTDMountInterface) DeviceDiscoverer.getRTD(deviceId)).mntGetPosAxis3();
	}

	
	@Override
	public boolean mntCanPulseGuide(String deviceId) throws RTException {

		getMountDevice(deviceId);
		return  ((RTDMountInterface) DeviceDiscoverer.getRTD(deviceId)).mntCanPulseGuide();
	}

	@Override
	public boolean mntCanSetGuideRates(String deviceId) throws RTException {

		getMountDevice(deviceId);
		return  ((RTDMountInterface) DeviceDiscoverer.getRTD(deviceId)).mntCanSetGuideRates();
	}

	@Override
	public boolean mntCanSetPark(String deviceId) throws RTException {

		getMountDevice(deviceId);
		return  ((RTDMountInterface) DeviceDiscoverer.getRTD(deviceId)).mntCanSetPark();
	}

	@Override
	public void mntSetPark(String deviceId, double ascension, double declination) throws RTException {
		
		checkPreconditionOpRunning();

		getMountDevice(deviceId);
		((RTDMountInterface) DeviceDiscoverer.getRTD(deviceId)).mntSetPark(ascension, declination);
		
	}

	@Override
	public double mntGetALTParkPos(String deviceId) throws RTException {

		getMountDevice(deviceId);
		return  ((RTDMountInterface) DeviceDiscoverer.getRTD(deviceId)).mntGetALTParkPos();
	}

	@Override
	public double mntGetAZParkPos(String deviceId) throws RTException {

		getMountDevice(deviceId);
		return  ((RTDMountInterface) DeviceDiscoverer.getRTD(deviceId)).mntGetAZParkPos();
	}

	@Override
	public boolean mntCanSetTracking(String deviceId) throws RTException {

		getMountDevice(deviceId);
		return  ((RTDMountInterface) DeviceDiscoverer.getRTD(deviceId)).mntCanSetTracking();
	}

	@Override
	public boolean mntCanSetTrackingRate(String deviceId) throws RTException {

		getMountDevice(deviceId);
		return  ((RTDMountInterface) DeviceDiscoverer.getRTD(deviceId)).mntCanSetTrackingRate();
	}

	

	@Override
	public boolean mntCanSlewCoordinates(String deviceId) throws RTException {

		getMountDevice(deviceId);
		return  ((RTDMountInterface) DeviceDiscoverer.getRTD(deviceId)).mntCanSlewCoordinates();
	}

	@Override
	public boolean mntCanSlewCoordinatesAsync(String deviceId)
			throws RTException {

		getMountDevice(deviceId);
		return  ((RTDMountInterface) DeviceDiscoverer.getRTD(deviceId)).mntCanSlewCoordinatesAsync();
	}
	
	@Override
	public boolean mntCanSlewObject(String deviceId)
			throws RTException {

		getMountDevice(deviceId);
		return  ((RTDMountInterface) DeviceDiscoverer.getRTD(deviceId)).mntCanSlewObject();
	}

	@Override
	public boolean mntCanSlewAltAz(String deviceId) throws RTException {

		getMountDevice(deviceId);
		return  ((RTDMountInterface) DeviceDiscoverer.getRTD(deviceId)).mntCanSlewAltAz();
	}

	@Override
	public boolean mntCanSlewAzAsync(String deviceId) throws RTException {

		getMountDevice(deviceId);
		return  ((RTDMountInterface) DeviceDiscoverer.getRTD(deviceId)).mntCanSlewAzAsync();
	}

	@Override
	public boolean mntCanMoveAzis(String deviceId) throws RTException {

		getMountDevice(deviceId);
		return  ((RTDMountInterface) DeviceDiscoverer.getRTD(deviceId)).mntCanMoveAzis();
	}

	@Override
	public List<AxisRateType> mntAxisRate(String deviceId) throws RTException {

		getMountDevice(deviceId);
		return  ((RTDMountInterface) DeviceDiscoverer.getRTD(deviceId)).mntAxisRate();
	}

	@Override
	public List<TrackingRateType> mntTrackingRates(String deviceId)
			throws RTException {

		getMountDevice(deviceId);
		return  ((RTDMountInterface) DeviceDiscoverer.getRTD(deviceId)).mntTrackingRates();
	}

	@Override
	public void mntGoHome(String deviceId) throws RTException {
		
		checkPreconditionOpRunning();

		getMountDevice(deviceId);
		((RTDMountInterface) DeviceDiscoverer.getRTD(deviceId)).mntGoHome();
		
	}

	@Override
	public void mntPark(String deviceId) throws RTException {
		
		checkPreconditionOpRunning();

		getMountDevice(deviceId);
		((RTDMountInterface) DeviceDiscoverer.getRTD(deviceId)).mntPark();
		
		
	}

	@Override
	public void mntUnpark(String deviceId) throws RTException {
		
		checkPreconditionOpRunning();

		getMountDevice(deviceId);
		((RTDMountInterface) DeviceDiscoverer.getRTD(deviceId)).mntUnpark();
		
	}

	@Override
	public void mntSlewToAltAz(String deviceId, double azimuth, double altitude)
			throws RTException {	
		
		checkPreconditionOpRunning();

		getMountDevice(deviceId);
		((RTDMountInterface) DeviceDiscoverer.getRTD(deviceId)).mntSlewToAltAz(azimuth, altitude);	
		
	}

	@Override
	public void mntSlewToAltAzAsync(String deviceId, double azimuth,
			double altitude) throws RTException {
		
		checkPreconditionOpRunning();

		getMountDevice(deviceId);
		((RTDMountInterface) DeviceDiscoverer.getRTD(deviceId)).mntSlewToAltAzAsync(azimuth, altitude);
		
	}

	@Override
	public void mntSlewToCoordinates(String deviceId, double ascension,
			double declination) throws RTException {
		
		checkPreconditionOpRunning();

		getMountDevice(deviceId);
		((RTDMountInterface) DeviceDiscoverer.getRTD(deviceId)).mntSlewToCoordinates(ascension, declination);
		
	}

	@Override
	public void mntSlewToCoordinatesAsync(String deviceId, double ascension,
			double declination) throws RTException {
		
		checkPreconditionOpRunning();

		getMountDevice(deviceId);
		((RTDMountInterface) DeviceDiscoverer.getRTD(deviceId)).mntSlewToCoordinatesAsync(ascension, declination);
		
	}

	@Override
	public void mntMoveAxis(String deviceId, int axisType, double rate)
			throws RTException {
		
		checkPreconditionOpRunning();

		getMountDevice(deviceId);
		((RTDMountInterface) DeviceDiscoverer.getRTD(deviceId)).mntMoveAxis(axisType, rate);
		
	}

	@Override
	public void mntPulseGuide(String deviceId, int guideDirection, int duration)
			throws RTException {
		
		checkPreconditionOpRunning();

		getMountDevice(deviceId);
		((RTDMountInterface) DeviceDiscoverer.getRTD(deviceId)).mntPulseGuide(guideDirection, duration);
		
	}

	@Override
	public void mntStopSlew(String deviceId, int axisType) throws RTException {
		
		checkPreconditionOpRunning();

		getMountDevice(deviceId);
		((RTDMountInterface) DeviceDiscoverer.getRTD(deviceId)).mntStopSlew(axisType);
		
	}

	@Override
	public void mntStopSlew(String deviceId) throws RTException {
		
		checkPreconditionOpRunning();

		getMountDevice(deviceId);
		((RTDMountInterface) DeviceDiscoverer.getRTD(deviceId)).mntStopSlew();
		
	}

	@Override
	public double mntGetTargetDeclination(String deviceId) throws RTException {

		getMountDevice(deviceId);
		return  ((RTDMountInterface) DeviceDiscoverer.getRTD(deviceId)).mntGetTargetDeclination();
	}



	@Override
	public MountPointingModel mntGetPointingModel(String deviceId)
			throws RTException {

		getMountDevice(deviceId);
		return  ((RTDMountInterface) DeviceDiscoverer.getRTD(deviceId)).mntGetPointingModel();
	}



	@Override
	public void mntMoveNorth(String deviceId) throws RTException {
		
		checkPreconditionOpRunning();

		getMountDevice(deviceId);
		((RTDMountInterface) DeviceDiscoverer.getRTD(deviceId)).mntMoveNorth();
		
	}



	@Override
	public void mntMoveEast(String deviceId) throws RTException {
		
		checkPreconditionOpRunning();

		getMountDevice(deviceId);
		((RTDMountInterface) DeviceDiscoverer.getRTD(deviceId)).mntMoveEast();
		
	}



	@Override
	public void mntMoveSouth(String deviceId) throws RTException {
		
		checkPreconditionOpRunning();

		getMountDevice(deviceId);
		((RTDMountInterface) DeviceDiscoverer.getRTD(deviceId)).mntMoveSouth();
		
	}



	@Override
	public void mntMoveWest(String deviceId) throws RTException {
		
		checkPreconditionOpRunning();

		getMountDevice(deviceId);
		((RTDMountInterface) DeviceDiscoverer.getRTD(deviceId)).mntMoveWest();
		
	}



	@Override
	public void mntSetSlewRate(String deviceId, String rate) throws RTException {
		
		checkPreconditionOpRunning();

		getMountDevice(deviceId);
		((RTDMountInterface) DeviceDiscoverer.getRTD(deviceId)).mntSetSlewRate(rate);
		
	}



	@Override
	public void mntSlewObject(String deviceId, String object) throws RTException {
		
		checkPreconditionOpRunning();

		getMountDevice(deviceId);
		((RTDMountInterface) DeviceDiscoverer.getRTD(deviceId)).mntSlewObject(object);
		
	}



	@Override
	public String mntGetSlewRate(String deviceId) throws RTException {
		getMountDevice(deviceId);
		return ((RTDMountInterface) DeviceDiscoverer.getRTD(deviceId)).mntGetSlewRate();
	}



	@Override
	public boolean mntIsPointingAtObject(String deviceId, String object,
			double raError, double decError) throws RTException {
		getMountDevice(deviceId);
		return ((RTDMountInterface) DeviceDiscoverer.getRTD(deviceId)).mntIsPointingAtObject(object, raError, decError);
	}



	@Override
	public boolean mntIsPointingAtCoordinates(String deviceId, double ra,
			double dec, double raError, double decError) throws RTException {
		getMountDevice(deviceId);
		return ((RTDMountInterface) DeviceDiscoverer.getRTD(deviceId)).mntIsPointingAtCoordinates(ra, dec, raError, decError);
	}
	
	
	

}
