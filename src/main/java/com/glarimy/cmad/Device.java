package com.glarimy.cmad;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;


public class Device {
	@Id
	@GeneratedValue 
	private int DeviceId;
	
	private String DeviceName;
	private String DeviceUser;
	private String DeviceModelNumber;
	public int getDeviceId() {
		return DeviceId;
	}
	public void setDeviceId(int deviceId) {
		DeviceId = deviceId;
	}
	public String getDeviceName() {
		return DeviceName;
	}
	public void setDeviceName(String deviceName) {
		DeviceName = deviceName;
	}
	public String getDeviceUser() {
		return DeviceUser;
	}
	public void setDeviceUser(String deviceUser) {
		DeviceUser = deviceUser;
	}
	public String getDeviceModelNumber() {
		return DeviceModelNumber;
	}
	public void setDeviceModelNumber(String deviceModelNumber) {
		DeviceModelNumber = deviceModelNumber;
	}
	
}
