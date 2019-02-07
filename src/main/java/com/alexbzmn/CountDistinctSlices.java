package com.alexbzmn;

import java.util.HashSet;
import java.util.Set;

public class CountDistinctSlices {

	public static void main(String[] args) {
		System.out.println(solution2(6, new int[] { 3, 4, 5, 5, 2 }));
	}

	public static int solution(int M, int[] A) {
		Set<Integer> set = new HashSet<>();

		int count = 0;
		for (int i = 0; i < A.length; i++) {
			if (set.contains(A[i])) {
				set = new HashSet<>();
			}
			set.add(A[i]);
			count += set.size();
		}

		return Math.min(count, 1000000000);
	}

	public static int solution2(int M, int[] A) {
		int sum = 0;
		int front = 0;
		int back = 0;

		Set<Integer> seen = new HashSet<>();
		while (front < A.length && back < A.length) {
			while (front < A.length && (!seen.contains(A[front]))) {
				sum += (front - back) + 1;
				seen.add(A[front]);
				front++;
			}

			while (A[back] != A[front]) {
				seen.remove(A[back]);
				back++;
			}

			seen.remove(A[back]);
			back++;
		}

		return Math.min(sum, 1000000000);
	}
}
