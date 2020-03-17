package com.glarimy.cmad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin

@EnableSwagger2

public class UserDeviceMgmtController {

	@Autowired
	private UserRepository UserRepo;
	

	@RequestMapping(path = "/users", method = RequestMethod.POST)
	public ResponseEntity<User> adduser(@RequestBody User user) {
 		UserRepo.AddUser(user);
		try {
			return new ResponseEntity<User>(user, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<User>(user, HttpStatus.UNAUTHORIZED);
		}
	}

	@RequestMapping(path = "users/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> finduser(@PathVariable(value="id") int id) {
		User user = UserRepo.UserReadById(id);
		try  {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	}
	    
	@RequestMapping(path = "users/{name}/", method = RequestMethod.GET)
	public ResponseEntity<List<User>> searchuser(@RequestParam(value = "name") String name,
			@RequestParam(value = "size", defaultValue = "50") int size, @RequestParam(value= "passwd") String password) {
		    
		List<User> user_names = UserRepo.UserReadByName(name, password);
			if (user_names.isEmpty()) {
				return new ResponseEntity<List<User>>(user_names, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<List<User>>(user_names, HttpStatus.OK);		
			}

    }
	
	@Autowired
	private DeviceRepository DeviceRepo;
	@RequestMapping(path = "/devices", method = RequestMethod.POST)
	public ResponseEntity<Device> adduser(@RequestBody Device device) {
 		DeviceRepo.AddDevice(device);
	    try {
			return new ResponseEntity<Device>(device, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Device>(device, HttpStatus.UNAUTHORIZED);
		}
	}

	@RequestMapping(path = "/devices", method = RequestMethod.DELETE)
	public ResponseEntity<Device> removedevice(@RequestBody Device device, @RequestParam(value ="DeviceUser") String user) {
		if (device.getDeviceUser().contentEquals(user)) {
			Device tempDevice =DeviceRepo.RemoveDevice(device);
			if (tempDevice != null) {
			    return new ResponseEntity<Device>(tempDevice, HttpStatus.OK);
			} else {
				return new ResponseEntity<Device>(tempDevice, HttpStatus.NOT_FOUND);
			}
		 } else {
			return new ResponseEntity<Device>(device, HttpStatus.UNAUTHORIZED);
		}
	}
	@RequestMapping(path = "devices/{id}", method = RequestMethod.GET)
	public ResponseEntity<Device> finddevice(@PathVariable(value="id") int id, @RequestParam(value ="DeviceUser") String user) {
		Device device = DeviceRepo.DeviceReadByID(id);
		if ((device != null) && device.getDeviceUser().contentEquals(user)) {
			return new ResponseEntity<Device>(device, HttpStatus.OK);
		} else {
			Device NullDevice = null;
			return new ResponseEntity<Device>(NullDevice, HttpStatus.UNAUTHORIZED);
		}
	}
	    
	@RequestMapping(path = "devices/{name}/", method = RequestMethod.GET)
	public ResponseEntity<List<Device>> searchdevicebyname(@RequestParam(value = "name") String name,
			@RequestParam(value = "size", defaultValue = "50") int size, @RequestParam(value ="DeviceUser") String user) {
			List<Device> device_names = DeviceRepo.DeviceReadByDeviceName(name, user);
			if (device_names.isEmpty()) {
				return new ResponseEntity<List<Device>>(device_names, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<List<Device>>(device_names, HttpStatus.OK);		
			}
     }
	@RequestMapping(path = "devices/{modelName}/", method = RequestMethod.GET)
	public ResponseEntity<List<Device>> searchdevicebymodel(@RequestParam(value = "modelName") String modelName,
			@RequestParam(value = "size", defaultValue = "50") int size, @RequestParam(value ="DeviceUser") String user) {
			List<Device> device_names = DeviceRepo.DeviceReadByModelNumber(modelName, user);
			if (device_names.isEmpty()) {
				return new ResponseEntity<List<Device>>(device_names, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<List<Device>>(device_names, HttpStatus.OK);		
			}
     }
	
	@RequestMapping(path = "devices/{user}/", method = RequestMethod.GET)
	public ResponseEntity<List<Device>> searchdevicebyuser(@RequestParam(value = "user") String user,
			@RequestParam(value = "size", defaultValue = "50") int size) {
			List<Device> device_names = DeviceRepo.DeviceReadByUserName(user);
			if (device_names.isEmpty()) {
				return new ResponseEntity<List<Device>>(device_names, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<List<Device>>(device_names, HttpStatus.OK);		
			}
     }
}