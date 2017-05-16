package com.user.reg.web.dao;

import java.util.List;

import com.user.reg.web.model.UserModel;

public interface UserDao {

	public void saveUser(UserModel userModel);

	public List<UserModel> getUser();
	
	public List<UserModel> getUsers();
}
