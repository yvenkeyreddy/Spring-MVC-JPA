package com.enhancesys.ws;

public class EmployeeImpl {

	private int _id;
	private String name;
	private int salary;

	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [_id=" + _id + ", name=" + name + ", salary=" + salary + "]";
	}

}
