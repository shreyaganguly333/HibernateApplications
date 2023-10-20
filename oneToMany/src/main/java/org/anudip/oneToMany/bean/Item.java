package org.anudip.oneToMany.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {
	@Id
	@Column(name="serial_number")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long serialNumber;
	
	@Column(name="item_name")
	private String itemName;
	private Double price;
	@Column(name="purchase_quantity")
	private Double purchaseQuantity;
	private Double amount;
	@Column(name="bill_number")
	private Long billNumber;
	
	public Item() {
		super();	
	}
	
	public Item(String itemName, Double price, Double purchaseQuantity, Double amount,
			Long billNumber) {
		super();
		this.itemName = itemName;
		this.price = price;
		this.purchaseQuantity = purchaseQuantity;
		this.amount = amount;
		this.billNumber = billNumber;
	}
	public Long getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(Long serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getPurchaseQuantity() {
		return purchaseQuantity;
	}
	public void setPurchaseQuantity(Double purchaseQuantity) {
		this.purchaseQuantity = purchaseQuantity;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Long getBillNumber() {
		return billNumber;
	}
	public void setBillNumber(Long billNumber) {
		this.billNumber = billNumber;
	}
	
	@Override
	public String toString() {
		String output=String.format("%-5s %-15s %-10s %-10s %-10s",serialNumber,itemName,price,purchaseQuantity,amount);
		return output;
	}
}