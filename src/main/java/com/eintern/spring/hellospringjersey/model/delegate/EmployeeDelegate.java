package com.eintern.spring.hellospringjersey.model.delegate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eintern.spring.hellospringjersey.data.dao.EmployeeCrudRepository;
import com.eintern.spring.hellospringjersey.data.entity.Employee;

@Component
public class EmployeeDelegate {
	@Autowired
	EmployeeCrudRepository employeeCrud;
	
	public void saveEmployee(Employee employee){
		employeeCrud.save(employee);
	}
}
