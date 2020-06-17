package com.alexbzmn;

public class PerfectSquares {

	public static void main(String[] args) {
		System.out.println(new PerfectSquares().numSquares(12));
		System.out.println(new PerfectSquares().numSquares(13));
		System.out.println(new PerfectSquares().numSquares(22));
	}

	public int numSquares(int n) {
		int[] a = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			a[i] = Integer.MAX_VALUE;
		}

		int max = (int)Math.sqrt(n);

		for (int i = 1; i <= n; i++) {
			for (int k = 1; k <= max; k++) {
				int m = k * k;
				if (m == i) {
					a[i] = 1;
				} else if (m < i) {
					a[i] = Math.min(a[i], a[i - m] + 1);
				}
			}
		}

		return a[n];
	}
}
