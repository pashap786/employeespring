package com.cn.emploexample.model;

public class NonManager extends Salaried {
	
	private final float MAX_VACATION = 15.0f;
	
	public void work(int daysWorked) {
		if(daysWorked < 0 || daysWorked > WORKING_DAYS) {
			return;
		}
		if(daysWorked == 0) {
			return;
		}
		float daysAccumulated = WORKING_DAYS/daysWorked;
		if(daysAccumulated<MAX_VACATION) {
			this.setVacationDaysAccumulated(daysAccumulated);
		}
	}
	
	public void takeVaction(float dayOff) {
		
		float result = this.getVacationDaysAccumulated()-dayOff;
		
		if(result<0) {
			return;
		}
		
		this.setVacationDaysAccumulated(result);
	}
	

}
