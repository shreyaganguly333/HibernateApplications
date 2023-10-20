package org.anudip.hibernateAnnotationApplication.application;

import org.anudip.hibernateAnnotationApplication.bean.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.Scanner;
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
		Configuration config = new Configuration();
	    config.configure("hibernate.cfg.xml");
	      SessionFactory factory=config.buildSessionFactory();
	   	    Session session=factory.openSession();
		   	 Transaction transaction=session.beginTransaction();
		   	 session.persist(country);
		   	 transaction.commit();
		   	 session.close();
		   	 System.out.println("New Record Added");		   	 
	}
}