package com.alexbzmn;

public class IncreasingTripletSequence {

	public boolean increasingTriplet(int[] nums) {
		int minOne = Integer.MAX_VALUE;
		int minTwo = Integer.MAX_VALUE;

		for (int i = 0; i < nums.length; i++) {
			int val = nums[i];

			if (val < minOne) {
				minOne = val;
			}

			if (val > minOne) {
				minTwo = Math.min(val, minTwo);
			}

			if (val > minTwo) {
				return true;
			}

		}

		return false;
	}

}
