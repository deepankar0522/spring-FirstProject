package com.app.dao;

import java.sql.SQLException;

public interface LoginDao {

	public boolean isValidUser(String username, String password) throws SQLException;
	
}
