package com.alexbzmn;

public class TapeEquilibrium {

	public int solution(int[] A) {
		int sum = 0;

		for (int i = 0; i < A.length; i++) {
			sum += A[i];
		}

		int min = Integer.MAX_VALUE;
		int cumSum = 0;

		for (int i = 0; i < A.length; i++) {
			cumSum += A[i];
			min = Math.min(min, Math.abs(A[i] - (sum - cumSum)));
		}

		return min;
	}

}
