package com.project.empmanagement.connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBConfigManagement {

	private static DataSource ds;
	
	static {
		try {
			Context initContext = new InitialContext();
			ds = (DataSource) initContext.lookup("java:/comp/env/jdbc/Management");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public DBConfigManagement() {
		// TODO Auto-generated constructor stub
	}
	
	public static DataSource getDataSource() {
		return ds;
	}
}
