package com.companyportal.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.companyportal.app.dao.EmployeeDao;
import com.companyportal.app.entity.Employee;
import com.companyportal.app.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private static int count;
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	@Transactional
	public void saveEmployeeData(Employee employee) {
		employee.setEmployeeId(count++);
		
		employeeDao.saveEmployeeData(employee);
	}

	@Override
	@Transactional
	public List<Employee> getAllEmployees() {
		
		return employeeDao.getAllEmployees();
	}
	
	@Override
	@Transactional
	public Employee getEmployee(int employeeId) {
		return employeeDao.getEmployee(employeeId);
	}
	
	@Override
	@Transactional
	public void deleteEmployee(int employeeId) {
		employeeDao.deleteEmployee(employeeId);
	
	}
	
	@Override
	@Transactional
	public void editEmployeeData(Employee employee) {
		employeeDao.editEmployeeData(employee);
	}
	

}
