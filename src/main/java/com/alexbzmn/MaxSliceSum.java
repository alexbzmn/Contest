package com.alexbzmn;

public class MaxSliceSum {

	public int solution(int[] A) {
		int maxEndingHere = A[0];
		int maxOverall = A[0];

		for (int i = 1; i < A.length; i++) {
			maxEndingHere = Math.max(A[i], A[i] + maxEndingHere);
			maxOverall = Math.max(maxEndingHere, maxOverall);
		}

		return maxOverall;
	}

}
