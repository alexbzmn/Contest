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


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(fibonacci(n));
    }
}
