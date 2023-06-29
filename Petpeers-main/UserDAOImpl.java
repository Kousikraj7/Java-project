package com.petpeers.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.petpeers.modal.User;

public class UserDAOImpl implements UserDAO {
	static Connection conn;
	static Logger LOGGER = LogManager.getLogger(UserDAOImpl.class);

	@Override
	public void getConnection() {
		if (conn == null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Petpeers", "root", "root");
				LOGGER.info("Database is Connected");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				LOGGER.debug("Database is Not Connected");
			}
		}
	}

	@Override
	public void closeConnection() {
		try {
			conn.close();
			LOGGER.info("Database is Closed");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.info("Error in Database Connections");
		}
	}

	@Override
	public List<User> findUser() {
		getConnection();
		List<User> userList = new ArrayList<>();
		String queryStr = "select * from user";
		Statement stmt;
		try {
			stmt = conn.createStatement();

			// 3.Execute SQL Statements
			// 4.GET ResultSet
			ResultSet rs = stmt.executeQuery(queryStr);

			while (rs.next()) {
				User tempUser = new User();
				tempUser.setuserid(rs.getInt("userid"));
				tempUser.setName(rs.getString("name"));
				tempUser.setMobileNumber(rs.getString("mobileNumber"));
				tempUser.setCityName(rs.getString("cityName"));
				userList.add(tempUser);
				LOGGER.info("Data is finded from database");
			}
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.info("Error ocurred in finding");
		}
		return userList;
	}

	@Override
	public boolean addUser(User user) {
		getConnection();
		PreparedStatement prestmt1;
		try {
			prestmt1 = conn.prepareStatement("insert into user(name,mobileNumber,cityName) values(?,?,?) ");
			// prestmt1.setInt(1, user.getuserid());//
			// 1 specifies the first parameter in the query
			prestmt1.setString(1, user.getName());
			prestmt1.setString(2, user.getMobileNumber());
			prestmt1.setString(3, user.getCityName());
			prestmt1.executeUpdate();
			System.out.println("A new record is successfully Inserted !");
			prestmt1.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public User findUser(int userid) {
		getConnection();
		String queryStr = "select * from user where userid='" + userid + "'";
		Statement stmt;
		try {
			stmt = conn.createStatement();
			// 3.Execute SQL Statements
			// 4.GET ResultSet
			ResultSet rs = stmt.executeQuery(queryStr);
			User tempUser = new User();
			while (rs.next()) {
				tempUser.setuserid(rs.getInt("userid"));
				tempUser.setName(rs.getString("name"));
				tempUser.setMobileNumber(rs.getString("mobileNumber"));
				tempUser.setCityName(rs.getString("cityName"));
			}
			stmt.close();
			return tempUser;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean deleteUser(User user) {
		getConnection();
		String sql = "delete from user where  userid= '" + user.getuserid() + "'";
		Statement stmt;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("User is Deleted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.info("Data is not Deleted");
		}
		return true;
	}

	@Override
	public boolean updateUser(User user) {
		getConnection();
		int i = 0;
		PreparedStatement prestmt1;
		try {
			prestmt1 = conn
					.prepareStatement("update user set userid=? , name=?,  mobileNumber=?, cityName=?  where userid ='"
							+ user.getuserid() + "'");
			prestmt1.setInt(1, user.getuserid());
			prestmt1.setString(2, user.getName());
			prestmt1.setString(3, user.getMobileNumber());
			prestmt1.setString(4, user.getCityName());
			i = prestmt1.executeUpdate();
			System.out.println("A new record is successfully Upddated !");
			prestmt1.close();
			return true;
		} catch (Exception e) {
			return false;
		}

	}
}
