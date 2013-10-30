package eu.gloria.rtc;


import java.util.List;


import eu.gloria.rt.entity.device.Device;
import eu.gloria.rt.entity.device.DeviceProperty;
import eu.gloria.rt.exception.ExecutorWrongState;
import eu.gloria.rt.exception.RTException;
import eu.gloria.rtc.DeviceDiscoverer;
import eu.gloria.rtc.DeviceManagerInterface;
import eu.gloria.rtc.op.ExtExecInfo;
import eu.gloria.rtc.op.ExtRtsInterruptionException;
import eu.gloria.rtc.op.OpManager;

public class DeviceManager implements DeviceManagerInterface {
	
	/**
	 * Constructor
	 */
	public DeviceManager(){
		
	}
	

	@Override
	public List<Device> devGetDevices(boolean allProperties) throws RTException {
		
		return DeviceDiscoverer.devGetDevices(allProperties);		
	}

	@Override
	public Device devGetDevice(String deviceId, boolean allProperties) throws RTException{
		
		return DeviceDiscoverer.devGetDevice(deviceId, allProperties);
		
	}
	
	@Override
	public Device devGetDevice(String deviceId, List<String> propertyNames) throws RTException{
		
		return DeviceDiscoverer.devGetDevice(deviceId, propertyNames);
	}

	@Override
	public List<DeviceProperty> devGetDeviceProperties(String deviceId)
			throws RTException {
		
		return DeviceDiscoverer.getRTD(deviceId).devGetDeviceProperties();
	}

	@Override
	public boolean devUpdateDeviceProperty(String deviceId, String name,
			List<String> value) throws RTException {
		
		return DeviceDiscoverer.getRTD(deviceId).devUpdateDeviceProperty(name, value);
		
	}

	@Override
	public boolean devUpdateDevicePropertyAsync(String deviceId, String name,
			List<String> value) throws RTException {
		
		return DeviceDiscoverer.getRTD(deviceId).devUpdateDevicePropertyAsync(name, value);

	}
	
	@Override
	public boolean devIsConnected(String deviceId) throws RTException {
		
		return DeviceDiscoverer.getRTD(deviceId).devIsConnected();
	}

	@Override
	public void devDisconnect(String deviceId) throws RTException {
		
		DeviceDiscoverer.getRTD(deviceId).devDisconnect();

	}
	
	@Override
	public void devConnect(String deviceId) throws RTException{
		
		DeviceDiscoverer.getRTD(deviceId).devConnect();
	}

	@Override
	public String devGetConfiguration(String deviceId) throws RTException {
		
		return DeviceDiscoverer.getRTD(deviceId).devGetConfiguration();
	}

	@Override
	public DeviceProperty devGetDeviceProperty(String deviceId, String name) throws RTException {

		return DeviceDiscoverer.getRTD(deviceId).devGetDeviceProperty(name);
	}


	@Override
	public boolean devIsBlocked(String deviceId) throws RTException {
		
		return DeviceDiscoverer.getRTD(deviceId).devIsBlocked();
	}


	@Override
	public boolean execIsRunningOp() throws RTException {
		
		ExecutorControl execControl = new ExecutorControl();
		return execControl.isRunningOp();
	}
	
	protected void checkPreconditionOpRunning() throws RTException{
				
		try {
			OpManager.getOpManager().processEvent();	
			
			ExecutorControl execControl = new ExecutorControl();
			ExtExecInfo info = execControl.getExtExecInfo();
			
			if (info.getDescription().contains("Alert target")){
				ExecutorWrongState ex = new ExecutorWrongState("Observing Plan aborted because of an alert");
				throw ex;
			}
			
			if (!this.execIsRunningOp()){
				ExecutorWrongState ex = new ExecutorWrongState("There is not any Observing Plan running.");
				throw ex;
			}
			
			
		} catch (ExtRtsInterruptionException e) {
			new RTException (e.getMessage());
		}
		
	}
	
	

}
