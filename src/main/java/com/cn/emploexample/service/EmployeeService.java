package com.cn.emploexample.service;

import org.springframework.stereotype.Service;

import com.cn.emploexample.model.Employee;
import com.cn.emploexample.model.Hourly;
import com.cn.emploexample.model.Manager;
import com.cn.emploexample.model.MyWorkerHolder;
import com.cn.emploexample.model.NonManager;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmployeeService {

	public Employee updateHoursWorked(Employee employee, int worked) {
		log.info("updateHoursWorked employee id={} worked={}", employee.getId(), worked);
		Object e = MyWorkerHolder.workers.get(employee.getId());
		
		if(e instanceof Hourly) {
			Hourly h = (Hourly) e;
			h.work(worked);
			return h;
		}
		
		if(e instanceof NonManager) {
			NonManager n = (NonManager) e;
			n.work(worked);
			return n;
		}
		
		if(e instanceof Manager) {
			Manager m = (Manager) e;
			m.work(worked);
			return m;
		}
		
		return (Employee) e;
		
	}
	
	public Employee updateVacationTaken(Employee employee, float vacation) {
		
		log.info("updateHoursWorked employee id={} vacati on={}", employee.getId(), vacation);
		//g
		Object e = MyWorkerHolder.workers.get(employee.getId());
		
		if(e instanceof Hourly) {
			Hourly h = (Hourly) e;
			h.setVacationDaysAccumulated(vacation);
			return h;
		}
		
		if(e instanceof NonManager) {
			NonManager n = (NonManager) e;
			n.setVacationDaysAccumulated(vacation);
			return n;
		}
		
		if(e instanceof Manager) {
			Manager m = (Manager) e;
			m.setVacationDaysAccumulated(vacation);
			return m;
		}
		
		return (Employee) e;
		
	}
	
}
