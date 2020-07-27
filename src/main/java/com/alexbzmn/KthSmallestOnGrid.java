package com.alexbzmn;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallestOnGrid {

	public static void main(String[] args) {

		//		System.out.println(new KthSmallestOnGrid().kthSmallest(new int[][] { new int[] { 1, 5, 9 }, new int[] { 10, 11, 13 }, new int[] { 12, 13, 15 } }, 8));
//		System.out.println(new KthSmallestOnGrid().kthSmallest(new int[][] { new int[] { 1, 5, 9 }, new int[] { 10, 11, 13 }, new int[] { 12, 13, 15 } }, 5));

		System.out.println('z' - 'a');
	}



	public int kthSmallest(int[][] matrix, int k) {
		Queue<Tuple> q = new PriorityQueue<>((a, b) -> a.val - b.val);
		for (int i = 0; i < matrix[0].length; i++) {
			q.add(new Tuple(i, 0, matrix[0][i]));
		}

		int c = 1;
		while (c != k && !q.isEmpty()) {
			Tuple t = q.poll();
			if (t.y + 1 < matrix.length) {
				q.add(new Tuple(t.x, t.y + 1, matrix[t.y + 1][t.x]));
			}
			c++;
		}

		return q.poll().val;
	}

	private static class Tuple {

		private int x;

		private int y;

		private int val;

		private Tuple(int x, int y, int val) {
			this.x = x;
			this.y = y;
			this.val = val;
		}
	}

}
