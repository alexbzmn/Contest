package com.alexbzmn;

import java.util.Scanner;

/**
 * Created by User on 7/8/2017.
 */
public class Fibonacci {
    public static int fibonacci(int n) {
        if (n < 0) {
            return 0;
        }

        if (n == 0 || n == 1) {
            return n;
        }

        return fibonacci(n - 2) + fibonacci(n - 1);
    }

    public static int fibonacciD(int n) {
        int[] memo = new int[n];
        memo[0] = 1;
        memo[1] = 1;
        memo[2] = 2;

        for (int i = 3; i < memo.length; i++) {
            memo[i] += memo[i-1] + memo[i-2];
        }

        return memo[n - 1];
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(fibonacciD(n));
    }
}
