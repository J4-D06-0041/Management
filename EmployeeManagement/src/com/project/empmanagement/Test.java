package com.project.empmanagement;

import java.sql.SQLException;
import java.util.Scanner;

import com.project.empmanagement.dao.EmployeeDao;
import com.project.empmanagement.dao.RegisterDao;

public class Test{
	public static int action;
	public static Scanner cj = new Scanner(System.in);
	
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		System.out.println("********************************");
		System.out.println("*--------WELCOME---------");
		System.out.println("*--PLEASE SELECT ACTION--");
		System.out.println("*-      1. Log-In      -*");
		System.out.println("*-      2. Register    -*");
		System.out.println("********************************");
		
		do {
			System.out.println("CHOOSE NUMBER: ");
			action = Integer.parseInt(cj.nextLine());
		} while (action < 1 || action > 2);
		
		
		action();

		

		/* register(); */
		/* menu(); */
	}
	public static void action(){
		String inputUserName;
		String inputPassword;
		if (action == 1) {
			System.out.println("********************************");
			System.out.println("*--------Please Log-In--------");
			System.out.println("********************************");
			System.out.println("Enter User Name: ");
			inputUserName = cj.nextLine();
			System.out.println("Enter Password: ");
			inputPassword = cj.nextLine();
			RegisterDao.compare(inputUserName, inputPassword);
		}else if (action == 2){
			register();
		}
	}

	public static void register() {
		System.out.println("********************************");
		System.out.println("*--------Please Register--------");
		System.out.println("********************************");

		System.out.println("Enter Username: ");
		String userName = cj.nextLine();
		System.out.println("Enter Password: ");
		String password = cj.nextLine();
		System.out.println("Enter First Name: ");
		String firstName = cj.nextLine();
		System.out.println("Enter First Name: ");
		String lastName = cj.nextLine();

		RegisterDao.insertUser(userName, password, firstName, lastName);

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
				System.out.println("You've Chosen to Delete All Employee");
				System.out.println(EmployeeDao.getAllEmployee());
				do {
					System.out.println("Do you want to Delete all?");
					System.out.println("Y = Yes N = NO");
					confirm = cj.next().charAt(0);
				} while (confirm != 'y');
				if(confirm == 'y'){
					EmployeeDao.deleteAll();
					
				}else if (confirm == 'n'){
					System.out.println("Operation Cancelled");
				}
				
			
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
