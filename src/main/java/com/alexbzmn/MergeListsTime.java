package com.alexbzmn;

import java.util.Arrays;

public class MergeListsTime {

	public static void main(String[] args) {
		//		System.out.println(solution(new int[] { 100 }));
		//		System.out.println(solution(new int[] { 100, 250 }));
		//		System.out.println(solution(new int[] { 100, 250, 1000 }));
		System.out.println(solution(new int[] { 2, 3, 4, 6, 10, 11, 22, 34, 35 })); // 46,
		//		System.out.println(solution(new int[] { 2, 3, 4, 6, 10, 11, 22, })); // 46,
		//		System.out.println(solutionN(new int[] { 2, 3, 4, 6, 10, 11, 22})); // 46,
		// 5 14 24 54 119
		// 5 30 11
		//		System.out.println(solution(new int[] { 6, 2, 3, 4, 21 }));
		//		System.out.println(solution(new int[] { 6, 2, 3, 4, 10, 11, 13, 14 }));
	}

	// 5 10 64
	// 5 84
	// 94

	public static int solution(int[] A) {
		Arrays.sort(A);

		return recSum(A, 0);
	}

	private static int recSum(int[] A, int i) {
		int sum;

		if (A.length - i == 1) {
			return A[i];
		} else {
			sum = A[i] + A[i + 1];
		}

		for (int j = i + 2; j < A.length; j++) {
			if (sum >= A[j]) {
				int forward = recSum(A, j);
				return sum + (sum + forward);
			}
			sum += sum + A[j];
		}

		return sum;
	}

	public static int solutionN(int[] A) {
		Arrays.sort(A);
		int sum = 0;

		if (A.length < 2) {
			return sum;
		} else {
			sum = A[0] + A[1];
		}

		for (int i = 2; i < A.length; i++) {
			sum += sum + A[i];
		}

		return sum;
	}
}
