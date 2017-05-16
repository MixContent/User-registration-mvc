package com.user.reg.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.user.reg.web.dto.UserDTO;
import com.user.reg.web.service.UserServices;

@Controller
public class UserController {
	@Autowired
	private UserServices services;

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public String register(Model model,
			@ModelAttribute("userDTO") UserDTO userDTO) {
		String message = services.SaveUser(userDTO);
		model.addAttribute("message", message);
		return "registeration";
	}

	@RequestMapping(value = "/getUsers", method = RequestMethod.GET)
	public String getUsers(Model model) {
		List<UserDTO> users = services.getUserInfo();
		model.addAttribute("users", users);
		return "users";
	}
}
