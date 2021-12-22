package com.cn.emploexample.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {

	public static final int WORKING_DAYS=260;
	
	private float vacationDaysAccumulated;
	private String id;
	private String nickname;
	
	
	
}
