package com.alexbzmn;

public class Equileader {

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 4, 3, 4, 4, 4, 2 }));
		System.out.println(solution(new int[] { 4 }));
		System.out.println(solution(new int[] { -1, -2, -1, -2, -1, -1 }));
	}

	public static int solution(int[] A) {
		Integer leader = null;
		int count = 0;

		for (int i = 0; i < A.length; i++) {
			if (leader == null) {
				leader = A[i];
				count = 1;
			} else {
				if (leader.equals(A[i])) {
					count++;
				} else {
					count--;
					if (count == 0) {
						leader = null;
					}
				}
			}
		}

		if (leader == null) {
			return 0;
		}

		int leaderCount = 0;
		for (int i = 0; i < A.length; i++) {
			if (leader.equals(A[i])) {
				leaderCount++;
			}
		}

		int equiLeaderCount = 0;
		int leftLeaderCount = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == leader) {
				leftLeaderCount++;
			}

			if ((leftLeaderCount > (i + 1) / 2) && ((leaderCount - leftLeaderCount) > (A.length - (i + 1)) / 2)) {
				equiLeaderCount++;
			}
		}

		return equiLeaderCount;
	}

}
