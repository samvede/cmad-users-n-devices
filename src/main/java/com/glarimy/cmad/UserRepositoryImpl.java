package com.glarimy.cmad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository{
	private Map<Integer, User> UserRepo = new HashMap<Integer, User>();    

@Override
public  User AddUser(User user) {
		try {
			   UserRepo.put(user.getUserId(), user);
			       return user;
			}  catch(Exception e) {
			   return null;
			}
}

@Override
public User UserReadById(int id) {
return  UserRepo.get(id);
}

@Override
public List<User> UserReadByName(String User, String password) {

    List<User> results = new ArrayList<User>();
    for (User user : UserRepo.values()) {
	    if(user.getUserName().contentEquals(User) && user.getPassWord().contentEquals(password))
          results.add(user);
    }
return results;
}

}

