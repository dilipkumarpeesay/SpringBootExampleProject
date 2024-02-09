package com.example.spring.boot.docker.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.boot.docker.demo.entity.Employee;
import com.example.spring.boot.docker.demo.repository.EmployeeRepository;

@RestController
public class EmployeeController {
	
	
	@Autowired
	public EmployeeRepository employeeRepository;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee employee) {
		Employee saveEmployee = employeeRepository.save(employee);
        return new ResponseEntity<>("Employee "+saveEmployee.getName()+" Saved successfully with ID "+saveEmployee.getId(), HttpStatus.CREATED);
		
	}
	
	@GetMapping("/fetchAll")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		return ResponseEntity.ok(employeeRepository.findAll());
	}

}
