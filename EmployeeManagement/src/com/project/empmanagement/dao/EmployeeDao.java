package com.project.empmanagement.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.project.empmanagement.models.Employee;

public class EmployeeDao extends AbstractDao {

	public List<Employee> getEmployeeData(String sql, Object... args) {
		List<Employee> listOfEmployee = new ArrayList<Employee>();
		try {
			PreparedStatement ps = createPreparedStatement(sql, args);
			ResultSet rs = getData(ps);
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setId(rs.getInt("id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setAge(rs.getInt("age"));
				listOfEmployee.add(emp);
			}
			return listOfEmployee;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
