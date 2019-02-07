package com.alexbzmn;

public class MinPerimeterRectangle {

	public int solution(int N) {
		int min = Integer.MAX_VALUE;

		int root = (int)Math.sqrt(N);
		for (int i = 0; i < root; i++) {
			int k = root - i;
			if (N % k == 0) {
				int subMin = 2 * (k + N / k);
				if (min > subMin) {
					min = subMin;
				} else {
					break;
				}
			}
		}

		return min;
	}

}
