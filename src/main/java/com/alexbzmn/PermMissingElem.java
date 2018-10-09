package com.alexbzmn;

public class PermMissingElem {
	public int solution(int[] A) {
		int[] indices = new int[A.length + 1];

		for (int i = 0; i < A.length; i++) {
			indices[A[i] - 1] = 1;
		}

		for (int i = 0; i < indices.length; i++) {
			if (indices[i] == 0) {
				return i + 1;
			}
		}

		return -1;
	}
}
