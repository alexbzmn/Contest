package com.alexbzmn;

import java.util.Arrays;

public class StairsCodility {

	public static void main(String[] args) {
		//		System.out.println(calculateWays(2));
		//		System.out.println(calculateWays(3));
		//		System.out.println(calculateWays(4));
		//		System.out.println(calculateWays(5));
		//		System.out.println(calculateWays(6));
		//		System.out.println(Arrays.toString(genericStairsProblem(50000, 2)));
		System.out.println(Arrays.toString(solutionMem(new int[] { 4, 4, 5, 5, 1 }, new int[] { 3, 2, 4, 3, 1 })));
		System.out.println(Arrays.toString(solutionMem(new int[] { 50000 }, new int[] { 30})));
	}

	public int[] solution(int[] A, int[] B) {
		int[] result = new int[A.length];

		for (int i = 0; i < A.length; i++) {
			result[i] = calculateWays(A[i]) % (int)Math.pow(2, B[i]);
		}

		return result;
	}

	private static int calculateWays(int n) {

		if (n == 0) {
			return 1;
		}

		if (n == 1) {
			return 1;
		}

		if (n == 2) {
			return 2;
		}

		if (n >= 3) {
			return calculateWays(n - 1) + calculateWays(n - 2);
		}

		return 0;
	}

	public static int[] solutionMem(int[] A, int[] B) {

		int max = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] > max) {
				max = A[i];
			}
		}

		int maxLimit = 0;
		for (int i = 0; i < B.length; i++) {
			if (B[i] > maxLimit) {
				maxLimit = B[i];
			}
		}

		maxLimit = (1 << maxLimit) - 1;

		int[] mem = createReducedFibArray(max + 1, maxLimit);

		int[] result = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			result[i] = mem[A[i]] & ((1 <<B[i]) - 1);
		}

		return result;
	}

	public static int[] createReducedFibArray(int n, int limit) {
		int[] mem = new int[n];
		mem[0] = 1;

		if (n == 1) {
			return mem;
		}

		mem[1] = 1;

		for (int i = 2; i < n; i++) {
			mem[i] = mem[i - 1] + mem[i - 2] & limit;
		}

		return mem;
	}
	//
	//	public static long[] genericStairsProblem(int n, int m) {
	//		long[] mem = new long[n];
	//		mem[0] = 1;
	//
	//		if (n == 1) {
	//			return mem;
	//		}
	//
	//		mem[1] = 1;
	//
	//		for (int i = 2; i < n; i++) {
	//			mem[i] = 0;
	//
	//			for (int j = 1; j <= m && j <= i; j++) {
	//				mem[i] += mem[i - j];
	//			}
	//		}
	//
	//		return mem;
	//	}

}
