package com.chargepoint.interview;

public class Truck {
	
	private int id;
	
	private double batteryCapacity;
	
	private double currentCharge;
	
	private FleetStatus status;
	
	public Truck(int id, double batteryCapacity, double currentCharge) {
		this.id = id;
		this.batteryCapacity = batteryCapacity;
		this.currentCharge = currentCharge;
	}
	
	public double requiredKWh() {
		return batteryCapacity - currentCharge;
	}
	
	public int getId() {
		return this.id;
	}

}
