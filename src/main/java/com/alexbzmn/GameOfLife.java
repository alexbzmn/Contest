package com.alexbzmn;

public class GameOfLife {

	public void gameOfLife(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				int c = 0;
				c += probe(i - 1, j - 1, board);
				c += probe(i - 1, j, board);
				c += probe(i - 1, j + 1, board);
				c += probe(i, j - 1, board);
				c += probe(i, j + 1, board);
				c += probe(i + 1, j - 1, board);
				c += probe(i + 1, j, board);
				c += probe(i + 1, j + 1, board);

				boolean isLive = board[i][j] == 1;
				if (isLive && (c < 2 || c > 3)) {
					board[i][j] = -1;
				} else if (!isLive && c == 3) {
					board[i][j] = 2;
				}

			}
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 2) {
					board[i][j] = 1;
				} else if (board[i][j] == -1) {
					board[i][j] = 0;
				}
			}
		}

	}

	private int probe(int i, int j, int[][] board) {
		if (i < 0 || j < 0) {
			return 0;
		} else if (i == board.length || j == board[0].length) {
			return 0;
		}

		return board[i][j] == 1 || board[i][j] == -1 ? 1 : 0;
	}

}
