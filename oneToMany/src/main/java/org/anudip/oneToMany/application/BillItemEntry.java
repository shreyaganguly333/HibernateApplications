package org.anudip.oneToMany.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.anudip.oneToMany.bean.Bill;
import org.anudip.oneToMany.bean.Item;
import org.anudip.oneToMany.dao.DatabaseHandler;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BillItemEntry {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in); 
		System.out.println("Enter Bill Number:");
		long billNo = Long.parseLong(scanner.nextLine());
		System.out.println("Enter Customer name:");
		String customerName = scanner.nextLine();
		System.out.println("Enter number of items to purchase:");
		int no = Integer.parseInt(scanner.nextLine());
		double totalPayment = 0.0;
		List<Item> itemList = new ArrayList<>();
		for(int i=0;i<no;i++) {
			System.out.println("Enter Item Name: ");
			String itemName = scanner.nextLine();
			System.out.println("Enter Item Price: ");
			double price = Double.parseDouble(scanner.nextLine());
			System.out.println("Enter Quantity Purchased: ");
			double qty = Double.parseDouble(scanner.nextLine());
			double amount = qty*price;
			System.out.println("The Amount payable: "+amount);
			totalPayment = totalPayment+amount;
			Item item = new Item(itemName, price, qty, amount, billNo);
			itemList.add(item);
		}
		Bill bill = new Bill(billNo, customerName, totalPayment, itemList);
		DatabaseHandler dbHandler = DatabaseHandler.getDatabaseHandler();
		Session session = dbHandler.createSession();
		Transaction transaction = session.beginTransaction();
		session.persist(bill);
		transaction.commit();
		session.close();
		System.out.println("New Record Added");
	}

}