package com.alexbzmn;

import java.util.Arrays;

public class WiggleSort2 {

	public static void main(String[] args) {
		//		int[] a = new int[] { 1, 5, 1, 1, 6, 4 };
		//		new WiggleSort().wiggleSort(a);
		//		System.out.println(Arrays.toString(a));

		int[] a = new int[] { 1, 3, 2, 2, 3, 1 };
		//		int[] a = new int[] { 13, 6, 5, 5, 4, 2 };
		new WiggleSort2().wiggleSort(a);
		System.out.println(Arrays.toString(a));
		//
		//		System.out.println(new WiggleSort().findKthLargest(new int[] { 3, 2, 1, 5, 6, 4 }, 2));
		//		System.out.println(new WiggleSort().findKthLargest(new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 }, 4));
		//		System.out.println(new WiggleSort().findKthLargest(new int[] { -1, 3, 4, 3, 5, 2, -1, -1, 1, 2, 1, 2, 1, 1, 3, 1, 2, 1, 4, 3, 3, 3, 3 }, 2));
	}

	public int findKthLargest(int[] nums, int k) {
		return findKth(k - 1, 0, nums.length - 1, nums);
	}

	public void wiggleSort(int[] nums) {
		if (nums.length < 2) {
			return;
		}

		if (nums.length == 2 && nums[0] > nums[1]) {
			swap(0, 1, nums);
		}

		int median = nums.length / 2;
		int medianVal = findKthLargest(nums, median);
		int n = nums.length;

		int left = 0;
		int right = n - 1;
		int i = 0;

		while (i <= right) {
			if (nums[index(i, n)] > medianVal) {
				swap(index(i, n), index(left, n), nums);
				left++;
				i++;
			} else if (nums[index(i, n)] < medianVal) {
				swap(index(i, n), index(right, n), nums);
				right--;
			} else {
				i++;
			}
		}
	}

	private int index(int i, int n) {
		return (1 + i * 2) % (n | 1);
	}

	private int findKth(int k, int low, int high, int[] nums) {
		int p = partition(low, high, nums);
		if (p == k) {
			return nums[p];
		} else if (p < k) {
			return findKth(k, p + 1, high, nums);
		} else {
			return findKth(k, low, p - 1, nums);
		}

	}

	private int partition(int low, int high, int[] nums) {
		if (low == high) {
			return low;
		}

		int pivot = (low + high) / 2;
		int pivotVal = nums[pivot];

		swap(pivot, high, nums);

		int leftIndex = low;
		int i = low;

		while (i < high) {
			if (nums[i] > pivotVal) {
				swap(i, leftIndex, nums);
				leftIndex++;
			}

			i++;
		}

		swap(leftIndex, high, nums);

		return leftIndex;
	}

	private void swap(int a, int b, int[] nums) {
		int buf = nums[a];
		nums[a] = nums[b];
		nums[b] = buf;
	}
}
