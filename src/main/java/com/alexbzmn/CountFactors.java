package com.alexbzmn;

public class CountFactors {
	public int solution(int N) {
		int numFactors = 0;

		for (int i = 1; i <= Math.sqrt(N); i++) {
			if (N % i == 0) {
				if (i != N / i) {
					numFactors+=2;
				} else {
					numFactors++;
				}

			}
		}

		return numFactors;
	}

}
