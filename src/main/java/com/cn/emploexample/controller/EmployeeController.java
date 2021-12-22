package com.cn.emploexample.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cn.emploexample.model.Employee;
import com.cn.emploexample.model.MyWorkerHolder;
import com.cn.emploexample.service.EmployeeService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class EmployeeController {

	private final EmployeeService employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/")
	public HashMap<String, Object> getEmployees() {
		return MyWorkerHolder.workers;
	}
	
	@PutMapping("/workdays")
	public Employee updateDaysWorked(@RequestBody Employee employee, @RequestParam("worked") int worked) {
		return employeeService.updateHoursWorked(employee, worked);
	}

	@PutMapping("/vacation")
	public Employee updateVacationTaken(@RequestBody Employee employee, @RequestParam("vacation") float vacation) {
		return employeeService.updateVacationTaken(employee, vacation);
	}
	
}
