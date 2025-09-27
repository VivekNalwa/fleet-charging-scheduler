package com.chargepoint.interview;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class GreedyChargingAlgorithmTest {
	
	
	@Test
	public void testMultipleTrucksMultipleChargers() {
		List<Truck> trucks = Arrays.asList(
				new Truck(1, 100, 60),
				new Truck(2, 120, 80),
				new Truck(3, 90, 70),
				new Truck(4, 110, 90));
		
		List<Charger> chargers = Arrays.asList(
				new Charger(1, 40),
				new Charger(2, 30));
		
		int hours = 2;
		
		GreedyChargingAlgorithm algo = new GreedyChargingAlgorithm();
		Map<Integer, List<Integer>> schedule = algo.schedule(trucks, chargers, hours);
		
		assertEquals(2, schedule.size());
		assertTrue(schedule.get(1).contains(1));
		assertTrue(schedule.get(1).contains(3) || schedule.get(1).contains(4));
		assertTrue(schedule.get(2).contains(2));
	}
	
	
	@Test
	public void testNoTrucks() {
		List<Truck> trucks = Collections.emptyList();
		List<Charger> chargers = List.of(new Charger(1, 50));
		int hours = 1;

		GreedyChargingAlgorithm algo = new GreedyChargingAlgorithm();
		Map<Integer, List<Integer>> schedule = algo.schedule(trucks, chargers, hours);

		assertTrue(schedule.isEmpty());
	}

}
