package eu.gloria.rtc;

import eu.gloria.rt.entity.device.DewRemoverChannelType;
import eu.gloria.rt.exception.RTException;
import eu.gloria.rtd.RTDDewRemoverInterface;

public class DewRemoverControl extends DeviceManager implements
		DewRemoverControlInterface {

	@Override
	public int dwrGetChannelsNumber(String deviceId) throws RTException {
		
		return  ((RTDDewRemoverInterface) DeviceDiscoverer.getRTD(deviceId)).dwrGetChannelsNumber();
	}

	@Override
	public DewRemoverChannelType dwrGetChannelType(String deviceId, int channel)
			throws RTException {

		return  ((RTDDewRemoverInterface) DeviceDiscoverer.getRTD(deviceId)).dwrGetChannelType(channel);
	}

	@Override
	public void dwrSetTemperatureThreshold(String deviceId, int channel, double temperature)
			throws RTException {
		
		checkPreconditionOpRunning();

		((RTDDewRemoverInterface) DeviceDiscoverer.getRTD(deviceId)).dwrSetTemperatureThreshold(channel, temperature);

	}

	@Override
	public void dwrSetCycleThreshold(String deviceId, int channel, int cycle)
			throws RTException {
		
		checkPreconditionOpRunning();

		((RTDDewRemoverInterface) DeviceDiscoverer.getRTD(deviceId)).dwrSetCycleThreshold(channel, cycle);

	}

}
