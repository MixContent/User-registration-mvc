package com.user.reg.web.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.reg.web.dao.UserDao;
import com.user.reg.web.dto.UserDTO;
import com.user.reg.web.util.UserUtility;

@Service
@Transactional
public class UserServices {
	@Autowired
	private UserDao dao;
	@Autowired
	private UserUtility utility;

	public String SaveUser(UserDTO user) {
		String message = "";
		if (user != null) {
			dao.saveUser(utility.mapDtoToModel(user));
			message = "Registration successfully";
		} else {
			message = "Registration failed..";
		}
		return message;
	}

	public List<UserDTO> getUserInfo() {
		return utility.getDtoFromModel(dao.getUsers());
	}
}
