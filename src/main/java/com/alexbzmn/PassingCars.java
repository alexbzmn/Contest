package com.alexbzmn;

public class PassingCars {

	public int solution(int[] A) {
		long count = 0;
		int coefficient = 0;

		int direction = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] != direction) {
				count += coefficient;
			} else {
				coefficient++;
			}
		}

		return count > 1_000_000_000 ? -1 : (int)count;
	}
}
