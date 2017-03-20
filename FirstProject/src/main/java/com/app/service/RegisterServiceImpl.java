package com.app.service;

import java.sql.SQLException;

import com.app.dao.RegisterDao;

public class RegisterServiceImpl implements RegisterService {

	private RegisterDao registerDao;

	public RegisterDao getRegisterDao() {
		return registerDao;
	}

	public void setRegisterDao(RegisterDao registerDao) {
		this.registerDao = registerDao;
	}

	@Override
	public boolean newUserRegister(String username, String email, String password) throws SQLException {
		return registerDao.newUserRegister(username, email, password);
	}

}
