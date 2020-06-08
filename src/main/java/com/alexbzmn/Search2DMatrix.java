package com.alexbzmn;

public class Search2DMatrix {

	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}

		int n = matrix.length - 1;
		int m = matrix[0].length - 1;

		int i = n;
		int j = 0;

		while (i >= 0 && j <= m) {
			if (target > matrix[i][j]) {
				j++;
			} else if (target < matrix[i][j]) {
				i--;
			} else {
				return true;
			}
		}

		return false;
	}

}
