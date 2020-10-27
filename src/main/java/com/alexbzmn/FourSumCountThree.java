package com.alexbzmn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FourSumCountThree {

	public static void main(String[] args) {
		String v =
			"[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]\n"
				+ "[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]\n"
				+ "[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]\n"
				+ "[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]";

		String[] split = v.split("\n");
		Integer[] a = Arrays.stream(split[0].replace("[", "").replace("]", "").split(",")).map(Integer::parseInt).toArray(value -> new Integer[100]);
		Integer[] b = Arrays.stream(split[1].replace("[", "").replace("]", "").split(",")).map(Integer::parseInt).toArray(value -> new Integer[100]);
		Integer[] c = Arrays.stream(split[2].replace("[", "").replace("]", "").split(",")).map(Integer::parseInt).toArray(value -> new Integer[100]);
		Integer[] d = Arrays.stream(split[3].replace("[", "").replace("]", "").split(",")).map(Integer::parseInt).toArray(value -> new Integer[100]);
		System.out.println(new FourSumCountThree().fourSumCount(a, b, c, d));
	}

	public int fourSumCount(Integer[] A, Integer[] B, Integer[] C, Integer[] D) {
		Map<Long, Integer> a = generate(A, B);
		Map<Long, Integer> b = generate(C, D);

		int c = 0;

		for (Long key : a.keySet()) {
			for (Long key2 : b.keySet()) {
				if (a.get(key) + b.get(key2) == 0) {
					c++;
				}
			}
		}

		return c;
	}

	private Map<Long, Integer> generate(Integer[] a, Integer[] b) {
		Map<Long, Integer> map = new HashMap<>();

		long c = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				map.put(c++, a[i] + b[j]);
			}
		}

		return map;
	}
}
