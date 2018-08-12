package com.project.empmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.project.empmanagement.Test;
import com.project.empmanagement.connection.DbConnector;
import com.project.empmanagement.models.Register;

public class RegisterDao {

	private static String insertUserQuery = "insert into management.users (user_name,password, first_name, last_name) values (?, ?, ?, ?)";
	private static String compareQuery = "select user_name, password from management.users where user_name = ? or password = ?";
	private static String selectAllUser = "select * from management.users";
	private static Connection con = null;

	public static void insertUser(String username, String password, String name, String lastname) {

		try {
			con = DbConnector.getConnection();
			PreparedStatement ps = con.prepareStatement(insertUserQuery);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, name);
			ps.setString(4, lastname);

			ps.executeUpdate();
			System.out.println("Successfully registered the Data!!");
			System.out.println(RegisterDao.getAllUser());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static List<Register> getAllUser() {
		List<Register> listOfUsers = new ArrayList<Register>();
		try {
			con = DbConnector.getConnection();
			PreparedStatement ps = con.prepareStatement(selectAllUser);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Register user = new Register();
				user.setId(rs.getInt("userId"));
				user.setUserName(rs.getString("user_name"));
				user.setPassWord(rs.getString("password"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));

				listOfUsers.add(user);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return listOfUsers;

	}

	public static String compare(String username, String password) throws Exception {
		try {
			con = DbConnector.getConnection();
			PreparedStatement ps = con.prepareStatement(compareQuery);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				String userInput;
				String passwordInput;
				userInput = rs.getString("user_name");
				passwordInput = rs.getString("password");
				do {
					if (userInput.equals(username) && passwordInput.equals(password)) {
						return ("Successfully Logged-In");
//						Test.menu();
					} else if (userInput.equals(username) && !passwordInput.equals(password)) {
						return ("Invalid Password");
//						System.out.println("Try Again");
//						Test.action();

					} else if (!userInput.equals(username) && passwordInput.equals(password)) {
						return ("Invalid Username");
//						System.out.println("Try Again");
//						Test.action();
					} else{
						return ("Invalid UserName and Password:");
//						System.out.println("Try Again");
//						Test.action();
					}
				} while (!userInput.equals(username) || !passwordInput.equals(password));

			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			throw e;
		}
		return "";

	}

}
