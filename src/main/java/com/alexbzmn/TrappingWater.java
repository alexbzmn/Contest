package com.alexbzmn;

import java.util.Stack;

public class TrappingWater {

	public static void main(String[] args) {
		System.out.println(new TrappingWater().trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
	}

	public int trap(int[] height) {

		int waterUnits = 0;

		if (height.length < 3) {
			return waterUnits;
		}

		int left = 0;
		int right = height.length - 1;
		int leftMax = left;
		int rightMax = right;

		while (left != right) {

			if (height[left] <= height[right]) {

				if (height[leftMax] <= height[left]) {
					leftMax = left;
				} else {
					waterUnits += height[leftMax] - height[left];
				}

				left++;

			} else if (height[right] < height[left]) {

				if (height[rightMax] <= height[right]) {
					rightMax = right;
				} else {
					waterUnits += height[rightMax] - height[right];
				}

				right--;
			}

		}

		return waterUnits;

	}
}
