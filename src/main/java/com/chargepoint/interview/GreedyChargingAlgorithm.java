package com.chargepoint.interview;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

// Prioritize trucks needing lest charging first
public class GreedyChargingAlgorithm implements SchedulingAlgorithm{

	@Override
	public Map<Integer, List<Integer>> schedule(List<Truck> trucks, List<Charger> chargers, int hours) {
		
		// sorted list of trucks based on required charging
		trucks.sort(Comparator.comparingDouble(Truck::requiredKWh));
		
		//Map to store the schedule, charger id mapped to list of trucks it will charge for a given time slot
		Map<Integer, List<Integer>> schedule = new HashMap<>();
		
		//Priority Queue which gives the charger Slot available at first
		PriorityQueue<ChargerSlot> chargerSlots = new PriorityQueue<>(Comparator.comparingDouble(cs -> cs.availableAt));
		
		
		for(Charger c: chargers) {
			chargerSlots.offer(new ChargerSlot(c.getId(), c.getRate(), 0));
		}
		
		// Assigning trucks to charging slots
		for(Truck t : trucks) {
			ChargerSlot slot = chargerSlots.poll();
			
			double chargeTime = t.requiredKWh()/slot.rate;  // time needed in hours for a truck to charge
			
			if(slot.availableAt + chargeTime <= hours) {
				if(!schedule.containsKey(slot.id)) {
					schedule.put(slot.id, new ArrayList<>());
				}
				schedule.get(slot.id).add(t.getId());
				slot.availableAt += chargeTime;   // next available charger slot time
			}
			chargerSlots.offer(slot);
			
		}
		
		return schedule;
		
	}
	
	
	private static class ChargerSlot{
		int id;
		double rate;
		double availableAt; //hour
		
		ChargerSlot(int id, double rate, double availableAt){
			this.id = id;
			this.rate = rate;
			this.availableAt = availableAt;
		}
	}

}
