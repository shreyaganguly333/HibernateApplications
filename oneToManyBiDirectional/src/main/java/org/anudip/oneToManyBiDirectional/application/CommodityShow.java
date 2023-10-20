package org.anudip.oneToManyBiDirectional.application;

import org.anudip.oneToManyBiDirectional.bean.Commodity;
import org.anudip.oneToManyBiDirectional.dao.DatabaseHandler;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CommodityShow {

	public static void main(String[] args) throws Exception {
		DatabaseHandler dbHandler=DatabaseHandler.getDatabaseHandler();
   	    Session session=dbHandler.createSession();
   	 String queryStatement="from Commodity";
   	Query<Commodity> query=session.createQuery(queryStatement);
    List<Commodity> commodityList=query.list();
    //Collections.sort(commodityList,Collections.reverseOrder());
    //Collections.reverse(commodityList);
    Collections.sort(commodityList, Comparator.comparing(Commodity::getCommodityName).reversed());
   commodityList.forEach(cL->System.out.println(cL));
	   	 session.close();
	}

}