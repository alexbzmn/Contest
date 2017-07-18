package com.alexbzmn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Aleksei Batcman <aleksei.batcman@wirecard.com>
 * @since 18.07.2017
 */
//For all those who got tc 3,5,7 as WA check for these inputs a) 3 1 3 5 2 7 11 output:16 b)3 8 5 9 10 11 13 output:18
public class MaxGCDAndSum {
    static int maximumGcdAndSum(int[] A, int[] B) {
        Map<String, Integer> gcdMap = new HashMap<>();
        Set<Integer> aSet = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int first;
                int second;
                if (A[i] < B[j]) {
                    first = A[i];
                    second = B[j];
                } else {
                    first = B[j];
                    second = A[i];
                }

                gcdMap.put(first + "," + second, gcd(first, second));
            }
        }

        int[] maxPair = new int[3];

        for (Entry<String, Integer> entry : gcdMap.entrySet()) {
            if (entry.getValue() > maxPair[2]) {
                String[] key = entry.getKey().split(",");
                maxPair[0] = Integer.valueOf(key[0]);
                maxPair[1] = Integer.valueOf(key[1]);
                maxPair[2] = entry.getValue();
            }
        }

        int maxSum = 0;
        for (Entry<String, Integer> entry : gcdMap.entrySet()) {
            if (entry.getValue() == maxPair[2]) {
                String[] key = entry.getKey().split(",");
                int first = Integer.valueOf(key[0]);
                int second = Integer.valueOf(key[1]);
                int sum = first + second;

                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }

        return maxSum;
    }

    private static int gcd(int x, int y) {
        if (y == 0) {
            return x;
        }

        return gcd(y, x % y);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] A = new int[n];
        for (int A_i = 0; A_i < n; A_i++) {
            A[A_i] = in.nextInt();
        }
        int[] B = new int[n];
        for (int B_i = 0; B_i < n; B_i++) {
            B[B_i] = in.nextInt();
        }
        int res = maximumGcdAndSum(A, B);
        System.out.println(res);
    }
}
