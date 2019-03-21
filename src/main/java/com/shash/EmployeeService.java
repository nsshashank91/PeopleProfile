package com.shash;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeService {
	
	@Autowired
	EmployeeDao employeeDao;

	public void insertEmployee(Employee employee) {
		employeeDao.save(employee);
	}

	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<>();
		employeeDao.findAll().forEach(employees::add);
		return employees;
	}

	public Optional<Employee> getEmployeeById(int empId) {
		Optional<Employee> employee = employeeDao.findById(empId);
		return employee;
	}
	
	public void deleteEmployee(int empId) {
		employeeDao.deleteById(empId);
	}
}