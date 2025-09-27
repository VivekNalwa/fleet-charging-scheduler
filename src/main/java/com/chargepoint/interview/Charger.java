package com.chargepoint.interview;

public class Charger {
	
	private int id;
	private double rate;
	
	public Charger(int id, double rate) {
		this.id = id;
		this.rate = rate;
	}
	
	public int getId() {
		return this.id;
	}
	
	public double getRate() {
		return this.rate;
	}

}
