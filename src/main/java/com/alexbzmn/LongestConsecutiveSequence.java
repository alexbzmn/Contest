package com.alexbzmn;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {

	public int longestConsecutive(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], 0);
		}

		for (int i = 0; i < nums.length; i++) {
			int c = map.get(nums[i]);
			if (c == 0) {
				fillLength(map, nums[i]);
			}
		}

		int maxC = 0;
		for (Integer c : map.values()) {
			maxC = Math.max(maxC, c);
		}

		return maxC;
	}

	private void fillLength(Map<Integer, Integer> map, int index) {
		map.put(index, 1);
		int indexPos = index + 1;
		int cumLength = 1;

		while (map.containsKey(indexPos)) {
			cumLength = map.get(indexPos - 1) + 1;
			map.put(indexPos, cumLength);
			indexPos++;
		}

		map.put(index, cumLength);
		int indexNeg = index - 1;
		while (map.containsKey(indexNeg)) {
			map.put(indexNeg, map.get(indexNeg + 1) + 1);
			indexNeg--;
		}
	}

}
