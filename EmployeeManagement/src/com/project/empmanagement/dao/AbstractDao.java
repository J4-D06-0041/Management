package com.project.empmanagement.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import com.project.empmanagement.connection.DbConnector;

public abstract class AbstractDao {
	
	public AbstractDao() {
		// TODO Auto-generated constructor stub
	}
	
	protected ResultSet getData(PreparedStatement ps) {
		try {
			ResultSet rs = ps.executeQuery();
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static PreparedStatement createPreparedStatement (String sql, Object ...args) throws SQLException {
		PreparedStatement ps = DbConnector.getConnection().prepareStatement(sql,
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
