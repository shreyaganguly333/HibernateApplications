package org.anudip.hibernateXmlApplication.application;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

import org.anudip.hibernateXmlApplication.bean.Country;

public class CountryShow {

	public static void main(String[] args) throws Exception {
				// Configuration object is instantiated
		Configuration config = new Configuration();
		// config object uploads the hibernate.cfg.xml file & reads the configuration informations
	    config.configure("hibernate.cfg.xml");
	 // create session factory object based on the hibernate.cfg.xml file
	      SessionFactory factory=config.buildSessionFactory();
	   // SessionFactory object creates the session object
	   	    Session session=factory.openSession();
	   	 String queryStatement="from Country";
			   	Query<Country> query=session.createQuery(queryStatement);
			    List<Country> countryList=query.list();
			    countryList.forEach(country->System.out.println(country));
	    
	    
	    session.close();
         
	}

}