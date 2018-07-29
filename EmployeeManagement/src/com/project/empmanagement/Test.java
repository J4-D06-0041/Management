package com.project.empmanagement;

import java.sql.SQLException;
import java.util.Scanner;

import com.project.empmanagement.dao.EmployeeDao;
import com.project.empmanagement.models.Employee;

public class Test {

	public static Scanner cj = new Scanner(System.in);

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		menu();
	}

	public static void menu() {
		System.out.println("********************************");
		System.out.println("*----My DATABASE ACCCES MENU---*");
		System.out.println("*------Press the following-----*");
		System.out.println("* 1. Insert Employee           *");
		System.out.println("* 2. Get Specific Employee     *");
		System.out.println("* 3. Get All Employee          *");
		System.out.println("* 4. Update Employee           *");
		System.out.println("* 5. Delete Specific Employee  *");
		System.out.println("* 6. Delete All Employee       *");
		System.out.println("********************************");

		int num;
		char input = 0;
		char confirm = 0;

		do {
			System.out.println("Choose your Number:");
			num = Integer.parseInt(cj.nextLine());
		} while (num < 1 || num > 7);

		if (num == 1) {
			System.out.println("You've Chosen to Insert Employee");
			System.out.println("Enter first name:");
			String firstName = cj.next();
			System.out.println("Enter last name:");
			String lastName = cj.next();
			System.out.println("Enter age:");
			int age = cj.nextInt();
			
			EmployeeDao.insertEmployee(firstName, lastName, age);

		} else if (num == 2) {
			System.out.println("You've Chosen to Get Specific Employee");
			System.out.println(EmployeeDao.getAllEmployee());
			System.out.println("Choose the last name you want to get:");
			String lastName = cj.next();
			
			System.out.println(EmployeeDao.getSpecificEmployee(lastName));
			
		} else if (num == 3) {
			System.out.println("You've Chosen to Get All Employee");
			System.out.println(EmployeeDao.getAllEmployee());
		} else if (num == 4) {
			System.out.println("You've Chosen to Update Employee");
			System.out.println(EmployeeDao.getAllEmployee());
			System.out.println("Select the ID of the Data to Update:");
			int id = Integer.parseInt(cj.nextLine());
			System.out.println("Now, Enter the first name");
			String firstName = cj.nextLine();
			System.out.println("Now, Enter the last name");
			String lastName = cj.nextLine();
			System.out.println("Now, Enter the age:");
			int age = cj.nextInt();
			
			EmployeeDao.updateEmployee(id, firstName, lastName, age);
			
			
			
		} else if (num == 5) {
			System.out.println("You've Chosen to Delete Specific Employee");
			System.out.println(EmployeeDao.getAllEmployee());
			System.out.println("Enter The ID:");
			int id = cj.nextInt();
			
			EmployeeDao.deleteSpecificEmployee(id);
		} else if (num == 6) {
			do {
				System.out.println("You've Chosen to Delete All Employee");
				System.out.println(EmployeeDao.getAllEmployee());
				System.out.println("Do you want to Delete all?");
				System.out.println("Y = Yes N = NO");
				confirm = cj.next().charAt(0);
				EmployeeDao.deleteAll();
			} while (confirm != 'n');
		}

		do {
			System.out.println("Do you Want Another Transaction?");
			System.out.println("Y = Yes N = NO");
			input = cj.next().toLowerCase().charAt(0);
		} while (input != 'y' && input != 'n');

		if (input == 'y')
			menu();
		else
			System.out.println("Bye");
	}

}
