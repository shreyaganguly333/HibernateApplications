package org.anudip.oneToManyBiDirectional.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.anudip.oneToManyBiDirectional.bean.Commodity;
import org.anudip.oneToManyBiDirectional.bean.Suppliers;
import org.anudip.oneToManyBiDirectional.dao.DatabaseHandler;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CommoditySupplierEntry {

	public static void main(String[] args) throws Exception{
		Scanner scanner = new Scanner(System.in); 
		
		System.out.println("Enter Supplier Name:");
		String supplierName = scanner.nextLine();
		Suppliers supplier=new Suppliers(supplierName);
		
		List<Commodity> commodityList = new ArrayList<>();
		
			System.out.println("Enter Item Name: ");
			String itemName = scanner.nextLine();
			System.out.println("Enter Item Price: ");
			double price = Double.parseDouble(scanner.nextLine());
			System.out.println("Enter Quantity Supplied: ");
			double qty = Double.parseDouble(scanner.nextLine());
			Commodity commodity=new Commodity(itemName, price, qty, supplier);
			commodityList.add(commodity);
		
		supplier.setCommodityList(commodityList);
		
		DatabaseHandler dbHandler = DatabaseHandler.getDatabaseHandler();
		Session session = dbHandler.createSession();
		Transaction transaction = session.beginTransaction();
		session.persist(commodity);
		transaction.commit();
		session.close();
		System.out.println("New Commodity Added");
	}

}


