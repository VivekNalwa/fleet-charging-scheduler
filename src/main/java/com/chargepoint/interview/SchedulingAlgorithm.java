package com.chargepoint.interview;

import java.util.List;
import java.util.Map;

public interface SchedulingAlgorithm {
	
	Map<Integer, List<Integer>> schedule(List<Truck> trucks, List<Charger> chargers, int hours);

}
