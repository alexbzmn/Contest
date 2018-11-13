package com.alexbzmn;

import java.util.Stack;

public class MaxNonoverlappingSegments {

	public int solution(int[] A, int[] B) {

		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < A.length; i++) {
			if (stack.isEmpty()) {
				stack.push(B[i]);
			} else {
				if (stack.peek() < A[i]) {
					stack.push(B[i]);
				}
			}
		}

		return stack.size();
	}
}
