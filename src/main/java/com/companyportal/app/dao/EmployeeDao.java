package com.companyportal.app.dao;

import java.util.List;

import com.companyportal.app.entity.Employee;

public interface EmployeeDao {

	void saveEmployeeData(Employee employee);

	List<Employee> getAllEmployees();

	void editEmployeeData(Employee employee);

	void deleteEmployee(int employeeId);

	Employee getEmployee(int employeeId);

	

}
