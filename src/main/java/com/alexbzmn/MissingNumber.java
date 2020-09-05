package com.alexbzmn;

public class MissingNumber {

	public static void main(String[] args) {
		//		System.out.println(new MissingNumber().missingNumber(new int[] {9,6,4,2,3,5,7,0,1}));
		//		System.out.println(new MissingNumber().missingNumber(new int[] {0, 3, 2}));
		//		System.out.println(new MissingNumber().missingNumber(new int[] {1, 2, 3, 4}));
		System.out.println(new MissingNumber().missingNumber(new int[] {
			45,
			35,
			38,
			13,
			12,
			23,
			48,
			15,
			44,
			21,
			43,
			26,
			6,
			37,
			1,
			19,
			22,
			3,
			11,
			32,
			4,
			16,
			28,
			49,
			29,
			36,
			33,
			8,
			9,
			39,
			46,
			17,
			41,
			7,
			2,
			5,
			27,
			20,
			40,
			34,
			30,
			25,
			47,
			0,
			31,
			42,
			24,
			10,
			14 }));
	}

	public int missingNumber2(int[] nums) {

		int n = nums.length;

		for (int i = 0; i < nums.length; i++) {
			n ^= (i ^ nums[i]);
		}

		return n;
	}

	public int missingNumber(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			int targetIndex = nums[i] == nums.length ? nums[i] - 1 : nums[i];
			swap(nums, i, targetIndex);
		}

		for (int i = 0; i < nums.length; i++) {
			int targetIndex = nums[i] == nums.length ? nums[i] - 1 : nums[i];
			swap(nums, i, targetIndex);
		}

		if (nums[0] != 0) {
			return 0;
		}

		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i + 1] != nums[i] + 1) {
				return nums[i] + 1;
			}
		}

		return nums[nums.length - 1] + 1;
	}

	private void swap(int[] nums, int a, int b) {
		int buf = nums[a];
		nums[a] = nums[b];
		nums[b] = buf;
	}

}
