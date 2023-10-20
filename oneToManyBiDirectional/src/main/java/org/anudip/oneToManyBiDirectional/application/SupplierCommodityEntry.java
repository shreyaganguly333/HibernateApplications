package org.anudip.oneToManyBiDirectional.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.anudip.oneToManyBiDirectional.bean.Commodity;
import org.anudip.oneToManyBiDirectional.bean.Suppliers;
import org.anudip.oneToManyBiDirectional.dao.DatabaseHandler;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SupplierCommodityEntry {

public static void main(String[] args) throws Exception{
	Scanner scanner = new Scanner(System.in); 
	
	System.out.println("Enter Supplier Name:");
	String supplierName = scanner.nextLine();
	Suppliers supplier=new Suppliers(supplierName);
	
	System.out.println("Enter the number of items to supply:");
	int no=Integer.parseInt(scanner.nextLine());
	List<Commodity> commodityList = new ArrayList<>();
	
	for(int i=0;i<no;i++) {
		System.out.println("Enter Item Name: ");
		String itemName = scanner.nextLine();
		System.out.println("Enter Item Price: ");
		double price = Double.parseDouble(scanner.nextLine());
		System.out.println("Enter Quantity Supplied: ");
		double qty = Double.parseDouble(scanner.nextLine());
		Commodity commodity=new Commodity(itemName, price, qty, supplier);
		commodityList.add(commodity);
	}
	supplier.setCommodityList(commodityList);
	
	DatabaseHandler dbHandler = DatabaseHandler.getDatabaseHandler();
	Session session = dbHandler.createSession();
	Transaction transaction = session.beginTransaction();
	session.persist(supplier);
	transaction.commit();
	session.close();
	System.out.println("New Supplier Added");
}

}

