package com.cdac.oralcaremanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="counters")
public class Counters {
	
	@Id
	private String counterId;
	private  int nextValue;
	private  String intitialValue;
	
	public Counters() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Counters(String counterId, int nextValue, String intitialValue) {
		super();
		this.counterId = counterId;
		this.nextValue = nextValue;
		this.intitialValue = intitialValue;
	}
	
	@Id
	public String getCounterId() {
		return counterId;
	}
	
	public void setCounterId(String counterId) {
		this.counterId = counterId;
	}
	
	public int getNextValue() {
		return nextValue;
	}
	
	public void setNextValue(int nextValue) {
		this.nextValue = nextValue;
	}
	
	public String getIntitialValue() {
		return intitialValue;
	}
	
	public void setIntitialValue(String intitialValue) {
		this.intitialValue = intitialValue;
	}
	
	@Override
	public String toString() {
		return "Counters [counterId=" + counterId + ", nextValue=" + nextValue + ", intitialValue=" + intitialValue
				+ "]";
	}
	
	
	public int nextValue() {
		return ++nextValue;
	}
	

}