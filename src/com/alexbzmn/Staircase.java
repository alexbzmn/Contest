package com.alexbzmn;

import java.util.Scanner;

/**
 * Created by User on 7/8/2017.
 */
public class Staircase {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        for (int a0 = 0; a0 < s; a0++) {
            int n = in.nextInt();
            System.out.println(countWays(n));
        }
    }

    private static int countWays(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        if (n >= 3) {
            return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
        }

        return 0;
    }

    private static int countWaysDPNoRec(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        if (n == 3) {
            return 4;
        }

        int[] a = new int[n];
        a[0] = 1;
        a[1] = 2;
        a[2] = 4;

        for (int i = 3; i < n; i++) {
            a[i] = a[i - 1] + a[i - 2] + a[i - 3];
        }

        return a[a.length - 1];
    }

}
