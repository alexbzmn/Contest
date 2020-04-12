package com.alexbzmn;

public class SingleNumber {

	public static void main(String[] args) {
//		System.out.println(new SingleNumber().singleNumber(new int[] { 4, 1, 2, 1, 2 }));
		System.out.println(new SingleNumber().singleNumber(new int[] { 1, 3, 1, -1, 3 }));
	}

	public int singleNumber(int[] nums) {
		int x = 0;
		int y = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] >= 0) {
				if ((nums[i] & x) == nums[i]) {
					x = (nums[i] ^ x);
				} else {
					x = (nums[i] | x);
				}
			} else {
				if ((nums[i] & y) == nums[i]) {
					y = (nums[i] ^ y);
				} else {
					y = (nums[i] | y);
				}
			}

		}

		return x != 0 ? x : y;
	}
}
