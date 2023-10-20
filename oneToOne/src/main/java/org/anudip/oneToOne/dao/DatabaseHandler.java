package org.anudip.oneToOne.dao;

import java.util.Properties;

import org.anudip.oneToOne.bean.AccountMaster;
import org.anudip.oneToOne.bean.EmployeeMaster;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DatabaseHandler {
	private static DatabaseHandler dbHandler=new DatabaseHandler();
	private DatabaseHandler()   {
		
	}
	public static DatabaseHandler getDatabaseHandler()   {
		return dbHandler;
		
	}
	public  Session createSession()  throws Exception {
				//Properties class stores data in key/values pair so we declare an object of Properties class
				Properties property=new Properties();
				//object of Properties class load hibernate.properties file and store it's contents in key/value pair
				property.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("hibernate.properties"));
				Configuration config = new Configuration();
			    config.setProperties(property);
			    //mention the Object Relational Mapper Class
			    config.addAnnotatedClass(AccountMaster.class);
			    config.addAnnotatedClass(EmployeeMaster.class);
			      SessionFactory factory=config.buildSessionFactory();
			   	    Session session=factory.openSession();
			   	    return session;
		
	}
	

}