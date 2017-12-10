package com.alexbzmn;

import java.util.Scanner;

public class SieveEratosthenes {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t  = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            System.out.println(findPrime(n + 1));
        }
    }

    private static String findPrime(int n) {
        boolean[] sieve = new boolean[n];
        for (int p = 2; p < n; p++) {
            for (int i = 2; i < n; i++) {
                int mult = i * p;
                if (mult > n - 1) {
                    break;
                }
                sieve[mult] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < n; i++) {
            if (!sieve[i]) {
                sb.append(i + " ");
            }
        }

        return sb.toString();
    }
}
