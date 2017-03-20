package com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.app.model.UserRegVO;


public class RegisterDaoImpl implements RegisterDao {

	DataSource dataSource;
	private Connection connection = null;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public boolean newUserRegister(String username, String email, String password) throws SQLException {
		boolean success = false;
		connection = dataSource.getConnection();
		System.out.println("IN DAO: "+email+password);
		String query = "insert into userlogin(email, password) values(?,?);";
		try {
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			boolean result = pstmt.execute();

			UserRegVO userRegVO = new UserRegVO();
			if (result) {
				success = result;
			} else {
				success = false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return success;
	}

}
