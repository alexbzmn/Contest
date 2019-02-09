package com.alexbzmn;

public class TapeEquilibrium {

	public static int solution(int[] A) {
		int sum = 0;

		if (A.length == 2) {
			return Math.abs(A[0] - A[1]);
		}

		for (int i = 0; i < A.length; i++) {
			sum += A[i];
		}

		int min = Integer.MAX_VALUE;
		int cumSum = 0;

		for (int i = 0; i < A.length; i++) {
			if (i == A.length - 1) {
				min = Math.min(min, Math.abs(A[i] - cumSum));
			} else {
				cumSum += A[i];
				min = Math.min(min, Math.abs(cumSum - (sum - cumSum)));
			}
		}

		return min;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] { -10, -20, -30, -40, 100 }));
	}

}
