package com.alexbzmn;

public class FindDuplicateNumber {

	public int findDuplicate(int[] nums) {
		int hare = 0;
		int tortoise = 0;

		hare = nums[nums[hare]];
		tortoise = nums[tortoise];

		while (hare != tortoise) {
			hare = nums[nums[hare]];
			tortoise = nums[tortoise];
		}

		tortoise = 0;
		while (hare != tortoise) {
			hare = nums[hare];
			tortoise = nums[tortoise];
		}

		return hare;
	}
}

