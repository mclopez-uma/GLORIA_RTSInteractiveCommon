package eu.gloria.rti.tool;

import eu.gloria.rtc.RTCInterface;
import eu.gloria.tools.log.LogUtil;

public class Singleton {
	
	public static RTCInterface RTC;
	
	static{
		try {
			RTC = (RTCInterface)Class.forName("eu.gloria.rts2.rtc.RTC").newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
	}
	
	public static RTCInterface getRTC(){
		return RTC;
	}

}
