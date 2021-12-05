package com.companyportal.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.companyportal.app.entity.Employee;
import com.companyportal.app.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String displayRegistrationForm(Model model) {
		Employee employee = new Employee();	
		
		model.addAttribute("employee", employee);
		return "employeeform";
		
		//return new ModelAndView("employeeform", "employee", employee);
		 
	}
	
	@RequestMapping(value = "/saveData", method = RequestMethod.POST)
	public String saveEmployeeData(@ModelAttribute Employee employee) {
		employeeService.saveEmployeeData(employee);
		
		return "redirect:/employeelist";
	}
	
	@RequestMapping(value = "/employeelist", method = RequestMethod.GET)
	public String getEmployeesData(Model model) {
		List<Employee> employeeList = employeeService.getAllEmployees();
				
		model.addAttribute("employeeList", employeeList);
		return "employeelist";
	}
	
	@RequestMapping(value = "updateEmployee={employeeId}")
	public String updateEmployee(@PathVariable int employeeId,Model model) {
		Employee employee = employeeService.getEmployee(employeeId);
		System.out.println("employee::in updateEmployee::"+employee.getEmployeeId());
		model.addAttribute("employee",employee);
		return"employeeedit";
	}
	@RequestMapping(value = "/editData")
	public String editEmployeeData(@ModelAttribute("employee") Employee employee) {
		employeeService.editEmployeeData(employee);
		return "redirect:/employeelist";
	}
	@RequestMapping(value = "/deleteEmployee/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		employeeService.deleteEmployee(employeeId);
		return "redirect:/employeelist";
	}
	
	
   	
}
