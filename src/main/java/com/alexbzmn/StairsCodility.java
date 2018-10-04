package com.alexbzmn;

public class StairsCodility {

	public int[] solution(int[] A, int[] B) {
		int[] result = new int[A.length];

		for (int i = 0; i < A.length; i++) {
			result[i] = calculateWays(A[i]) % (int)Math.pow(2, B[i]);
		}

		return result;
	}

	private int calculateWays(int n) {

		if (n == 0) {
			return 1;
		}

		if (n == 1) {
			return 1;
		}

		if (n == 2) {
			return 2;
		}

		if (n >= 3) {
			return calculateWays(n - 1) + calculateWays(n - 2);
		}

		return 0;
	}

}
