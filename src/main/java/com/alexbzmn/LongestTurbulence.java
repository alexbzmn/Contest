package com.alexbzmn;

public class LongestTurbulence {

	public static void main(String[] args) {

//		System.out.println(solution(new int[] { 100 }));
//		System.out.println(solution(new int[] { 4, 8, 12, 16 }));
//		System.out.println(solution(new int[] { 50, 150, 50, 150 }));
//		System.out.println(solution(new int[] { 50, 150 }));
//		System.out.println(solution(new int[] { 50, 150, 150, 1, 300 }));
//		System.out.println(solution(new int[] { 150, 150, 1, 300 }));
//		System.out.println(solution(new int[] { 150, 150, 300 }));
//		System.out.println(solution(new int[] { 150, 150, 300 }));
//		System.out.println(solution(new int[] { 150, 150 }));
//		System.out.println(solution(new int[] { 150, 150, 150, 150 }));
		System.out.println(solution(new int[] { 150, 150, 150, 120, 120, 123 }));
		System.out.println(solution(new int[] { 150, 150, 150, 120, 123 }));
//		System.out.println(solution(new int[] { 9, 4, 2, 10, 7, 8, 8, 1, 9 }));
//
//		int[] t = new int[100_000];
//		for (int i = 0; i < 100_000; i += 2) {
//			t[i] = 50;
//			t[i + 1] = 100;
//		}
//
//		System.out.println(solution(t));
	}

	static int solution(int[] A) {
		if (A.length == 1) {
			return 1;
		}

		int right = 1;
		int maxLen = 0;
		int currLen = 1;

		while (right < A.length) {

			if (A[right - 1] == A[right]) {
				maxLen = Math.max(maxLen, currLen);
				currLen = 1;
			} else {
				boolean currLess = A[right - 1] < A[right];

				boolean signChanged;
				if (right - 2 >= 0) {
					boolean prevLess = A[right - 2] < A[right - 1];
					signChanged = prevLess ^ currLess;
				} else {
					signChanged = currLess;
				}

				if (signChanged) {
					currLen++;
				} else {
					maxLen = Math.max(maxLen, currLen);
					currLen = 2;
				}
			}

			right++;
		}

		maxLen = Math.max(currLen, maxLen);

		return maxLen;
	}
}
