package com.alexbzmn;

import java.util.HashMap;
import java.util.Map;

public class MaximumProductSubArray {

	public int maxProductMemo(int[] nums) {
		Map<Integer, Integer> m = new HashMap<>();
		return product(0, nums, m);
	}

	private int product(int k, int[] nums, Map<Integer, Integer> m) {

		if (m.containsKey(k)) {
			return m.get(k);
		}

		int p = nums[k];
		int res = p;

		for (int i = k + 1; i < nums.length; i++) {
			p *= nums[i];
			if (p > res) {
				res = p;
			}

			int t = product(i, nums, m);
			if (t > res) {
				res = t;
			}
		}

		m.put(k, res);
		return res;
	}
	public int maxProduct(int[] nums) {

		int res = nums[0];
		int[] max = new int[nums.length];
		int[] min = new int[nums.length];

		max[0] = nums[0];
		min[0] = nums[0];

		for (int i = 1; i < nums.length; i++) {

			if (nums[i] > 0) {
				max[i] = Math.max(nums[i], max[i - 1] * nums[i]);
				min[i] = Math.min(nums[i], min[i - 1] * nums[i]);
			} else {
				max[i] = Math.max(nums[i], min[i - 1] * nums[i]);
				min[i] = Math.min(nums[i], max[i - 1] * nums[i]);
			}

			if (max[i] > res) {
				res = max[i];
			}
		}

		return res;
	}

}
