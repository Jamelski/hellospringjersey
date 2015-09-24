package com.eintern.spring.hellospringjersey.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eintern.spring.hellospringjersey.data.entity.Employee;
import com.eintern.spring.hellospringjersey.model.delegate.EmployeeDelegate;

@Controller
@RequestMapping("/user/employee**")
public class EmployeeController {
	
	@Autowired
	private EmployeeDelegate employeeDelegate;
	
	@RequestMapping("/newEmployee")
	public String addEmployee(Model model){	
		return "/lead/addEmployee";
	}
	
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
	@RequestMapping("/submit")
	public String submit(@RequestParam("firstname") String firstname, 
							@RequestParam("lastname") String lastname,
							@RequestParam("email") String email,
							@RequestParam("password") String password,
							@RequestParam("role") String role,
							Model model){
		
		Employee newEmployee = new Employee();
		newEmployee.setFirstname(firstname);
		newEmployee.setLastname(lastname);
		newEmployee.setEmail(email);
		newEmployee.setPassword(password);
		newEmployee.setRole(role);
		
		employeeDelegate.saveEmployee(newEmployee);
		
		return "/lead/employeeAdded";
	}
}
