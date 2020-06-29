package com.alexbzmn;

public class LongestIncreasingSequence {

	public int lengthOfLIS(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}

		int[] m = new int[nums.length];
		int max = 1;

		for (int i = nums.length - 1; i >= 0; i--) {
			int tmp = 0;

			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] > nums[i]) {
					tmp = Math.max(tmp, m[j]);
				}
			}

			m[i] = tmp + 1;
			max = Math.max(max, m[i]);
		}

		return max;
	}

}
