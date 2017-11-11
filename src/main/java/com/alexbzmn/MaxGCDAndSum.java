package com.alexbzmn;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Aleksei Batcman <aleksei.batcman@wirecard.com>
 * @since 18.07.2017
 */
//For all those who got tc 3,5,7 as WA check for these inputs a) 3 1 3 5 2 7 11 output:16 b)3 8 5 9 10 11 13 output:15
public class MaxGCDAndSum {

    static int maximumGcdAndSum(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);


        int maxGcd = 0;
        int maxSum = 0;

        for (int i = A.length - 1; i >= 0; i--) {
            int index = Arrays.binarySearch(B, A[i]);
            if (index >= 0) {
                maxGcd = A[i];
                break;
            }
        }

        for (int i = A.length - 1; i >= 0; i--) {
            if (A[i] < maxGcd) {
                break;
            }

            for (int j = B.length - 1; j >= 0; j--) {

                if (B[j] < maxGcd) {
                    break;
                }

                int gcd = gcd(A[i], B[j], maxGcd);
                if (gcd >= maxGcd) {

                    int sum = A[i] + B[j];
                    if (gcd > maxGcd) {
                        maxSum = sum;
                    } else if (gcd == maxGcd) {
                        if (sum > maxSum) {
                            maxSum = sum;
                        }
                    }
                    maxGcd = gcd;
                }

            }
        }

        return maxSum;
    }

    private static int gcd(int x, int y, int maxGcd) {
        if (y == 0) {
            return x;
        }

        if (y < maxGcd) {
            return 0;
        }

        return gcd(y, x % y, maxGcd);
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
