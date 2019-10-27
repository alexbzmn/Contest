package com.alexbzmn;

import java.util.ArrayList;
import java.util.List;

public class Flags {

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2 }));
	}

	public static int solution(int[] A) {
		List<Integer> peaks = new ArrayList<>();

		for (int i = 1; i < A.length - 1; i++) {
			if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
				peaks.add(i);
			}
		}

		int countFlags = 0;
		int maxFlagsCount = 0;
		for (int i = peaks.size(); i > 0; i--) {
			if (i <= maxFlagsCount) {
				break;
			}

			int lastPeakIndex = 0;
			for (int j = 0; j < peaks.size(); j++) {
				if (j == 0 || peaks.get(j) - lastPeakIndex >= i) {
					countFlags++;
					lastPeakIndex = peaks.get(j);
				}
			}

			maxFlagsCount = Math.max(maxFlagsCount, countFlags);
		}

		return maxFlagsCount;
	}

}
