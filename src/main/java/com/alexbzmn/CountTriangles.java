package com.alexbzmn;

import java.util.Arrays;

public class CountTriangles {

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 10, 2, 5, 1, 8, 12 })); //4
		System.out.println(solution(new int[] { 1, 2, 5, 8, 10, 12 })); //4
	}

	public static int solution(int[] A) {
		Arrays.sort(A);

		int count = 0;
		for (int i = 0; i < A.length - 2; i++) {
			int k = i + 2;
			for (int j = i + 1; j < A.length - 1; j++) {
				while (k < A.length && A[i] + A[j] > A[k]) {
					k++;
				}
				count += k - j - 1;
			}
		}

		return count;
	}

}
