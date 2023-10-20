package org.anudip.oneToManyBiDirectional.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Commodity implements Comparable<Commodity> {
@Id
@Column(name="commodity_id")
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long commodityId;
@Column(name="commodity_name")
private String commodityName;
private Double price;
private Double quantity;
@ManyToOne(cascade=CascadeType.ALL)
@JoinColumn(name="supplier_number")
private Suppliers supplier;
public Commodity() {
	super();
	
}

public Commodity(String commodityName, Double price, Double quantity, Suppliers supplier) {
	super();
	this.commodityName = commodityName;
	this.price = price;
	this.quantity = quantity;
	this.supplier = supplier;
}

public Long getCommodityId() {
	return commodityId;
}
public void setCommodityId(Long commodityId) {
	this.commodityId = commodityId;
}
public String getCommodityName() {
	return commodityName;
}
public void setCommodityName(String commodityName) {
	this.commodityName = commodityName;
}
public Double getPrice() {
	return price;
}
public void setPrice(Double price) {
	this.price = price;
}
public Double getQuantity() {
	return quantity;
}
public void setQuantity(Double quantity) {
	this.quantity = quantity;
}

public Suppliers getSupplier() {
	return supplier;
}
public void setSupplier(Suppliers supplier) {
	this.supplier = supplier;
}

@Override
public int compareTo(Commodity otherCommodity) {
    // Implement comparison logic here
    // For example, you can compare by a property like 'name'
    return this.getCommodityId().compareTo(otherCommodity.getCommodityId());
}


@Override
public String toString() {
	String output=String.format("%-5s %-15s %-10s %-10s",commodityId,commodityName,price,quantity);
	return output;
}
}