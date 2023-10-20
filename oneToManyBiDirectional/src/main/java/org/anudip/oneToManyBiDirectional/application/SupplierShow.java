package org.anudip.oneToManyBiDirectional.application;

import java.util.List;
import org.anudip.oneToManyBiDirectional.bean.Suppliers;
import org.anudip.oneToManyBiDirectional.dao.DatabaseHandler;
import org.hibernate.Session;
import org.hibernate.query.Query;
public class SupplierShow {

	public static void main(String[] args) throws Exception {
		DatabaseHandler dbHandler=DatabaseHandler.getDatabaseHandler();
   	    Session session=dbHandler.createSession();
   	 String queryStatement="from Suppliers";
   	Query<Suppliers> query=session.createQuery(queryStatement);
    List<Suppliers> supplierList=query.list();
    supplierList.forEach(cL->System.out.println(cL));
    session.close();
	}
}
