package com.alexbzmn;

import java.util.Arrays;
import java.util.Random;

public class MaxCounters {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(7, new int[] { 1, 1, 1, 2, 8, 4, 5, 4, 8, 5, 6, 1, 1, 1, 8, 1, 1, 1, 8, 2, 2, 8, 8, 8 })));
		int[] streamOfRandomInts = getStreamOfRandomInts(10);
		System.out.println(Arrays.toString(streamOfRandomInts) + "=" + Arrays.toString(solution(7, streamOfRandomInts)));
	}

	public static int[] solution2(int N, int[] A) {
		int[] counters = new int[N];
		int currentMax = 0;
		int frozenMax = 0;

		for (int i = 0; i < A.length; i++) {
			int op = A[i];
			if (op == N + 1) {
				frozenMax = currentMax;
			} else {
				int val = counters[op - 1] + 1;
				if (val > currentMax) {
					currentMax = val;
					counters[op - 1] = val;
				} else {
					counters[op - 1] = val < frozenMax ? frozenMax + 1 : val;
				}
			}
		}

		for (int i = 0; i < counters.length; i++) {
			if (counters[i] < frozenMax) {
				counters[i] = frozenMax;
			}
		}

		return counters;
	}

	public static int[] solution(int N, int[] A) {
		int[] counters = new int[N];
		int currentMax = 0;
		int lastUpdate = 0;

		for (int i = 0; i < A.length; i++) {
			int op = A[i];
			if (op == N + 1) {
				lastUpdate = currentMax;
			} else {
				int position = op - 1;

				if (counters[position] < lastUpdate) {
					counters[position] = lastUpdate + 1;
				} else {
					counters[position]++;
				}

				if (counters[position] > currentMax) {
					currentMax = counters[position];
				}
			}
		}

		for (int i = 0; i < counters.length; i++) {
			if (counters[i] < lastUpdate) {
				counters[i] = lastUpdate;
			}
		}

		return counters;
	}

	public static int[] getStreamOfRandomInts(int num) {
		Random random = new Random();
		return random.ints(num, 1, 9).sorted().toArray();
	}

}
