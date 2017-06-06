package com.test.filter;

import java.util.Date;

public class EmployeeDateRangeFilter implements Filter<Employee> {
	private Date startDate, endDate;
	
	
	public EmployeeDateRangeFilter(Date startDate, Date endDate) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
	}

	@Override
	public boolean test(Employee t) {
		return t.getJoinedDate().before(endDate) && t.getJoinedDate().after(startDate);
	}


}
