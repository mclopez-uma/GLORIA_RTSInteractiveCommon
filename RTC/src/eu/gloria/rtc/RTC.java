package eu.gloria.rtc;


import java.util.List;

import eu.gloria.rt.entity.device.Device;
import eu.gloria.rt.entity.device.DeviceProperty;
import eu.gloria.rt.exception.RTException;
import eu.gloria.rtc.DeviceManagerInterface;

public class RTC implements DeviceManagerInterface {
	

	public static void main(String[] args) {
		
			try {
				DeviceManager dev = new DeviceManager();
				
				System.out.println(">>" + dev.devGetDevices(false));
			} catch (RTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}

	@Override
	public List<DeviceProperty> devGetDeviceProperties(String deviceId)
			throws RTException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeviceProperty devGetDeviceProperty(String deviceId, String name)
			throws RTException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean devUpdateDeviceProperty(String deviceId, String name,
			List<String> value) throws RTException {
		return false;
		// TODO Auto-generated method stub

	}

	@Override
	public boolean devUpdateDevicePropertyAsync(String deviceId, String name,
			List<String> value) throws RTException {
		return false;
		// TODO Auto-generated method stub

	}

	@Override
	public boolean devIsConnected(String deviceId) throws RTException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void devConnect(String deviceId) throws RTException {
		// TODO Auto-generated method stub

	}

	@Override
	public void devDisconnect(String deviceId) throws RTException {
		// TODO Auto-generated method stub

	}

	@Override
	public String devGetConfiguration(String deviceId) throws RTException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Device> devGetDevices(boolean allProperties) throws RTException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Device devGetDevice(String deviceId, boolean allProperties)
			throws RTException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Device devGetDevice(String deviceId, List<String> propertyNames)
			throws RTException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean devIsBlocked(String deviceId) throws RTException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean execIsRunningOp() throws RTException {
		// TODO Auto-generated method stub
		return false;
	}

}
