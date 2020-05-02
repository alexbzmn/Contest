package com.alexbzmn;

public class NumberOfIslands {

	public int numIslands(char[][] grid) {
		int count = 0;

		if (grid.length == 0) {
			return count;
		}

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				count += mark(i, j, grid, false);
			}
		}

		return count;
	}

	private int mark(int i, int j, char[][] grid, boolean inherit) {

		if ((i < 0 || i >= grid.length) || (j < 0 || j >= grid[0].length)) {
			return 0;
		}

		if (grid[i][j] == '2') {
			return 0;
		}

		if (grid[i][j] == '1') {
			grid[i][j] = '2';

			mark(i + 1, j, grid, true);
			mark(i, j + 1, grid, true);
			mark(i - 1, j, grid, true);
			mark(i, j - 1, grid, true);

			if (!inherit) {
				return 1;
			} else {
				return 0;
			}
		}

		return 0;
	}

}
