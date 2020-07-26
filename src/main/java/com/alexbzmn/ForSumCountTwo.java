package com.alexbzmn;

import java.util.HashMap;
import java.util.Map;

public class ForSumCountTwo {

	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		int c = 0;
		Map<Integer, Integer> m = new HashMap<>();

		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				int key = A[i] + B[j];
				m.put(key, m.getOrDefault(key, 0) + 1);
			}
		}

		//00: -1, 01: 0, 10: 0, 11: 1
		//00: -1, 01: 1, 10: 2, 11: 4

		for (int i = 0; i < C.length; i++) {
			for (int j = 0; j < D.length; j++) {
				c += m.getOrDefault(-(C[i] + D[j]), 0);
			}
		}

		return c;
	}

}
