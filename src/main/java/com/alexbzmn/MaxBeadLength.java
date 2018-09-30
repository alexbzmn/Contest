package com.alexbzmn;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MaxBeadLength {

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 5, 4, 0, 3, 1, 6, 2 }));
		System.out.println(solution(new int[] {}));
		System.out.println(solution(new int[] { 1, 2, 3, 4, 5, 0 }));
		System.out.println(solution(new int[] { 0 }));
		System.out.println(solution(new int[] { 1, 2, 0, 4, 6, 5, 3 }));
		System.out.println(solution(new int[] { 1, 0 }));
		System.out.println(solution(new int[] { 0, 1, 2, 3, 4, 5, 6 }));

	}

	public static int solution(int[] A) {
		int maxBeadSize = 0;
		Set<Integer> unvisited = new HashSet<>();

		for (int i = 0; i < A.length; i++) {
			unvisited.add(i);
		}

		while (!unvisited.isEmpty()) {
			Iterator<Integer> iterator = unvisited.iterator();
			int i = iterator.next();
			iterator.remove();

			boolean isCircleFound = false;
			int currentSize = 0;

			int j = i;
			while (!isCircleFound) {
				if (A[j] != -1) {
					currentSize += 1;
					int buffer = A[j];
					A[j] = -1;
					unvisited.remove(j);
					j = buffer;
				} else {
					isCircleFound = true;
					maxBeadSize = Math.max(maxBeadSize, currentSize);
				}
			}

			maxBeadSize = Math.max(maxBeadSize, currentSize);

		}

		return maxBeadSize;
	}

	;

}
