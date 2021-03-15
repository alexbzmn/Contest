package com.alexbzmn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class ZeroSumIntervals {

	public static void main(String[] args) {

		System.out.println(solution(new int[] { 2, -2, 3, 0, 4, -7 }));
		System.out.println(solution(new int[] { 6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7 }));
		System.out.println(solution(new int[] { 2, -2, 2, -2, 2, -2, 2, -2, 2 })); //

		int[] a = new int[100000];

		System.out.println(solution(a));

	}

	public static int solution(int[] A) {
		Map<Integer, List<Integer>> map = new HashMap<>();

		int sum = 0;
		int count = 0;
		for (int i = 0; i < A.length; i++) {
			sum += A[i];

			if (sum == 0) {
				if (count + 1 == 1000000) {
					return -1;
				}
				count++;
			}

			List<Integer> points = new ArrayList<>();

			if (map.containsKey(sum)) {
				points = map.get(sum);
				if (count + points.size() >= 1000000) {
					return -1;
				}
				count += points.size();
			}
			points.add(i);
			map.put(sum, points);
		}

		return count;
	}

}
