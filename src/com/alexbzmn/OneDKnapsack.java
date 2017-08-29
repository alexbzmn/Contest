package com.alexbzmn;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class OneDKnapsack {
    private static int calculateKnapsack(int[] a, int sum) {
        int ways[] = new int[sum + 1];
        ways[0] = 1;

        for (int weight : a) {
            for (int i = weight; i < ways.length; i++) {
                ways[i] += ways[i - weight];
            }
        }

        int max = 0;

        for (int i = sum; i >= 0; i--) {
            int val = ways[i];

            if (val > 0 && i > max) {
                max = i;
            }

            if (i < max) {
                break;
            }
        }

        return max;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("files/KNAPSACKIN"));

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
