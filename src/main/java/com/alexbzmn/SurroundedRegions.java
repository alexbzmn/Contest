package com.alexbzmn;

import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SurroundedRegions {

	public static void main(String[] args) {

		char[][] c = new char[][] {
			new char[] { 'X', 'X', 'X', 'X' }, new char[] { 'X', 'O', 'O', 'X' }, new char[] { 'X', 'X', 'O', 'X' }, new char[] { 'X', 'O', 'X', 'X' }
		};

		Arrays.stream(c).forEach(cc -> System.out.println(Arrays.toString(cc)));

		new SurroundedRegions().solve(c);
		System.out.println();

		Arrays.stream(c).forEach(cc -> System.out.println(Arrays.toString(cc)));
	}

	public void solve(char[][] board) {

		Set<SimpleEntry<Integer, Integer>> v = new HashSet<>();

		int[] dirX = new int[] { 1, 0, -1, 0 };
		int[] dirY = new int[] { 0, 1, 0, -1 };

		int i = 0;
		int j = 0;

		for (int s = 0; s < 4; s++) {
			int nextY = i;
			int nextX = j;
			while ((nextX >= 0 && nextX < board[0].length) && (nextY >= 0 && nextY < board.length)) {
				i = nextY;
				j = nextX;

				mark(board, i, j, v);

				nextY = i + dirY[s];
				nextX = j + dirX[s];
			}

		}

		for (int ii = 0; ii < board.length; ii++) {
			for (int jj = 0; jj < board[0].length; jj++) {
				if (!v.contains(new SimpleEntry<>(ii, jj)) && board[ii][jj] != 'X') {
					board[ii][jj] = 'X';
				}
			}
		}

	}

	private void mark(char[][] b, int i, int j, Set<SimpleEntry<Integer, Integer>> v) {
		if (b[i][j] != 'O' || !check(b, i, j, v)) {
			return;
		}

		v.add(new SimpleEntry<>(i, j));

		if (check(b, i + 1, j, v)) {
			mark(b, i + 1, j, v);
		}

		if (check(b, i, j + 1, v)) {
			mark(b, i, j + 1, v);
		}

		if (check(b, i - 1, j, v)) {
			mark(b, i - 1, j, v);
		}

		if (check(b, i, j - 1, v)) {
			mark(b, i, j - 1, v);
		}

	}

	private boolean check(char[][] b, int i, int j, Set<SimpleEntry<Integer, Integer>> v) {
		if ((j >= 0 && j < b[0].length) && (i >= 0 && i < b.length)
			&& !v.contains(new SimpleEntry<>(i, j)))
		{
			return true;
		} else {
			return false;
		}
	}

}
