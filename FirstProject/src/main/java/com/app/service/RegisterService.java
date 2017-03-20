package com.app.service;

import java.sql.SQLException;

public interface RegisterService {

	boolean newUserRegister(String username, String email, String password) throws SQLException;

}
