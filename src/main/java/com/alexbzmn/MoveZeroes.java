package com.alexbzmn;

public class MoveZeroes {
	public void moveZeroes(int[] nums) {

		if (nums.length < 2) {
			return;
		}

		int i = 0;
		int z = 0;
		int n = 0;

		while (i < nums.length) {

			n = Math.max(n, i);

			while (nums[z] != 0 && z < nums.length - 1) {
				z++;
			}

			while (nums[n] == 0 && n < nums.length - 1) {
				n++;
			}

			if (nums[n] != 0 && nums[z] == 0 && n > z) {
				swap(z, n, nums);
			}

			i++;
		}


	}

	private void swap(int a, int b, int[] nums) {
		int buf = nums[a];
		nums[a] = nums[b];
		nums[b] = buf;
	}

}
