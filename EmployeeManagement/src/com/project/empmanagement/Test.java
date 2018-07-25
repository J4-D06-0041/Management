package com.project.empmanagement;

import java.sql.SQLException;
import java.util.Scanner;

import com.project.empmanagement.dao.EmployeeDao;

public class Test {

	public static Scanner cj = new Scanner(System.in);

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// System.out.println(DbConnector.getConnection());
		//
		// System.out.println("Enter your first name:");
		// String firstName = cj.nextLine();
		//
		// System.out.println("Enter your last name:");
		// String lastName = cj.nextLine();
		//
		// System.out.println("Enter your last age:");
		// int age = cj.nextInt();
		//
		// // create insert query
		// String query = "insert into management.employee (first_name,
		// last_name, age) values (?, ?, ?)";
		// DbConnector.createPreparedStatement(query, firstName, lastName,
		// age).execute();
		// try {
		// System.out.println("Enter the last name you want to fetch");
		// String lastname = cj.nextLine();
		// String query = "select * from management.employee where last_name =
		// ?";
		//
		// ResultSet rs = DbConnector.createPreparedStatement(query,
		// lastname).executeQuery();
		// ResultSetMetaData meta = rs.getMetaData();
		//
		// Employee emp = new Employee();
		// while(rs.next()) {
		// emp.setId(rs.getInt("id"));
		// emp.setFirstName(rs.getString("first_name"));
		// emp.setLastName(rs.getString("last_name"));
		// emp.setAge(rs.getInt("age"));
		// }
		//
		// System.out.println(emp.toString());
		//
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

		// try {
		// System.out.println("Enter the last name you want to fetch");
		// String lastname = cj.nextLine();
		// String query = "select * from management.employee where last_name =
		// ?";
		//
		// ResultSet rs = DbConnector.createPreparedStatement(query,
		// lastname).executeQuery();
		// ResultSetMetaData meta = rs.getMetaData();
		//
		// List<Employee> listOfEmployee = new ArrayList<Employee>();
		// while(rs.next()) {
		// Employee emp = new Employee();
		// emp.setId(rs.getInt("id"));
		// emp.setFirstName(rs.getString("first_name"));
		// emp.setLastName(rs.getString("last_name"));
		// emp.setAge(rs.getInt("age"));
		// listOfEmployee.add(emp);
		// }
		//
		// System.out.println(listOfEmployee);
		//
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

		System.out.println("Enter the last name you want to fetch");
		String lastname = cj.nextLine();
		String query = "select * from management.employee where last_name = ?";
		EmployeeDao empDao = new EmployeeDao();
		System.out.println(empDao.getEmployeeData(query, lastname));
	}

}
