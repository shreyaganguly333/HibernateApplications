package org.anudip.hibernateXmlApplication.application;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.Scanner;

import org.anudip.hibernateXmlApplication.bean.Country;

public class CountryInsert {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in); 
		System.out.println("Enter country code:");
		int code = Integer.parseInt(scanner.nextLine());
		System.out.println("Enter country name:");
		String name = scanner.nextLine();
		System.out.println("Enter capital name:");
		String capital = scanner.nextLine();
		System.out.println("Enter GDP:");
		double gdp = Double.parseDouble(scanner.nextLine());
		Country country = new Country(code, name, capital, gdp);
		// Configuration object is instantiated
		Configuration config = new Configuration();
		// config object uploads the hibernate.cfg.xml file & reads the configuration informations
	    config.configure("hibernate.cfg.xml");
	 // create session factory object based on the hibernate.cfg.xml file
	      SessionFactory factory=config.buildSessionFactory();
	   // SessionFactory object creates the session object
	   	    Session session=factory.openSession();
	   	// Create transaction object for data insertion
		   	 Transaction transaction=session.beginTransaction();
		   	 //save the recod in database
		   	 session.persist(country);
		   	 //commit the saving
		   	 transaction.commit();
		   	 session.close();
		   	 System.out.println("New Record Added");
		   	 
		   	 

	}

}