package com.alexbzmn;

public class ProductArrayExceptSelf {

	public int[] productExceptSelf(int[] nums) {
		int[] o = new int[nums.length];

		if (nums.length < 2) {
			return nums;
		}

		o[o.length - 1] = nums[nums.length - 1];

		for (int i = nums.length - 2; i > 0; i--) {
			o[i] = nums[i] * o[i + 1];
		}

		int p = 1;
		for (int i = 0; i < o.length; i++) {
			if (i - 1 >= 0) {
				p = p * nums[i - 1];
			}

			if (i + 1 == o.length) {
				o[i] = p;
			} else {
				o[i] = o[i + 1] * p;
			}

		}

		return o;
	}
}
