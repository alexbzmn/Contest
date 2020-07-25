package com.alexbzmn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {

	private List<Integer> list;

	private Map<Integer, Integer> map;

	private Random r;

	// check if the element exists, remove, insert, get

	/**
	 * Initialize your data structure here.
	 */
	public RandomizedSet() {
		this.list = new ArrayList<>();
		this.map = new HashMap<>();
		this.r = new Random();
	}

	/**
	 * Inserts a value to the set. Returns true if the set did not already contain the specified element.
	 */
	public boolean insert(int val) {
		if (map.containsKey(val)) {
			return false;
		}

		map.put(val, map.size());
		list.add(val);

		return true;
	}

	/**
	 * Removes a value from the set. Returns true if the set contained the specified element.
	 */
	public boolean remove(int val) {
		if (!map.containsKey(val)) {
			return false;
		}

		int i = map.get(val);
		int swapVal = list.get(list.size() - 1);

		list.set(i, swapVal);
		map.put(swapVal, i);

		list.remove(list.size() - 1);
		map.remove(val);

		return true;
	}

	/**
	 * Get a random element from the set.
	 */
	public int getRandom() {
		return list.get(this.r.nextInt(list.size()));
	}
}
