package eu.gloria.rtc;

import eu.gloria.rt.entity.device.CameraAcquisitionMode;
import eu.gloria.rt.entity.device.CameraDigitizingMode;
import eu.gloria.rt.entity.device.Image;
import eu.gloria.rt.exception.RTException;
import eu.gloria.rtd.RTDSurveillanceCameraInterface;

public class SurveillanceCameraControl extends DeviceManager implements
		SurveillanceCameraControlInterface {

	@Override
	public boolean scamHasBrightness(String deviceId) throws RTException {

		return  ((RTDSurveillanceCameraInterface) DeviceDiscoverer.getRTD(deviceId)).scamHasBrightness();
	}

	@Override
	public boolean scamHasContrast(String deviceId) throws RTException {

		return  ((RTDSurveillanceCameraInterface) DeviceDiscoverer.getRTD(deviceId)).scamHasContrast();
	}

	@Override
	public CameraAcquisitionMode scamAcquisitionMode(String deviceId)
			throws RTException {

		return  ((RTDSurveillanceCameraInterface) DeviceDiscoverer.getRTD(deviceId)).scamAcquisitionMode();
	}

	@Override
	public float scamGetFPS(String deviceId) throws RTException {

		return  ((RTDSurveillanceCameraInterface) DeviceDiscoverer.getRTD(deviceId)).scamGetFPS();
	}

	@Override
	public CameraDigitizingMode scamGetDigitizingMode(String deviceId)
			throws RTException {

		return  ((RTDSurveillanceCameraInterface) DeviceDiscoverer.getRTD(deviceId)).scamGetDigitizingMode();
	}

	@Override
	public boolean scamIsPTSupported(String deviceId) throws RTException {

		return  ((RTDSurveillanceCameraInterface) DeviceDiscoverer.getRTD(deviceId)).scamIsPTSupported();
	}

	@Override
	public boolean scamIsZoomSupported(String deviceId) throws RTException {

		return  ((RTDSurveillanceCameraInterface) DeviceDiscoverer.getRTD(deviceId)).scamIsZoomSupported();
	}

	@Override
	public int scamGetPanMin(String deviceId) throws RTException {

		return  ((RTDSurveillanceCameraInterface) DeviceDiscoverer.getRTD(deviceId)).scamGetPanMin();
	}

	@Override
	public int scamGetPanMax(String deviceId) throws RTException {

		return  ((RTDSurveillanceCameraInterface) DeviceDiscoverer.getRTD(deviceId)).scamGetPanMax();
	}

	@Override
	public int scamGetTiltMin(String deviceId) throws RTException {

		return  ((RTDSurveillanceCameraInterface) DeviceDiscoverer.getRTD(deviceId)).scamGetTiltMin();
	}

	@Override
	public int scamGetTiltMax(String deviceId) throws RTException {

		return  ((RTDSurveillanceCameraInterface) DeviceDiscoverer.getRTD(deviceId)).scamGetTiltMax();
	}

	@Override
	public int scamGetZoomMax(String deviceId) throws RTException {

		return  ((RTDSurveillanceCameraInterface) DeviceDiscoverer.getRTD(deviceId)).scamGetZoomMax();
	}

	@Override
	public double scamGetExposureTime(String deviceId) throws RTException {

		return  ((RTDSurveillanceCameraInterface) DeviceDiscoverer.getRTD(deviceId)).scamGetExposureTime();
	}

	@Override
	public void scamSetExposureTime(String deviceId, double value)
			throws RTException {

		((RTDSurveillanceCameraInterface) DeviceDiscoverer.getRTD(deviceId)).scamSetExposureTime(value);

	}

	@Override
	public boolean scamIsImageReady(String deviceId) throws RTException {

		return  ((RTDSurveillanceCameraInterface) DeviceDiscoverer.getRTD(deviceId)).scamIsImageReady();
	}

	@Override
	public String scamGetVideoStreamingURL(String deviceId) throws RTException {

		return  ((RTDSurveillanceCameraInterface) DeviceDiscoverer.getRTD(deviceId)).scamGetVideoStreamingURL();
	}
	
	@Override
	public String scamGetImageURL(String deviceId) throws RTException {

		return  ((RTDSurveillanceCameraInterface) DeviceDiscoverer.getRTD(deviceId)).scamGetImageURL();
	}
	
	@Override
	public void scamSetBrightness(String deviceId, long value)
			throws RTException {
		
		checkPreconditionOpRunning();

		((RTDSurveillanceCameraInterface) DeviceDiscoverer.getRTD(deviceId)).scamSetBrightness(value);

	}

	@Override
	public long scamGetBrightness(String deviceId) throws RTException {

		return  ((RTDSurveillanceCameraInterface) DeviceDiscoverer.getRTD(deviceId)).scamGetBrightness();
	}

	@Override
	public void scamSetContrast(String deviceId, long value) throws RTException {
		
		checkPreconditionOpRunning();

		((RTDSurveillanceCameraInterface) DeviceDiscoverer.getRTD(deviceId)).scamSetContrast(value);

	}

	@Override
	public long scamGetContrast(String deviceId) throws RTException {

		return  ((RTDSurveillanceCameraInterface) DeviceDiscoverer.getRTD(deviceId)).scamGetContrast();
	}

	@Override
	public int scamGetPanRotation(String deviceId) throws RTException {

		return  ((RTDSurveillanceCameraInterface) DeviceDiscoverer.getRTD(deviceId)).scamGetPanRotation();
	}

	@Override
	public void scamSetPanRotation(String deviceId, int value)
			throws RTException {
		
		checkPreconditionOpRunning();

		((RTDSurveillanceCameraInterface) DeviceDiscoverer.getRTD(deviceId)).scamSetPanRotation(value);
	}

	@Override
	public int scamGetTiltRotation(String deviceId) throws RTException {

		return  ((RTDSurveillanceCameraInterface) DeviceDiscoverer.getRTD(deviceId)).scamGetTiltRotation();
	}

	@Override
	public void scamSetTiltRotation(String deviceId, int value)
			throws RTException {
		
		checkPreconditionOpRunning();

		((RTDSurveillanceCameraInterface) DeviceDiscoverer.getRTD(deviceId)).scamSetTiltRotation(value);

	}

	@Override
	public int scamGetZoom(String deviceId) throws RTException {

		return  ((RTDSurveillanceCameraInterface) DeviceDiscoverer.getRTD(deviceId)).scamGetZoom();
	}

	@Override
	public void scamSetZoom(String deviceId, int value) throws RTException {
		
		checkPreconditionOpRunning();

		((RTDSurveillanceCameraInterface) DeviceDiscoverer.getRTD(deviceId)).scamSetZoom(value);

	}

	@Override
	public void scamAbortExposure(String deviceId) throws RTException {
		
		checkPreconditionOpRunning();

		((RTDSurveillanceCameraInterface) DeviceDiscoverer.getRTD(deviceId)).scamAbortExposure();

	}

	@Override
	public void scamStartExposure(String deviceId, boolean light)
			throws RTException {
		
		checkPreconditionOpRunning();

		((RTDSurveillanceCameraInterface) DeviceDiscoverer.getRTD(deviceId)).scamStartExposure(light);

	}

	@Override
	public void scamStopExposure(String deviceId) throws RTException {
		
		checkPreconditionOpRunning();

		((RTDSurveillanceCameraInterface) DeviceDiscoverer.getRTD(deviceId)).scamStopExposure();

	}

	@Override
	public Image scamGetImage(String deviceId) throws RTException {

		return ((RTDSurveillanceCameraInterface) DeviceDiscoverer.getRTD(deviceId)).scamGetImage();
	}

}
