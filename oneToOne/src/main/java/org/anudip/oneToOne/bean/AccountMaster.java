package org.anudip.oneToOne.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="account_master")
public class AccountMaster {
	@Id
	@Column(name="employee_id")
	private Integer employeeId;
	
	@Column(name="user_id")
	private String userId;
	
	private String password;
	private String email;
	public AccountMaster() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AccountMaster(Integer employeeId, String userId, String password, String email) {
		super();
		this.employeeId = employeeId;
		this.userId = userId;
		this.password = password;
		this.email = email;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		String output=String.format("%-10s %-15s %-10s",userId,password,email);
		return output;
	}
}
