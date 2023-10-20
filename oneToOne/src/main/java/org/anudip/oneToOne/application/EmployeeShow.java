package org.anudip.oneToOne.application;
import java.util.List;
import org.anudip.oneToOne.bean.EmployeeMaster;
import org.anudip.oneToOne.dao.DatabaseHandler;
import org.hibernate.Session;
import org.hibernate.query.Query;
public class EmployeeShow {
	public static void main(String[] args) throws Exception{
				DatabaseHandler dbHandler=DatabaseHandler.getDatabaseHandler();
			   	    Session session=dbHandler.createSession();
			   	 String queryStatement="from EmployeeMaster";
			   	Query<EmployeeMaster> query=session.createQuery(queryStatement);
			    List<EmployeeMaster> employeeList=query.list();
			    employeeList.forEach(emp->System.out.println(emp));
				   	 session.close();
	}
}