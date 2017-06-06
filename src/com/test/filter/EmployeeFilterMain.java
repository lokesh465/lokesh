package com.test.filter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeFilterMain {

	public static void main(String[] args) {
		List<Employee>employees = new ArrayList<>();
		List<Employee>filterdEmployees = new ArrayList<>();
		employees.add(new Employee("t1", new Date()));
		Calendar cal = Calendar.getInstance();
		cal.set(2016, 11, 17);
		employees.add(new Employee("t2", cal.getTime()));
		cal.set(2016, 10, 15);
		employees.add(new Employee("t3", cal.getTime()));
		Calendar cal1 = Calendar.getInstance();
		cal1.set(2016, 11, 15);
		Filter<Employee> filter = new EmployeeDateRangeFilter(cal1.getTime(),new Date());
		for (Employee employee : employees) {
			if(filter.test(employee)){
				filterdEmployees.add(employee);
			}
		}
		System.out.println(filterdEmployees);
		
		//java 8 more performant because of parallel streams
		filterdEmployees = employees.parallelStream().filter((emp) -> emp.getJoinedDate().before(new Date()) && emp.getJoinedDate().after(cal1.getTime())).collect(Collectors.toList());
		System.out.println(filterdEmployees);
	}

}
