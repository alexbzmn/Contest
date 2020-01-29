package com.alexbzmn;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {

        List<Integer> res = new SpiralMatrix().spiralOrder(new int[][]{new int[]{1, 2, 3}, new int[]{4, 5, 6}, new int[]{7, 8, 9}});
        System.out.println(res);
    }

    public List<Integer> spiralOrder(int[][] matrix) {

        int r = matrix.length;
        List<Integer> res = new ArrayList<>();
        if (r == 0) {
            return res;
        }
        int c = matrix[0].length;
        if (c == 0) {
            return res;
        }

        boolean[][] seen = new boolean[r][c];

        int[] dr = new int[]{0, 1, 0, -1};
        int[] dc = new int[]{1, 0, -1, 0};

        int i = 0;
        int j = 0;

        int ci = 0;
        int cj = 0;
        int side = 0;

        for (int k = 0; k < r * c; k++) {
            res.add(matrix[i][j]);
            seen[i][j] = true;

            ci = i + dr[side];
            cj = j + dc[side];

            if (0 <= ci && ci < r && 0 <= cj && cj < c && !seen[ci][cj]) {
                i = i + dr[side];
                j = j + dc[side];
            } else {
                side = (side + 1) % 4;
                i = i + dr[side];
                j = j + dc[side];
            }
        }

        return res;
    }
}
