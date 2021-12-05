package com.companyportal.app.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.companyportal.app.dao.EmployeeDao;
import com.companyportal.app.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{
	
	//private ArrayList<Employee> employeeList = new ArrayList<Employee>();

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	@Override
	public void saveEmployeeData(Employee employee) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Employee> empList = session.createQuery("from Employee").list();
		return empList;
	}
	
	@Override
	public Employee getEmployee(int employeeId) {
		Session session = this.sessionFactory.getCurrentSession();
		Employee employee = (Employee) session.get(Employee.class, new Integer(employeeId));
		return employee;
	}
		
	@Override
	public void deleteEmployee(int employeeId) {
		Session session = this.sessionFactory.getCurrentSession();
		Employee emp = (Employee) session.load(Employee.class, new Integer(employeeId));
		if (null != emp) {
			session.delete(emp);
		}
	}
	
	@Override
	public void editEmployeeData(Employee employee) {
		/*
		 * for(Employee empOld: employeeList) { if(empOld.getEmployeeId() ==
		 * employee.getEmployeeId()) { int empIdIndex = employeeList.indexOf(empOld);
		 * empOld.setEmployeeId(employee.getEmployeeId());
		 * empOld.setName(employee.getName()); empOld.setProject(employee.getProject());
		 * empOld.setMailId(employee.getMailId());
		 * empOld.setPhoneNo(employee.getPhoneNo());
		 * 
		 * employeeList.set(empIdIndex, empOld); } }
		 */
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(employee);
	}

}
