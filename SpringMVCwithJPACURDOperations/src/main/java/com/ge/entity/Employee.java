package com.ge.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "EMPLOYEE_TABLE", schema = "JDBC")
@NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e")
public class Employee {

	@Id
	@NotNull(message = "{employeeNumber.required}")
	private Integer employeeNumber;
	@NotEmpty(message = "{employeeName.required}")
	private String employeeName;
	@NotNull(message = "{employeePhoneNumber.required}")
	private Integer employeePhoneNumber;
	@NotEmpty(message = "{employeeMail.required}")
	private String employeeMail;
	@NotNull(message = "{employeeSalary.required}")
	private Integer employeeSalary;
	@NotEmpty(message = "{employeeLocation.required}")
	private String employeeLocation;

	// Logger logger = null;

	public Employee() {
		// logger = LoggerUtility.getLogger();
		// logger.info("Employee class object created");
	}

	public Integer getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(Integer employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Integer getEmployeePhoneNumber() {
		return employeePhoneNumber;
	}

	public void setEmployeePhoneNumber(Integer employeePhoneNumber) {
		this.employeePhoneNumber = employeePhoneNumber;
	}

	public String getEmployeeMail() {
		return employeeMail;
	}

	public void setEmployeeMail(String employeeMail) {
		this.employeeMail = employeeMail;
	}

	public Integer getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(Integer employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

	public String getEmployeeLocation() {
		return employeeLocation;
	}

	public void setEmployeeLocation(String employeeLocation) {
		this.employeeLocation = employeeLocation;
	}

}
