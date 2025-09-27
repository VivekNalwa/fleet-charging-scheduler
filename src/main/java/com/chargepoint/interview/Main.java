package com.chargepoint.interview;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		
		int hours = 5;
		
		List<Truck> trucks = Arrays.asList(
				new Truck(1, 100, 60),
				new Truck(2, 120, 80),
				new Truck(3, 90, 70),
				new Truck(4, 110, 90),
				new Truck(5, 150, 50),
				new Truck(6, 80, 30));
		
		List<Charger> chargers = Arrays.asList(
				new Charger(1, 40),
				new Charger(2, 30),
				new Charger(3, 20));
		
		SchedulingAlgorithm algo = new GreedyChargingAlgorithm();
		Map<Integer, List<Integer>> result = algo.schedule(trucks, chargers, hours);
		
		for(Map.Entry<Integer, List<Integer>> entry : result.entrySet()) {
			System.out.print(entry.getKey() + ": ");
			for(int truckId : entry.getValue()) {
				System.out.print(truckId + " ");
			}
			System.out.println();
		}	
		
	}

}
