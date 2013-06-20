package eu.gloria.rtc;


import java.util.List;

import eu.gloria.rt.entity.device.Device;
import eu.gloria.rt.entity.device.DeviceFilter;
import eu.gloria.rt.entity.device.DeviceProperty;
import eu.gloria.rt.entity.device.DeviceType;
import eu.gloria.rt.exception.RTException;
import eu.gloria.rtc.DeviceDiscoverer;
import eu.gloria.rtc.FilterWheelInterface;
import eu.gloria.rtd.RTDFilterWheelInterface;


public class FilterWheelControl extends DeviceManager implements FilterWheelInterface {
	
	/**
	 * Returns the DeviceFilter of the specified device identifier.
	 * 
	 * @param deviceId Device identifier.
	 * @return {@link DeviceFilter }
	 * @throws RTException In error case.
	 */
	private DeviceFilter getFilterWheelDevice (String deviceId) throws RTException{
		
		Device dev =  this.devGetDevice(deviceId, true);
		
		if ((dev.getType() != DeviceType.FW) & (dev.getType() != DeviceType.CUPOLA))
			throw new RTException("The device type is not correct.");

		
		return (DeviceFilter) dev;
	}
	

	@Override
	public int fwGetPositionNumber(String deviceId)	throws RTException {

		getFilterWheelDevice (deviceId);
		return  ((RTDFilterWheelInterface) DeviceDiscoverer.getRTD(deviceId)).fwGetPositionNumber();
	}

	@Override
	public int fwGetSpeedSwitching(String deviceId)	throws RTException {

		getFilterWheelDevice (deviceId);
		return  ((RTDFilterWheelInterface) DeviceDiscoverer.getRTD(deviceId)).fwGetSpeedSwitching();
	}

	@Override
	public float fwGetFilterSize(String deviceId) throws RTException {

		getFilterWheelDevice (deviceId);
		return  ((RTDFilterWheelInterface) DeviceDiscoverer.getRTD(deviceId)).fwGetFilterSize();
	}	
	
	
	@Override
	public String fwGetFilterKind(String deviceId) throws RTException {

		getFilterWheelDevice (deviceId);
		return  ((RTDFilterWheelInterface) DeviceDiscoverer.getRTD(deviceId)).fwGetFilterKind();
	}

	@Override
	public boolean fwIsAtHome(String deviceId) throws RTException {

		getFilterWheelDevice (deviceId);
		return  ((RTDFilterWheelInterface) DeviceDiscoverer.getRTD(deviceId)).fwIsAtHome();
	}

	@Override
	public void fwSetOffset(String deviceId, List<Integer> positions) throws RTException {
		
		checkPreconditionOpRunning();

		getFilterWheelDevice (deviceId);
		((RTDFilterWheelInterface) DeviceDiscoverer.getRTD(deviceId)).fwSetOffset(positions);

	}

	@Override
	public void fwSelectFilterKind(String deviceId, String kind) throws RTException {
		
		checkPreconditionOpRunning();

		getFilterWheelDevice (deviceId);
		((RTDFilterWheelInterface) DeviceDiscoverer.getRTD(deviceId)).fwSelectFilterKind(kind);

	}

	@Override
	public void fwSelectFilterPosition(String deviceId, int position) throws RTException {
		
		checkPreconditionOpRunning();

		getFilterWheelDevice (deviceId);
		((RTDFilterWheelInterface) DeviceDiscoverer.getRTD(deviceId)).fwSelectFilterPosition(position);

	}

	@Override
	public void fwGoHome(String deviceId) throws RTException {
		
		checkPreconditionOpRunning();

		getFilterWheelDevice (deviceId);
		((RTDFilterWheelInterface) DeviceDiscoverer.getRTD(deviceId)).fwGoHome();

	}


	@Override
	public String fwGetCamera(String deviceId) throws RTException {
		
		getFilterWheelDevice (deviceId);
		return((RTDFilterWheelInterface) DeviceDiscoverer.getRTD(deviceId)).fwGetCamera();
	}


	@Override
	public List<String> fwGetFilterList(String deviceId) throws RTException {
		getFilterWheelDevice (deviceId);
		return((RTDFilterWheelInterface) DeviceDiscoverer.getRTD(deviceId)).fwGetFilterList();
	}

}
