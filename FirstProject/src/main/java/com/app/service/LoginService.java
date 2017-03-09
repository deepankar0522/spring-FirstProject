package com.app.service;

import java.sql.SQLException;

public interface LoginService {
	
	public boolean isValidUser(String username, String password) throws SQLException;
	
}
