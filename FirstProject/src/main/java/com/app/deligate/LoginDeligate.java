package com.app.deligate;

import java.sql.SQLException;

import com.app.service.LoginService;

public class LoginDeligate {
	private LoginService userService;

	public LoginService getUserService() {
		return userService;
	}

	public void setUserService(LoginService userService) {
		this.userService = userService;
	}

	public boolean isValidUser(String username, String password) throws SQLException {

		return userService.isValidUser(username, password);
	}

}
