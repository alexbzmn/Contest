package com.alexbzmn;

import java.util.Stack;

public class Fish {

	public int solution(int[] A, int[] B) {
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> stackDest = new Stack<>();

		for (int i = 0; i < A.length; i++) {
			int fishSize = A[i];
			int destination = B[i];

			if (stack.size() == 0 || stackDest.peek() == 0) {
				stack.push(fishSize);
				stackDest.push(destination);
			} else {
				if (destination == 1) {
					stack.push(fishSize);
					stackDest.push(destination);
				} else {
					while (stack.size() > 0 && stackDest.peek() == 1 && fishSize > stack.peek()) {
						stack.pop();
						stackDest.pop();
					}

					if (stack.size() == 0 || stackDest.peek() == destination) {
						stack.push(fishSize);
						stackDest.push(destination);
					}
				}
			}
		}

		return stack.size();
	}

}
