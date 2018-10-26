package com.alexbzmn;

import java.util.Arrays;

public class Triangle {

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 10, 50, 5, 1 }));
		System.out.println(solution(new int[] { 10, 2, 5, 1, 8, 20 }));
	}

	public static int solution(int[] A) {

		if (A.length < 3) {
			return 0;
		}

		Arrays.sort(A);

		for (int i = 2; i < A.length; i++) {
			if (((long)A[i - 2] + A[i - 1]) > A[i]) {
				return 1;
			}
		}

		return 0;
	}

}
