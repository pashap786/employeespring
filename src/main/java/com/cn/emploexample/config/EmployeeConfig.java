package com.cn.emploexample.config;

import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Configuration;

import com.cn.emploexample.model.Hourly;
import com.cn.emploexample.model.Manager;
import com.cn.emploexample.model.MyWorkerHolder;
import com.cn.emploexample.model.NonManager;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class EmployeeConfig {

	@PostConstruct
	public void setEmployee() {
		System.out.println("asdf");
		log.info("setting employees ");
		// 10 hourly
		for (int x = 0; x < 10; x++) {
			Hourly h = new Hourly();
			h.setId(UUID.randomUUID().toString());
			h.setVacationDaysAccumulated(0);
			h.setNickname("bill" + UUID.randomUUID().toString().replace("-", ""));

			MyWorkerHolder.workers.put(h.getId(), h);
		}
		log.info("hourly add  map size = {}", MyWorkerHolder.workers.size());
		//10 non managers
		for (int x = 0; x < 10; x++) {
			NonManager h = new NonManager();
			h.setId(UUID.randomUUID().toString());
			h.setVacationDaysAccumulated(0);
			h.setNickname("bill" + UUID.randomUUID().toString().replace("-", ""));

			MyWorkerHolder.workers.put(h.getId(), h);
		}
		log.info("non managers add  map size = {}", MyWorkerHolder.workers.size());
		//10 managers
		for (int x = 0; x < 10; x++) {
			Manager h = new Manager();
			h.setId(UUID.randomUUID().toString());
			h.setVacationDaysAccumulated(0);
			h.setNickname("bill" + UUID.randomUUID().toString().replace("-", ""));

			MyWorkerHolder.workers.put(h.getId(), h);
		}
		log.info(" managers add  map size = {}", MyWorkerHolder.workers.size());
		
	}

}
