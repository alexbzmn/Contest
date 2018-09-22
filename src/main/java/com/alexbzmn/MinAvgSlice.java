package com.alexbzmn;

public class MinAvgSlice {

	public static int solution(int[] A) {
		float minSliceAvg = (float)(A[0] + A[1]) / 2.0f;
		int minSliceIndex = 0;

		for (int i = 0; i < A.length - 1; i++) {
			float currentPairAvg = (float)(A[i] + A[i + 1]) / 2.0f;
			if (currentPairAvg < minSliceAvg) {
				minSliceAvg = currentPairAvg;
				minSliceIndex = i;
			}

			if (i + 2 < A.length) {
				currentPairAvg = (float)(A[i] + A[i + 1] + A[i + 2]) / 3.0f;
				if (currentPairAvg < minSliceAvg) {
					minSliceAvg = currentPairAvg;
					minSliceIndex = i;
				}
			}
		}

		return minSliceIndex;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 4, 2, 2, 5, 1, 5, 8 }));
	}

}
