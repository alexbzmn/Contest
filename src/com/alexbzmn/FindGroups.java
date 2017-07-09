package com.alexbzmn;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by User on 7/9/2017.
 */
public class FindGroups {
    public static int getBiggestRegion(int[][] matrix) {
        Map<String, String> groups = new HashMap<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1 && !groups.containsKey(i + " " + j)) {
                    findAdjacent(matrix, groups, i, j, i + " " + j);
                }
            }
        }

        Map<String, Integer> aggrMap = new HashMap<>();
        for (String el : groups.values()) {
            if (!aggrMap.containsKey(el)) {
                aggrMap.put(el, 1);
            } else {
                aggrMap.put(el, aggrMap.get(el) + 1);
            }
        }

        int max = 0;
        for (Integer el : aggrMap.values()) {
            if (el > max) {
                max = el;
            }
        }

        return max;
    }

    private static void findAdjacent(int[][] matrix, Map<String, String> groups, int i, int j, String head) {
        String el = i + " " + j;
        groups.put(el, head);

        String right = i + " " + (j + 1);
        if (j < (matrix[i].length - 1) && (matrix[i][j + 1] == 1) && !groups.containsKey(right)) {
            findAdjacent(matrix, groups, i, j + 1, head);
        }

        String left = i + " " + (j - 1);
        if (j > 0 && (matrix[i][j - 1] == 1) && !groups.containsKey(left)) {
            findAdjacent(matrix, groups, i, j - 1, head);
        }

        String bottom = (i + 1) + " " + j;
        if (i < matrix.length - 1 && (matrix[i + 1][j] == 1) && !groups.containsKey(bottom)) {
            findAdjacent(matrix, groups, i + 1, j, head);
        }

        String upper = (i - 1) + " " + j;
        if (i > 0 && (matrix[i - 1][j] == 1) && !groups.containsKey(upper)) {
            findAdjacent(matrix, groups, i - 1, j, head);
        }

        String upperRight = (i - 1) + " " + j + 1;
        if (i > 0 && j < (matrix[i].length - 1) && (matrix[i - 1][j + 1] == 1) && !groups.containsKey(upperRight)) {
            findAdjacent(matrix, groups, i - 1, j + 1, head);
        }

        String upperLeft = (i - 1) + " " + (j - 1);
        if (i > 0 && j > 0 && (matrix[i - 1][j - 1] == 1) && !groups.containsKey(upperLeft)) {
            findAdjacent(matrix, groups, i - 1, j - 1, head);
        }

        String bottomRight = (i + 1) + " " + j + 1;
        if (i < matrix.length - 1 && j < (matrix[i].length - 1) && (matrix[i + 1][j + 1] == 1) && !groups.containsKey(bottomRight)) {
            findAdjacent(matrix, groups, i + 1, j + 1, head);
        }

        String bottomLeft = (i + 1) + " " + (j - 1);
        if (i < matrix.length - 1 && j > 0 && (matrix[i + 1][j - 1] == 1) && !groups.containsKey(bottomLeft)) {
            findAdjacent(matrix, groups, i + 1, j - 1, head);
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int grid[][] = new int[n][m];
        for (int grid_i = 0; grid_i < n; grid_i++) {
            for (int grid_j = 0; grid_j < m; grid_j++) {
                grid[grid_i][grid_j] = in.nextInt();
            }
        }
        System.out.println(getBiggestRegion(grid));
    }
}
