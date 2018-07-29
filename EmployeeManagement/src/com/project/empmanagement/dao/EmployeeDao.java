package com.project.empmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.project.empmanagement.connection.DbConnector;
import com.project.empmanagement.models.Employee;

public class EmployeeDao {

	private static String selectQuery = "select * from management.employee where last_name = ?";
	private static String insertQuery = "insert into management.employee (first_name,last_name, age) values (?, ?, ?)";
	private static String updateQuery = "update management.employee set first_name = ?, last_name = ?, age = ? where id = ?";
	private static String deleteSpecificQuery = "delete from management.employee where id = ?";
	private static String deleteQuery = "delete from management.employee";

	private static String selectAll = "select * from management.employee";

	public static Connection con = null;

	public static void insertEmployee(String firstname, String lastname, int age) {

		try {
			con = DbConnector.getConnection();
			PreparedStatement ps = con.prepareStatement(insertQuery);
			ps.setString(1, firstname);// to set the values of ? in the db
			ps.setString(2, lastname);
			ps.setInt(3, age);

			ps.executeUpdate();
			System.out.println("Successfully Inserted the Data!!");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static List<Employee> getAllEmployee() {
		List<Employee> listOfEmployee = new ArrayList<Employee>();
		try {
			con = DbConnector.getConnection();
			PreparedStatement ps = con.prepareStatement(selectAll);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Employee emp = new Employee();
				emp.setId(rs.getInt("id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setAge(rs.getInt("age"));

				listOfEmployee.add(emp);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return listOfEmployee;

	}

	public static List<Employee> getSpecificEmployee(String lastname){
		List<Employee> listOfEmployee = new ArrayList<Employee>();
		try {
			con = DbConnector.getConnection();
			PreparedStatement ps = con.prepareStatement(selectQuery);
			ps.setString(1, lastname);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Employee emp = new Employee();
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setAge(rs.getInt("age"));
				listOfEmployee.add(emp);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return listOfEmployee;
	}
	
	public static void updateEmployee(int id ,String firstname, String lastname, int age){
		try {
			con = DbConnector.getConnection();
			PreparedStatement ps = con.prepareStatement(updateQuery);
			ps.setString(1, firstname);
			ps.setString(2, lastname);
			ps.setInt(3, age);
			ps.setInt(4, id);
			
			ps.executeUpdate();
			
			System.out.println("Successfully Updated the data");
			System.out.println(EmployeeDao.getAllEmployee());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static void deleteSpecificEmployee(int id){
		try {
			con = DbConnector.getConnection();
			PreparedStatement ps = con.prepareStatement(deleteSpecificQuery);
			ps.setInt(1, id);
			
			ps.execute();
			
			System.out.println("Successfully Deleted");
			System.out.println(EmployeeDao.getAllEmployee());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void deleteAll(){
		try {
			con = DbConnector.getConnection();
			PreparedStatement ps = con.prepareStatement(deleteQuery);
			ps.executeUpdate();	
			System.out.println("Successfully Deleted");
			System.out.println(EmployeeDao.getAllEmployee());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
