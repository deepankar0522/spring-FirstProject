package com.app.dao;

import java.sql.SQLException;

public interface RegisterDao {
	
	public boolean newUserRegister(String username, String email, String password) throws SQLException; 
		
}
