package org.anudip.oneToOne.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity 
@Table(name="employee_master")
public class EmployeeMaster {
	@Id
	@Column(name="employee_id")
	private Integer employeeId;
	
	@Column(name="employee_name")
	private String employeeName;
	
	@Column(name="employee_salary")
	private Double employeeSalary;
	
	@Column(name="department_name")
	private String departmentName;
	
	@OneToOne(fetch=FetchType.LAZY, targetEntity=AccountMaster.class,cascade=CascadeType.ALL)
	@JoinColumn(name="employee_id")
	private AccountMaster employeeAccount;

	public EmployeeMaster() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeMaster(Integer employeeId, String employeeName, Double employeeSalary, String departmentName,
			AccountMaster employeeAccount) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeSalary = employeeSalary;
		this.departmentName = departmentName;
		this.employeeAccount = employeeAccount;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Double getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(Double employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public AccountMaster getEmployeeAccount() {
		return employeeAccount;
	}

	public void setEmployeeAccount(AccountMaster employeeAccount) {
		this.employeeAccount = employeeAccount;
	}
	
	@Override
	public String toString() {
		String output=String.format("%-10s %-15s %-10s %-15s %-2s",employeeId,employeeName,employeeSalary,departmentName,employeeAccount);
		return output;
	}
}
