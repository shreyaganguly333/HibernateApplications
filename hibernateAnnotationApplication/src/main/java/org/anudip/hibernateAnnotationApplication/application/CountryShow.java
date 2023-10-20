package org.anudip.hibernateAnnotationApplication.application;


import java.util.List;

import org.anudip.hibernateAnnotationApplication.bean.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
public class CountryShow {
	public static void main(String[] args) throws Exception {
		Configuration config = new Configuration();
	    config.configure("hibernate.cfg.xml");
	      SessionFactory factory=config.buildSessionFactory();
	   	    Session session=factory.openSession();
	   	 String queryStatement="from Country";
	   	Query<Country> query=session.createQuery(queryStatement);
	    List<Country> countryList=query.list();
	    countryList.forEach(country->System.out.println(country));
		   	 session.close();
	}
}