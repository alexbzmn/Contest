package com.alexbzmn;

public class ChocolatesByNumbers {

	public int solution(int N, int M) {
		int lcd = gcd(N, M);
		return N / lcd;
	}

	private int gcd(int a, int b) {
		if (a % b == 0) {
			return b;
		} else {
			return gcd(b, a % b);
		}
	}
}
