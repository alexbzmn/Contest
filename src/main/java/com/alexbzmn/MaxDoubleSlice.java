package com.alexbzmn;

public class MaxDoubleSlice {

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 3, 2, 6, -1, 4, 5, -1, 2 }));
		System.out.println(solution(new int[] { 3, 2, 6 }));
		System.out.println(solution(new int[] { -10, -20, -30, 10, 10, -2000, 10, 10, -3000, 10 })); //40
		System.out.println(solution(new int[] { -10, -20, -30, 10, 10, -1000, -2000, -10, 10, 10, -3000, 10 })); //-6020 20
		System.out.println(solution(new int[] { -8, 10, 20, -5, -7, -4 }));
	}

	public static int solution(int[] A) {

		int[] f = new int[A.length];
		int[] b = new int[A.length];

		for (int i = 1; i < A.length; i++) {
			f[i] = Math.max(0, f[i - 1] + A[i]);
		}

		for (int i = A.length - 2; i >= 0; i--) {
			b[i] = Math.max(0, b[i + 1] + A[i]);
		}

		int sum = Integer.MIN_VALUE;
		for (int i = 1; i < f.length - 1; i++) {
			sum = Math.max(sum, f[i - 1] + b[i + 1]);
		}
		return sum;
	}

}
