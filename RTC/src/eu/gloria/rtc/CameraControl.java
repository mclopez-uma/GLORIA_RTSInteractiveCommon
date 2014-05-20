package eu.gloria.rtc;

import java.util.Date;
import java.util.List;

import eu.gloria.rt.entity.device.BlockState;
import eu.gloria.rt.entity.device.CameraAcquisitionMode;
import eu.gloria.rt.entity.device.CameraDigitizingMode;
import eu.gloria.rt.entity.device.CameraType;
import eu.gloria.rt.entity.device.Device;
import eu.gloria.rt.entity.device.DeviceCamera;
import eu.gloria.rt.entity.device.DeviceProperty;
import eu.gloria.rt.entity.device.DeviceType;
import eu.gloria.rt.entity.device.Image;
import eu.gloria.rt.entity.device.ImageContentType;
import eu.gloria.rt.entity.device.ImageFormat;
import eu.gloria.rt.exception.RTException;
import eu.gloria.rtc.CameraControlInterface;
import eu.gloria.rtc.DeviceDiscoverer;
import eu.gloria.rtd.RTDCameraInterface;

/**
 * Generic CameraInterface implementation
 * 
 * @author mclopez
 *
 */
public class CameraControl extends DeviceManager implements CameraControlInterface {

		
	/**
	 * Returns the DeviceCamera of the specified device identifier.
	 * 
	 * @param deviceId Device identifier.
	 * @return {@link DeviceCamera}
	 * @throws RTException In error case.
	 */
	private DeviceCamera getCameraDevice (String deviceId) throws RTException{
		
		Device dev =  this.devGetDevice(deviceId, false);

		if (dev.getType() != DeviceType.CCD) 
			throw new RTException("The device type is not correct.");
		
		return (DeviceCamera) dev;
	}

	/**
	 * Constructor
	 */
	public CameraControl () {
		
	}
	
	@Override
	public CameraType camGetCameraType(String deviceId) throws RTException {
				
		getCameraDevice (deviceId);
		return  ((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camGetCameraType();
		
	}

	@Override
	public int camGetXsize(String deviceId) throws RTException {
		
		getCameraDevice (deviceId);
		return  ((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camGetXsize();
	}

	@Override
	public int camGetYSize(String deviceId) throws RTException {
		
		getCameraDevice (deviceId);
		return  ((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camGetYSize();
	}

	@Override
	public boolean camCanAbortExposure(String deviceId) throws RTException {
		
		getCameraDevice (deviceId);
		return  ((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camCanAbortExposure();
	}

	@Override
	public boolean camCanAsymetricBin(String deviceId) throws RTException {
		
		getCameraDevice (deviceId);
		return  ((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camCanAsymetricBin();
	}

	@Override
	public boolean camCanGetCoolerPower(String deviceId) throws RTException {
		
		getCameraDevice (deviceId);
		return  ((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camCanGetCoolerPower();
	}

	@Override
	public boolean camCanSetCooler(String deviceId) throws RTException {
		
		getCameraDevice (deviceId);
		return  ((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camCanSetCooler();
	}

	@Override
	public boolean camCanSetCCDTemperature(String deviceId) throws RTException {
		
		getCameraDevice (deviceId);
		return  ((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camCanSetCCDTemperature();
	}

	@Override
	public boolean camCanControlTemperature(String deviceId) throws RTException {
				
		getCameraDevice (deviceId);
		return  ((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camCanControlTemperature();
	}

	@Override
	public boolean camCanStopExposure(String deviceId) throws RTException {
		
		getCameraDevice (deviceId);
		return  ((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camCanStopExposure();
	}

	@Override
	public float camGetCoolerPower(String deviceId) throws RTException {
		
		getCameraDevice (deviceId);
		return  ((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camGetCoolerPower();
	}

	@Override
	public double camGetElectronsPerADU(String deviceId) throws RTException {
		
		getCameraDevice (deviceId);
		return  ((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camGetElectronsPerADU();
	}

	@Override
	public double camGetFullWellCapacity(String deviceId) throws RTException {
		
		getCameraDevice (deviceId);
		return  ((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camGetFullWellCapacity();
	}

	@Override
	public boolean camHasShutter(String deviceId) throws RTException {
		
		getCameraDevice (deviceId);
		return  ((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camHasShutter();
	}

	@Override
	public boolean camHasBrightness(String deviceId) throws RTException {
		
		getCameraDevice (deviceId);
		return  ((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camHasBrightness();
	}

	@Override
	public boolean camHasConstrast(String deviceId) throws RTException {
		
		getCameraDevice (deviceId);
		return  ((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camHasConstrast();
	}

	@Override
	public boolean camHasGain(String deviceId) throws RTException {
		
		getCameraDevice (deviceId);
		return  ((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camHasGain();
	}

	@Override
	public boolean camHasGamma(String deviceId) throws RTException {
		
		getCameraDevice (deviceId);
		return  ((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camHasGamma();
	}

	@Override
	public boolean camHasSubframe(String deviceId) throws RTException {
		
		getCameraDevice (deviceId);
		return  ((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camHasSubframe();
	}

	@Override
	public boolean camHasExposureTime(String deviceId) throws RTException {
		
		getCameraDevice (deviceId);
		return  ((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camHasExposureTime();
	}

	@Override
	public double camHeatSinkTemperature(String deviceId) throws RTException {
		
		getCameraDevice (deviceId);
		return  ((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camHeatSinkTemperature();
	}

	@Override
	public boolean camIsPulseGuiding(String deviceId) throws RTException {
		
		getCameraDevice (deviceId);
		return  ((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camIsPulseGuiding();
	}

	@Override
	public String camGetLastError(String deviceId) throws RTException {
		
		getCameraDevice (deviceId);
		return  ((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camGetLastError();
	}

	@Override
	public double camGetLastExposureDuration(String deviceId)
			throws RTException {
		
		getCameraDevice (deviceId);
		return  ((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camGetLastExposureDuration();
	}

	@Override
	public Date camGetLastExposureStart(String deviceId) throws RTException {
		
		getCameraDevice (deviceId);
		return  ((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camGetLastExposureStart();
	}

	@Override
	public long camGetMaxAdu(String deviceId) throws RTException {
		
		getCameraDevice (deviceId);
		return  ((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camGetMaxAdu();
	}

	@Override
	public int camGetMaxBinX(String deviceId) throws RTException {
		
		getCameraDevice (deviceId);
		return  ((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camGetMaxBinX();
	}

	@Override
	public int camGetMaxBinY(String deviceId) throws RTException {
		
		getCameraDevice (deviceId);
		return  ((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camGetMaxBinY();
	}

	@Override
	public int camGetPixelSizeX(String deviceId) throws RTException {
		
		getCameraDevice (deviceId);
		return  ((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camGetPixelSizeX();
	}

	@Override
	public int camGetPixelSizeY(String deviceId) throws RTException {
		
		getCameraDevice (deviceId);
		return  ((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camGetPixelSizeY();
	}

	@Override
	public CameraAcquisitionMode camGetAcquisitionMode(String deviceId)	throws RTException {
		
		getCameraDevice (deviceId);
		return  ((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camGetAcquisitionMode();
	}

	@Override
	public float camGetFPS(String deviceId) throws RTException {
		
		getCameraDevice (deviceId);
		return  ((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camGetFPS();
	}

	@Override
	public CameraDigitizingMode camGetDigitilizingMode(String deviceId)
			throws RTException {
		
		getCameraDevice (deviceId);
		return  ((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camGetDigitilizingMode();
	}

	@Override
	public int camGetBinX(String deviceId) throws RTException {
		
		getCameraDevice (deviceId);
		return  ((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camGetBinX();
	}

	@Override
	public void camSetBinX(String deviceId, int value) throws RTException {
		
		checkPreconditionOpRunning();
		
		getCameraDevice (deviceId);
		((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camSetBinX(value);
		
	}

	@Override
	public int camGetBinY(String deviceId) throws RTException {
		
		getCameraDevice (deviceId);
		return  ((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camGetBinY();
	}

	@Override
	public void camSetBinY(String deviceId, int value) throws RTException {
		
		checkPreconditionOpRunning();
		
		getCameraDevice (deviceId);
		((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camSetBinY(value);
		
	}

	@Override
	public boolean camIsCoolerOn(String deviceId) throws RTException {
		
		getCameraDevice (deviceId);
		return  ((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camIsCoolerOn();
	}

	@Override
	public void camSetCoolerOn(String deviceId, boolean value)
			throws RTException {
		
		checkPreconditionOpRunning();
		
		getCameraDevice (deviceId);
		((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camSetCoolerOn(value);
		
	}

	@Override
	public int camGetROINumX(String deviceId) throws RTException {
		
		getCameraDevice (deviceId);
		return  ((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camGetROINumX();
	}

	@Override
	public void camSetROINumX(String deviceId, int value) throws RTException {
		
		checkPreconditionOpRunning();
		
		getCameraDevice (deviceId);
		((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camSetROINumX(value);
		
	}

	@Override
	public void camSetROINumY(String deviceId, int value) throws RTException {
		
		checkPreconditionOpRunning();
		
		getCameraDevice (deviceId);
		((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camSetROINumY(value);
		
	}

	@Override
	public int camGetROINumY(String deviceId) throws RTException {
		
		getCameraDevice (deviceId);
		return  ((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camGetROINumY();
	}

	@Override
	public void camSetROIStartX(String deviceId, int ROIStartX)
			throws RTException {
		
		checkPreconditionOpRunning();
		
		getCameraDevice (deviceId);
		((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camSetROIStartX(ROIStartX);
		
	}

	@Override
	public int camGetROIStartX(String deviceId) throws RTException {
		
		getCameraDevice (deviceId);
		return  ((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camGetROIStartX();
	}

	@Override
	public void camSetROIStartY(String deviceId, int value) throws RTException {
		
		checkPreconditionOpRunning();
		
		getCameraDevice (deviceId);
		((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camSetROIStartY(value);
		
	}

	@Override
	public int camGetROIStartY(String deviceId) throws RTException {
		
		getCameraDevice (deviceId);
		return  ((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camGetROIStartY();
	}

	@Override
	public void camSetBrightness(String deviceId, long value)
			throws RTException {
		
		checkPreconditionOpRunning();
		
		getCameraDevice (deviceId);
		((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camSetBrightness(value);
		
	}

	@Override
	public long camGetBrightness(String deviceId) throws RTException {
		
		getCameraDevice (deviceId);
		return  ((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camGetBrightness();
	}

	@Override
	public void camSetContrast(String deviceId, long value) throws RTException {
		
		checkPreconditionOpRunning();
		
		getCameraDevice (deviceId);
		((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camSetContrast(value);
		
	}

	@Override
	public long camGetContrast(String deviceId) throws RTException {
		
		getCameraDevice (deviceId);
		return  ((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camGetContrast();
	}

	@Override
	public void camSetGain(String deviceId, long value) throws RTException {
		
		checkPreconditionOpRunning();
		
		getCameraDevice (deviceId);
		((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camSetGain(value);
		
	}

	@Override
	public long camGetGain(String deviceId) throws RTException {
		
		getCameraDevice (deviceId);
		return  ((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camGetGain();
	}

	@Override
	public void camSetGamma(String deviceId, long value) throws RTException {
		
		checkPreconditionOpRunning();
		
		getCameraDevice (deviceId);
		((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camSetGamma(value);
		
	}

	@Override
	public long camGetGamma(String deviceId) throws RTException {
		
		getCameraDevice (deviceId);
		return  ((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camGetGamma();
	}

	@Override
	public void camSetExposureTime(String deviceId, double value)
			throws RTException {
		
		checkPreconditionOpRunning();
		
		getCameraDevice (deviceId);
		((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camSetExposureTime(value);
		
	}

	@Override
	public Double camGetExposureTime(String deviceId) throws RTException {
		
		getCameraDevice (deviceId);
		return  ((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camGetExposureTime();
	}

	@Override
	public void camSetCCDTemperature(String deviceId, float value)
			throws RTException {
		
		checkPreconditionOpRunning();
		
		getCameraDevice (deviceId);
		 ((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camSetCCDTemperature(value);
		
	}

	@Override
	public float camGetCCDTemperature(String deviceId) throws RTException {
		
		getCameraDevice (deviceId);
		return  ((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camGetCCDTemperature();
	}

	@Override
	public float camGetCCDCurrentTemperature(String deviceId)
			throws RTException {
		
		getCameraDevice (deviceId);
		return  ((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camGetCCDCurrentTemperature();
	}

	@Override
	public void camAbortExposure(String deviceId) throws RTException {
		
		checkPreconditionOpRunning();
		
		getCameraDevice (deviceId);
		((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camAbortExposure();
		
	}

	@Override
	public void camPulseGuide(String deviceId, int direction, long duration)
			throws RTException {
		
		checkPreconditionOpRunning();
		
		getCameraDevice (deviceId);
		((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camPulseGuide(direction, duration);
		
	}

	@Override
	public String  camStartExposure(String deviceId, boolean light) throws RTException {
		
		checkPreconditionOpRunning();
		
		DeviceCamera cam = getCameraDevice (deviceId);
		if (cam.getBlockState() != BlockState.BLOCKED_EXPOSURE){
			return ((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camStartExposure(light);
		}else{
			throw new RTException ("Operation blocked");
		}
		
	}

	@Override
	public void camStopExposure(String deviceId) throws RTException {
		
		checkPreconditionOpRunning();
		
		getCameraDevice (deviceId);
		((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camStopExposure();
		
	}

	@Override
	public Image camGetImage(String deviceId, ImageFormat format) throws RTException {
		
		getCameraDevice (deviceId);
		return  ((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camGetImage(format);
	}

	@Override
	public boolean camImageReady(String deviceId) throws RTException {
		
		getCameraDevice (deviceId);
		return  ((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camImageReady();
	}

	@Override
	public ImageContentType camGetImageDataType(String deviceId)
			throws RTException {
		
		getCameraDevice (deviceId);
		return  ((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camGetImageDataType();
	}

	/*@Override
	public void camSetImageDataType(String deviceId, ImageContentType type)
			throws RTException {
		
		getCameraDevice (deviceId);
		((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camSetImageDataType(type);
		
	}*/

	@Override
	public List<String> camGetFilters(String deviceId) throws RTException {

		getCameraDevice (deviceId);
		return ((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camGetFilters();
	}

	@Override
	public String camGetFocuser(String deviceId) throws RTException {
		
		getCameraDevice (deviceId);
		return ((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camGetFocuser();
	}

	@Override
	public int camGetBitDepth(String deviceId) throws RTException {
		
		getCameraDevice (deviceId);
		return ((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camGetBitDepth();
	}

	@Override
	public void camSetBitDepth(String deviceId, int bits) throws RTException {
		
		checkPreconditionOpRunning();
		
		getCameraDevice (deviceId);
		((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camSetBitDepth(bits);
		
	}

	@Override
	public int camGetContinueModeQuality(String deviceId) throws RTException {
		
		getCameraDevice (deviceId);
		return ((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camGetContinueModeQuality();
	}

	@Override
	public void camSetContinueModeQuality(String deviceId, int value)
			throws RTException {
		
		checkPreconditionOpRunning();

		getCameraDevice (deviceId);
		((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camSetContinueModeQuality(value);
		
	}

	@Override
	public int camGetOneShotModeQuality(String deviceId) throws RTException {

		getCameraDevice (deviceId);
		return ((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camGetOneShotModeQuality();
	}

	@Override
	public void camSetOneShotModeQuality(String deviceId, int value)
			throws RTException {
		
		checkPreconditionOpRunning();

		getCameraDevice (deviceId);
		((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camSetOneShotModeQuality(value);
		
	}

	@Override
	public String camGetContinueModeImagePath(String deviceId)
			throws RTException {

		getCameraDevice (deviceId);
		return ((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camGetContinueModeImagePath();
	}

	@Override
	public String camGetOneShotModeImagePath(String deviceId)
			throws RTException {

		getCameraDevice (deviceId);
		return ((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camGetOneShotModeImagePath();
	}

	@Override
	public boolean camGetAutoGain(String deviceId) throws RTException {

		getCameraDevice (deviceId);
		return ((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camGetAutoGain();
	}

	@Override
	public void camSetAutoGain(String deviceId, boolean value)
			throws RTException {
		
		checkPreconditionOpRunning();

		getCameraDevice (deviceId);
		((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camSetAutoGain(value);
		
	}

	@Override
	public boolean camGetAutoExposureTime(String deviceId) throws RTException {

		getCameraDevice (deviceId);
		return ((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camGetAutoExposureTime();
	}

	@Override
	public void camSetAutoExposureTime(String deviceId, boolean value)
			throws RTException {
		
		checkPreconditionOpRunning();

		getCameraDevice (deviceId);
		((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camSetAutoExposureTime(value);
		
	}

	@Override
	public String camStartContinueMode(String deviceId) throws RTException {
		
		checkPreconditionOpRunning();

		getCameraDevice (deviceId);
		return ((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camStartContinueMode();
		
	}

	@Override
	public void camStopContinueMode(String deviceId) throws RTException {
		
		checkPreconditionOpRunning();

		getCameraDevice (deviceId);
		((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camStopContinueMode();
		
	}

	@Override
	public String camGetImageURL(String deviceId, String uid, ImageFormat format) throws RTException {

		getCameraDevice (deviceId);
		return ((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camGetImageURL(uid, format);
		
	}
	
	@Override
	public List<ImageFormat> camGetOneShotModeImageFormats(String deviceId) throws RTException{
		
		getCameraDevice (deviceId);
		return ((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camGetOneShotModeImageFormats();
	}
	
	@Override
	public List<ImageFormat> camGetContinueModeImageFormats(String deviceId) throws RTException{
		
		getCameraDevice (deviceId);
		return ((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camGetContinueModeImageFormats();
	}

	@Override
	public List<Double> camGetObjectExposureTime(String deviceId, String filter, String object) throws RTException {
		
		getCameraDevice (deviceId);
		return ((RTDCameraInterface) DeviceDiscoverer.getRTD(deviceId)).camGetObjectExposureTime(filter, object);
	}

	
	
	
	
}
