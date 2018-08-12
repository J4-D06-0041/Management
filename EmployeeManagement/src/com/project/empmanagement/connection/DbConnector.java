package com.project.empmanagement.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class DbConnector {

	private static String url = "jdbc:mysql://localhost:3306/management?characterEncoding=utf8&amp";
	private static String user = "root";
	private static String pass = "root";
	public DbConnector() {
		// TODO Auto-generated constructor stub
	}

	static Connection con;

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager
					.getConnection(url, user, pass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		return con;
	}
	
	public static PreparedStatement createPreparedStatement (String sql, Object ...args) throws SQLException {
		PreparedStatement ps = getConnection().prepareStatement(sql,
				Statement.RETURN_GENERATED_KEYS);
		for (int i = 0; i < args.length; i++) {
			Object o = args[i];
			if (o instanceof Date)
				o = new java.sql.Date(((Date) o).getTime());
			ps.setObject(i + 1, o);
		}
		return ps;
	}
}
