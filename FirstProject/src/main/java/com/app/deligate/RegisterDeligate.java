package com.app.deligate;

import java.sql.SQLException;

import com.app.service.RegisterService;

public class RegisterDeligate {
	private RegisterService registerService;

	public RegisterService getRegisterService() {
		return registerService;
	}

	public void setRegisterService(RegisterService registerService) {
		this.registerService = registerService;
	}

	public boolean newUserRegister(String username, String email, String password) throws SQLException {

		return registerService.newUserRegister(username, email, password);
	}
}
