package com.glarimy.cmad;

import java.util.List;

public interface UserRepository{

	User AddUser(User user);

	User UserReadById(int id);

	List<User> UserReadByName(String name, String password);

}