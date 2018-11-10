package com.alexbzmn;

public class MaxProfit {

	public int solution(int[] A) {
		if (A.length == 0) {
			return 0;
		}

		int min = A[0];
		int max = A[0];
		int minIndex = 0;
		int maxIndex = 0;

		int currentProfit = 0;

		for (int i = 1; i < A.length; i++) {
			if (A[i] > max) {
				max = A[i];
				maxIndex = i;
			}

			if (A[i] < min) {
				min = A[i];
				minIndex = i;
			}

			if (minIndex > maxIndex) {
				max = A[i];
				maxIndex = i;
			}

			currentProfit = Math.max(currentProfit, max - min);
		}

		return currentProfit > 0 ? currentProfit : 0;
	}

}
