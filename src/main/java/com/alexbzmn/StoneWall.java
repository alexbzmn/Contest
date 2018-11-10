package com.alexbzmn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class StoneWall {

	public int solution(int[] H) {
		Stack<Integer> bricks = new Stack<>();

		int nBlocks = 0;
		for (int i = 0; i < H.length; i++) {
			while (!bricks.isEmpty() && H[i] < bricks.peek()) {
				bricks.pop();
				nBlocks++;
			}
			if (bricks.isEmpty() || H[i] > bricks.peek()) {
				bricks.push(H[i]);
			}
		}

		return nBlocks + bricks.size();
	}

}
