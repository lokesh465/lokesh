package com.test.filter;

import java.util.Date;

public class Employee {

	private String name;
	private Date joinedDate;
	
	public Employee(String name, Date joinedDate) {
		super();
		this.name = name;
		this.joinedDate = joinedDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getJoinedDate() {
		return joinedDate;
	}

	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", joinedDate=" + joinedDate + "]";
	}

}
