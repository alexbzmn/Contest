package com.alexbzmn;

public class MaxDoubleSlice {

	public static void main(String[] args) {
		//		System.out.println(solution(new int[] { 3, 2, 6, -1, 4, 5, -1, 2 }));
		//				System.out.println(solution(new int[] { 3, 2, 6 }));
		System.out.println(solution(new int[] { -10, -20, -30, 10, 10, -2000, 10, 10, -3000, 10 }));
	}

	public static int solution(int[] A) {
		int sum = 0;

		for (int i = 0; i < A.length; i++) {
			sum += A[i];
		}

		int maxSum = Integer.MIN_VALUE;
		int minSecondPointIdx = 1;
		int cumSum = sum;

		for (int i = 0; i < A.length; i++) {
			cumSum -= A[i];
			if (cumSum > maxSum) {
				maxSum = cumSum;

				if (i >= minSecondPointIdx) {
					minSecondPointIdx = i + 1;
				}
			}

			if (i + 1 <= A.length - 2 && A[i + 1] < A[minSecondPointIdx]) {
				minSecondPointIdx = i + 1;
			}
		}

		maxSum = maxSum - A[minSecondPointIdx] - A[A.length - 1];
		cumSum = maxSum;
		for (int i = A.length - 2; i > minSecondPointIdx; i--) {
			cumSum -= A[i];
			if (cumSum > maxSum) {
				maxSum = cumSum;
			}
		}

		return maxSum;
	}

}
