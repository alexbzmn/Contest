package com.alexbzmn;

import java.util.Arrays;

public class GenomicRangeQuery {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution("CAGCCTA", new int[] { 2, 5, 0 }, new int[] { 4, 5, 6 })));
		System.out.println(Arrays.toString(solution("C", new int[] { 0 }, new int[] { 0 })));
		System.out.println(Arrays.toString(solution("AT", new int[] { 0, 0, 1 }, new int[] { 0, 1, 1 })));
	}

	public static int[] solution(String S, int[] P, int[] Q) {

		char[] seq = S.toCharArray();

		int[] lastSeenA = new int[seq.length];
		int[] lastSeenC = new int[seq.length];
		int[] lastSeenG = new int[seq.length];
		int[] lastSeenT = new int[seq.length];

		for (int i = 0; i < seq.length; i++) {
			saveToLastSeenArray(lastSeenA, seq, i, 'A');
			saveToLastSeenArray(lastSeenC, seq, i, 'C');
			saveToLastSeenArray(lastSeenG, seq, i, 'G');
			saveToLastSeenArray(lastSeenT, seq, i, 'T');
		}

		int[] result = new int[P.length];

		for (int i = 0; i < Q.length; i++) {
			if (lastSeenA[Q[i]] >= P[i]) {
				result[i] = 1;
			} else if (lastSeenC[Q[i]] >= P[i]) {
				result[i] = 2;
			} else if (lastSeenG[Q[i]] >= P[i]) {
				result[i] = 3;
			} else if (lastSeenT[Q[i]] >= P[i]) {
				result[i] = 4;
			}
		}

		return result;
	}

	private static void saveToLastSeenArray(int[] lastSeen, char[] seq, int idx, char c) {
		if (seq[idx] == c) {
			lastSeen[idx] = idx;
		} else {
			lastSeen[idx] = idx > 0 ? lastSeen[idx - 1] : -1;
		}
	}
}
