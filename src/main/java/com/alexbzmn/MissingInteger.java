package com.alexbzmn;

import java.util.HashSet;
import java.util.Set;

public class MissingInteger {

	public int solution(int[] A) {
		int largest = Integer.MIN_VALUE;

		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < A.length; i++) {
			if (A[i] > largest) {
				largest = A[i];
			}
			set.add(A[i]);
		}

		if (largest <= 0) {
			return 1;
		}

		for (int i = 1; i <= largest; i++) {
			if (!set.contains(i)) {
				return i;
			}
		}

		return largest + 1;
	}
}
