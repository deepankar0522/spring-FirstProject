package com.app.service;

import java.sql.SQLException;

import com.app.dao.LoginDao;

public class LoginServiceImpl implements LoginService {

	private LoginDao loginDAO;

	public LoginDao getUserDAO() {
		return loginDAO;
	}

	public void setUserDAO(LoginDao userDAO) {
		this.loginDAO = userDAO;
	}

	@Override
	public boolean isValidUser(String username, String password) throws SQLException {
		return loginDAO.isValidUser(username, password);

	}
}
