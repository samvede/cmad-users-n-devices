package com.glarimy.cmad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class DeviceRepositoryImpl implements DeviceRepository{
	private Map<Integer, Device> DeviceRepo = new HashMap<Integer, Device>();

@Override

public  Device AddDevice(Device device) {
	try {
           		
		   DeviceRepo.put(device.getDeviceId(), device);
		       return device;
		}  catch(Exception e) {
		   return null;
		}
}

@Override

public  Device RemoveDevice(Device device) {
	if (DeviceRepo.containsKey(device.getDeviceId())) {
		DeviceRepo.remove(device.getDeviceId());
		return device;
	} else {
		return null;
	}
}

   @Override
   
public Device DeviceReadByID(int id) {
	    return DeviceRepo.get(id);
}

    @Override
    public List<Device> DeviceReadByDeviceName(String Device, String User) {

	    List<Device> results = new ArrayList<Device>();
	    for (Device device : DeviceRepo.values()) {
        	if(device.getDeviceName().contains(Device) && device.getDeviceUser().contentEquals(User))
		    results.add(device);
        }
        return results;
    }
    
    @Override
    public List<Device> DeviceReadByUserName(String User) {

	    List<Device> results = new ArrayList<Device>();
	    for (Device device : DeviceRepo.values()) {
        	if(device.getDeviceUser().contentEquals(User))
		    results.add(device);
        }
        return results;
    }
    
    @Override
    public List<Device> DeviceReadByModelNumber(String ModelNumber, String User) {

	    List<Device> results = new ArrayList<Device>();
	    for (Device device : DeviceRepo.values()) {
        	if(device.getDeviceModelNumber().contains(ModelNumber) && device.getDeviceUser().contentEquals(User))
		    results.add(device);
        }
        return results;
    }
 }    
