package org.anudip.oneToOne.application;

import java.util.Scanner;

import org.anudip.oneToOne.bean.AccountMaster;
import org.anudip.oneToOne.bean.EmployeeMaster;
import org.anudip.oneToOne.dao.DatabaseHandler;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EmployeeEntry {

	public static void main(String[] args) throws Exception {
		
		Scanner scanner = new Scanner(System.in); 
		System.out.println("Enter Employee Id:");
		int id = Integer.parseInt(scanner.nextLine());
		System.out.println("Enter Employee name:");
		String name = scanner.nextLine();
		System.out.println("Enter Department name:");
		String dept = scanner.nextLine();
		System.out.println("Enter Salary:");
		double salary = Double.parseDouble(scanner.nextLine());
		System.out.println("Enter User Id:");
		String user = scanner.nextLine();
		System.out.println("Enter User Password:");
		String password = scanner.nextLine();
		System.out.println("Enter Mail Id:");
		String email = scanner.nextLine();
		
		AccountMaster account = new AccountMaster(id, user, password,email);
		EmployeeMaster employee = new EmployeeMaster(id, name, salary, dept, account);
		
		DatabaseHandler dbHandler = DatabaseHandler.getDatabaseHandler();
		Session session = dbHandler.createSession();
		Transaction transaction = session.beginTransaction();
		session.persist(employee);
		transaction.commit();
		session.close();
		System.out.println("New Record Added");
	}

}