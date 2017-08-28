package com.alexbzmn;

import java.util.Scanner;

public class OneDKnapsack {
    private static int calculateKnapsack(int[] a, int sum) {
        int[][] ways = new int[a.length + 1][sum];

        for (int i = 0; i <= a.length; i++) {

            for (int j = 0; j < sum; j++) {
                if (i == 0 || j == 0) {
                    ways[i][j] = 0;
                } else if (a[i - 1] <= j) {
                    int diff = j - a[i - 1];
                    int underlyingEl = ways[i - 1][diff];

                    int currentEl = a[i - 1] + underlyingEl;
                    int previous = ways[i - 1][j];

                    int max = currentEl > previous ? currentEl : previous;
                    ways[i][j] = max;

                } else {
                    ways[i][j] = ways[i-1][j];
                }
            }

        }


        return ways[a.length][sum - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int sum = sc.nextInt();

            int[] values = new int[n];

            for (int j = 0; j < n; j++) {
                values[j] = sc.nextInt();
            }

            int result = calculateKnapsack(values, sum);

            System.out.println(result);
        }
    }
}
