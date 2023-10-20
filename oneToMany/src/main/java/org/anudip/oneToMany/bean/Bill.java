package org.anudip.oneToMany.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Bill {
	@Id
	@Column(name="bill_number")
	private Long billNumber;
	@Column(name="customer_name")
	private String customerName;
	@Column(name="total_payment")
	private Double totalPayment;
	@OneToMany(fetch=FetchType.LAZY, targetEntity=Item.class,cascade=CascadeType.ALL) 
	@JoinColumn(name = "bill_number",referencedColumnName="bill_number")
	private List<Item> itemList;
	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bill(Long billNumber, String customerName, Double totalPayment, List<Item> itemList) {
		super();
		this.billNumber = billNumber;
		this.customerName = customerName;
		this.totalPayment = totalPayment;
		this.itemList = itemList;
	}
	public Long getBillNumber() {
		return billNumber;
	}
	public void setBillNumber(Long billNumber) {
		this.billNumber = billNumber;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Double getTotalPayment() {
		return totalPayment;
	}
	public void setTotalPayment(Double totalPayment) {
		this.totalPayment = totalPayment;
	}
	public List<Item> getItemList() {
		return itemList;
	}
	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}
	@Override
	public String toString() {
		String output=String.format("%-10s %-15s %-10s %-2s",billNumber,customerName,totalPayment,itemList);
		return output;
	}
	

}
