package com.eintern.spring.hellospringjersey.data.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eintern.spring.hellospringjersey.data.entity.Employee;


@Repository
public interface EmployeeCrudRepository extends CrudRepository<Employee, Long> {
	List<Employee> findById(Employee employee);
}
