package com.alexbzmn;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

//https://www.martinkysel.com/codility-countnondivisible-solution/

public class CountNonDivisible {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[] { 3, 1, 2, 3, 6 })));
	}

	//todo fix and finish
	public static int[] solution2(int[] A) {

		Map<Integer, Integer> count = new HashMap<>();
		for (int i = 0; i < A.length; i++) {
			if (count.containsKey(A[i])) {
				count.put(A[i], count.get(A[i]) + 1);
			} else {
				count.put(A[i], 1);
			}
		}

		Map<Integer, Set<Integer>> divisors = new HashMap<>();
		for (int i = 0; i < A.length; i++) {
			divisors.put(A[i], new HashSet<>(Arrays.asList(1, A[i])));
		}

		int max = Collections.max(Arrays.stream(A).boxed().collect(Collectors.toList()));
		int divisor = 2;

		while (divisor * divisor <= max) {
			int elementCandidate = divisor;
			while (elementCandidate <= max) {
				if (divisors.containsKey(elementCandidate) && !divisors.get(elementCandidate).contains(divisor)) {
					divisors.get(elementCandidate).add(divisor);
					divisors.get(elementCandidate).add(elementCandidate / divisor);
				}
				elementCandidate += divisor;
			}

			divisor++;
		}

		int[] b = new int[A.length];

		for (int i = 0; i < A.length; i++) {
			int sum = 0;

			Iterator iter = divisors.get(A[i]).iterator();
			while (iter.hasNext()) {
				sum += count.get(iter.next());
			}

			b[i] = A.length - sum;
		}

		return b;
	}

	public static int[] solution(int[] A) {
		int[] b = Arrays.copyOf(A, A.length);

		Arrays.sort(A);
		Map<Integer, Integer> div = new HashMap<>();

		for (int i = 0; i < A.length; i++) {
			if (div.containsKey(A[i])) {
				continue;
			}

			int count = 0;
			for (int j = i; j >= 0; j--) {
				if (A[i] % A[j] != 0) {
					count++;
				}
			}

			int lastIndexI = i + 1;
			if (i < A.length - 1) {
				for (int j = i + 1; j < A.length; j++) {
					if (A[j] == A[i]) {
						lastIndexI++;
					} else {
						break;
					}
				}
			}

			count += A.length - lastIndexI;

			div.put(A[i], count);
		}

		for (int i = 0; i < b.length; i++) {
			b[i] = div.get(b[i]);
		}

		return b;
	}

}
