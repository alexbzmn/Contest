package com.alexbzmn;

public class MaxSquare {

	public int maximalSquare(char[][] matrix) {

		int maxL = 0;
		for (int i = 0; i < matrix.length; i++) {

			for (int j = 0; j < matrix[0].length; j++) {
				int start = 1;

				if (matrix[i][j] == '1') {
					maxL = Math.max(maxL, 1);
				}

				while (((j + start) < matrix[0].length && (i + start < matrix.length)) &&
					isSquare(matrix, i, j, i + start, j + start)) {
					maxL = Math.max(maxL, (start + 1) * (start + 1));
					start++;
				}

			}

		}

		return maxL;
	}

	private boolean isSquare(char[][] matrix, int a1, int a2, int b1, int b2) {

		for (int i = a1; i <= b1; i++) {
			for (int j = a2; j <= b2; j++) {

				if (matrix[i][j] != '1') {
					return false;
				}

			}
		}

		return true;
	}

}
