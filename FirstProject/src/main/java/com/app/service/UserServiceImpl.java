package com.app.service;

import com.app.dao.UserDao;

public class UserServiceImpl implements UserService{

	private UserDao userDAO;
	
	public UserDao getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDao userDAO) {
		this.userDAO = userDAO;
	}
	@Override
	public boolean isValidUser(String username, String password) {
		return userDAO.isValidUser(username, password);
		
	}
}
