package com.app.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class UserDaoImpl implements UserDao {

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	DataSource dataSource;

	@Override
	public boolean isValidUser(String username, String password) {
		boolean isValid = false;
		String query = "Select count(1) from UserLogin where username = ? and password = ?";
		try {
			PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet result = pstmt.executeQuery();

			if (result.next()) {
				isValid = (result.getInt(1) > 1);
			} else {
				isValid = false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isValid;
	}
}
