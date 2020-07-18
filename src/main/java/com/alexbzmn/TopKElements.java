package com.alexbzmn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKElements {

	public static void main(String[] args) {
		int[] res = new TopKElements().topKFrequent(new int[] { 3, -3, -4, 3, 7 }, 2);

		System.out.println(Arrays.toString(res));
	}

	public int[] topKFrequent(int[] nums, int k) {

		if (k == nums.length) {
			return nums;
		}

		Map<Integer, Integer> m = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			m.put(nums[i], m.getOrDefault(nums[i], 0) + 1);
		}

		Queue<Integer> q = new PriorityQueue<>(
			(a, b) -> -m.get(a).compareTo(m.get(b)));

		for (Integer x : m.keySet()) {
			q.add(x);
		}

		int[] res = new int[k];
		for (int i = 0; i < k; i++) {
			res[i] = q.poll();
		}

		return res;
	}

}
