package com.alexbzmn;

import java.util.*;

public class UndergroundSystem {


	private Map<Integer, CheckIn> checkins = new HashMap<>();
	private Map<String, Stats> stats = new HashMap<>();

	public UndergroundSystem() {

	}

	public void checkIn(int id, String stationName, int t) {
		checkins.put(id, new CheckIn(stationName, t));
	}

	public void checkOut(int id, String stationName, int t) {
		CheckIn checkIn = checkins.get(id);
		String stationPair = checkIn.station + stationName;
		Stats st = stats.get(stationPair);
		int duration = t - checkIn.time;

		if (st == null) {
			stats.put(stationPair, new Stats(1, duration, duration));
		} else {
			int updatedSum = st.sum + duration;
			int updatedCount = st.count + 1;
			stats.put(stationPair, new Stats(updatedCount, updatedSum, ((double) updatedSum) / updatedCount));
		}

	}

	public double getAverageTime(String startStation, String endStation) {
		return stats.get(startStation + endStation).avg;
	}

	private static class CheckIn {
		private String station;
		private int time;

		private CheckIn(String station, int time) {
			this.station = station;
			this.time = time;
		}
	}

	private static class Stats {
		int count;
		int sum;
		double avg;

		private Stats(int count, int sum, double avg) {
			this.count = count;
			this.sum = sum;
			this.avg = avg;
		}

	}
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
