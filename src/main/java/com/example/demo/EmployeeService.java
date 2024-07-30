package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	@Autowired
	 private EmployeeRepository employeeRepository;
	
	
	public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee employeeDetails) {
    	Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    	employee.setFirstName(employeeDetails.getFirstName());
    	employee.setLastName(employeeDetails.getLastName());
    	employee.setEmail(employeeDetails.getEmail());
    	employee.setDob(employeeDetails.getDob());
    	employee.setPhoneNumber(employeeDetails.getPhoneNumber());
    	
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
    	employeeRepository.deleteById(id);
    }
}
