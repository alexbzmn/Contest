package com.alexbzmn;

import java.util.concurrent.ThreadLocalRandom;

public class NextPermutation {

	public void nextPermutation(int[] nums) {

		if (nums.length == 1) {
			return;
		}

		for (int i = nums.length - 1; i > 0; i--) {
			if (nums[i] > nums[i - 1]) {
				int min = minIndex(i - 1, i, nums);
				swap(i - 1, min, nums);

				reverse(i, nums);
				return;
			}

		}

		quickSort(nums, 0, nums.length - 1);
	}

	private void reverse(int i, int[] nums) {
		int len = nums.length - i;

		if (len < 2) {
			return;
		}

		int mid = (len & 1) == 1 ? len / 2 : (len / 2) - 1;
		mid = mid + i;

		int k = 0;
		for (int j = i; j <= mid; j++) {
			int right = nums.length - 1 - k;
			swap(j, right, nums);
			k++;
		}

	}

	private int minIndex(int l, int i, int[] nums) {
		int left = nums[l];

		int j = i;
		int minIndex = j;

		while (j < nums.length) {
			if (nums[j] > left) {
				minIndex = j;
				j++;
			} else {
				return minIndex;
			}
		}

		return minIndex;
	}

	private void swap(int a, int b, int[] nums) {
		int buf = nums[a];
		nums[a] = nums[b];
		nums[b] = buf;
	}

	private void quickSort(int[] nums, int low, int high) {
		if (low >= high) {
			return;
		}

		int p = partition(nums, low, high);
		quickSort(nums, low, p - 1);
		quickSort(nums, p + 1, high);
	}

	private int partition(int[] nums, int low, int high) {
		if (low >= high) {
			return low;
		}

		int p = ThreadLocalRandom.current().nextInt(low, high + 1);
		int pVal = nums[p];
		swap(p, high, nums);

		int start = low;
		int i = low;

		while (i < high) {
			if (nums[i] < pVal) {
				swap(i, start, nums);
				start++;
			}

			i++;
		}

		swap(high, start, nums);
		return start;
	}
}
