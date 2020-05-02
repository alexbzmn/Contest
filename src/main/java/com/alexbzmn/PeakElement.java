package com.alexbzmn;

public class PeakElement {

	public static void main(String[] args) {
		System.out.println(new PeakElement().findPeakElement(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }));
	}


	public int findPeakElement(int[] nums) {
		return search(nums, 0, nums.length - 1);
	}

	public int search(int[] nums, int l, int r) {
		if (l == r)
			return l;
		int mid = (l + r) / 2;
		if (nums[mid] > nums[mid + 1])
			return search(nums, l, mid);
		return search(nums, mid + 1, r);
	}


}
