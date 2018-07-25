package com.project.empmanagement.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface DaoInterface {

	public boolean insertData(PreparedStatement ps);
	public int updateData(PreparedStatement ps);
	public int deleteData(PreparedStatement ps);
	ResultSet getData(PreparedStatement ps);
	
}
