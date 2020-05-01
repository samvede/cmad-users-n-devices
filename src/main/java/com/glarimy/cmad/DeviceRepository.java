package com.glarimy.cmad;

import java.util.List;

public interface DeviceRepository{

	Device AddDevice(Device device);

	Device DeviceReadByID(int DeviceId);

	List<Device> DeviceReadByDeviceName(String Device, String DeviceUser);
	
	List<Device> DeviceReadByUserName(String DeviceUser);
	
	List<Device> DeviceReadByModelNumber(String DeviceModelNumber, String DeviceUser);
	
	Device RemoveDevice(Device device);

}
