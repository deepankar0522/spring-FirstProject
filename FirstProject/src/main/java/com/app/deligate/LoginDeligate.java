package com.app.deligate;

import com.app.service.UserService;

public class LoginDeligate {
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public boolean isValidUser(String username, String password) {

		return userService.isValidUser(username, password);
	}

}
