package org.anudip.oneToMany.application;

import java.util.List;
import org.anudip.oneToMany.bean.Bill;
import org.anudip.oneToMany.dao.DatabaseHandler;
import org.hibernate.Query;
import org.hibernate.Session;


public class BillItemShow {

	public static void main(String[] args) throws Exception{
		DatabaseHandler dbHandler=DatabaseHandler.getDatabaseHandler();
		Session session=dbHandler.createSession();
		String queryStatement="from Bill";
		 Query<Bill> query=session.createQuery(queryStatement);
		List<Bill> billList=query.list();
		billList.forEach(bill->System.out.println(bill));
		session.close();
	}

}
