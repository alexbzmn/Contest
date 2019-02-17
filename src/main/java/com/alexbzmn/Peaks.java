package com.alexbzmn;

import java.util.ArrayList;
import java.util.List;

public class Peaks {

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2 }));
		System.out.println(solution(new int[] { 6, 2, 1, 3, }));
		System.out.println(solution(new int[] { 1, 2, 1, 1, 2, 1 }));
	}

	public static int solution(int[] A) {
		int N = A.length;
		List<Integer> peaks = new ArrayList<>();

		for (int i = 1; i < A.length - 1; i++) {
			if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
				peaks.add(i);
			}
		}

		for (int groupSize = 1; groupSize <= N; groupSize++) {
			if (N % groupSize != 0) {
				continue;
			}

			int groupCount = N / groupSize;
			int validGroupCount = 0;

			for (int peakIdx : peaks) {
				if (peakIdx / groupSize > validGroupCount) {
					break;
				}

				if (peakIdx / groupSize == validGroupCount) {
					validGroupCount++;
				}
			}

			if (validGroupCount == groupCount) {
				return groupCount;
			}

		}

		return 0;
	}

	public static int solution2(int[] A) {
		int N = A.length;

		if (N < 3) {
			return 0;
		}

		List<Integer> peaks = new ArrayList<>();

		int len = 1;
		int lastPeakIdx = 1;
		for (int i = 1; i < A.length - 1; i++) {
			len++;
			if (A[i - 1] < A[i] && A[i] > A[i + 1]) {
				peaks.add(len);
				len = 0;
				lastPeakIdx = i;
			}
		}

		if (peaks.size() < 1) {
			return 0;
		}

		peaks.add(N - lastPeakIdx);

		int[] p = peaks.stream().mapToInt(value -> value).toArray();

		int maxLength = Math.max(p[0], p[p.length - 1]);

		while (N % maxLength != 0 || N / maxLength > p.length - 1) {
			maxLength++;
		}

		return N / maxLength;
	}

}
