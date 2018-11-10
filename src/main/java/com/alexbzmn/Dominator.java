package com.alexbzmn;

import java.util.HashMap;
import java.util.Map;

public class Dominator {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {3, 4, 3, 2, 3, -1, 3, 3}));

	}

	public static int solution(int[] A) {

		if (A.length == 1) {
			return 0;
		}

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < A.length; i++) {
			if (!map.containsKey(A[i])) {
				map.put(A[i], 1);
			} else {
				int occurrences = map.get(A[i]);
				if (occurrences + 1 > (A.length / 2)) {
					return i;
				}

				map.put(A[i], occurrences + 1);
			}
		}

		return -1;
	}

}
