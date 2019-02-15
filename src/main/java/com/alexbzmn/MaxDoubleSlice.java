package com.alexbzmn;

public class MaxDoubleSlice {

	public static void main(String[] args) {
//		System.out.println(solution(new int[] { 3, 2, 6, -1, 4, 5, -1, 2 }));
//		System.out.println(solution(new int[] { 3, 2, 6 }));
		System.out.println(solution(new int[] { -10, -20, -30, 10, 10, -2000, 10, 10, -3000, 10 }));
//		System.out.println(solution(new int[] { -8, 10, 20, -5, -7, -4 }));
	}

	public static int solution(int[] A) {
		int sum = 0;

		for (int i = 0; i < A.length; i++) {
			sum += A[i];
		}

		int maxSum = Integer.MIN_VALUE;
		int prevMaxSum = Integer.MIN_VALUE;
		int maxSumFirstIdx = 0;
		int prevMaxSumIdx = 0;
		int cumSum = sum;

		for (int i = 0; i < A.length; i++) {
			cumSum -= A[i];
			if (cumSum > maxSum) {
				prevMaxSum = maxSum;
				maxSum = cumSum;
				prevMaxSumIdx = maxSumFirstIdx;
				maxSumFirstIdx = i;
			}
		}

		if ((A.length - 1) - maxSumFirstIdx < 2) {
			maxSumFirstIdx = prevMaxSumIdx;
			maxSum = prevMaxSum;
		}

		maxSum = maxSum - A[A.length - 1];
		cumSum = maxSum;
		int prevCumSum = cumSum;
		int prevIdxEnd = A.length - 1;
		int idxEnd = A.length - 1;

		for (int i = A.length - 2; i > maxSumFirstIdx; i--) {
			cumSum -= A[i];
			if (cumSum > maxSum) {
				prevIdxEnd = idxEnd;
				prevCumSum = maxSum;
				maxSum = cumSum;
				idxEnd = i;
			}
		}

		int midMin = A[maxSumFirstIdx + 1];
		int midIdx = maxSumFirstIdx + 1;
		for (int i = maxSumFirstIdx + 1; i < prevIdxEnd; i++) {
			if (A[i] < midMin) {
				midMin = A[i];
				midIdx = i;
			}
		}

		if (midIdx == idxEnd) {
			return prevCumSum - A[midIdx];
		} else {
			return maxSum - A[midIdx];
		}
	}

}
