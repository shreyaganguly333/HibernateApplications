package org.anudip.oneToManyBiDirectional.bean;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Suppliers {
	@Id
	@Column(name = "supplier_number")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long supplierNumber;
	@Column(name = "supplier_name")
	private String supplierName;
	
	@OneToMany(fetch = FetchType.LAZY, targetEntity = Commodity.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "supplier_number",referencedColumnName = "supplier_number")
	private List<Commodity> commodityList;

	public Suppliers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Suppliers(String supplierName) {
		super();
		this.supplierName = supplierName;
		
	}

	public Long getSupplierNumber() {
		return supplierNumber;
	}

	public void setSupplierNumber(Long supplierNumber) {
		this.supplierNumber = supplierNumber;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public List<Commodity> getCommodityList() {
		return commodityList;
	}

	public void setCommodityList(List<Commodity> commodityList) {
		this.commodityList = commodityList;
	}

	@Override
	public String toString() {
		String output=String.format("%-5s %-15s",supplierNumber,supplierName);
		return output;
	}
}