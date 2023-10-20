package org.anudip.hibernatePropertiesApplication.application;
import java.util.List;
import java.util.Properties;

import org.anudip.hibernatePropertiesApplication.bean.Country;
import org.anudip.hibernatePropertiesApplication.dao.DatabaseHandler;
import org.hibernate.Query;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CountryShow {

	public static void main(String[] args) throws Exception {
	DatabaseHandler dbHandler=DatabaseHandler.getDatabaseHandler();
 	  Session session= dbHandler.createSession();
	   	 String queryStatement="from Country";
	   	 Query<Country> query = session.createQuery(queryStatement);
	   	List<Country> countryList=query.list();
	   	countryList.forEach(country->System.out.println(country));
         session.close();
	}

}