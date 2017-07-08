package com.alexbzmn;

import java.util.Scanner;

/**
 * Created by User on 7/8/2017.
 */
public class Primality {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        for (int a0 = 0; a0 < p; a0++) {
            int n = in.nextInt();
            boolean isNotPrime = false;
            for (int del = n - 1; del > 1; del--) {
                if (n % del == 0) {
                    isNotPrime = true;
                    break;
                }

            }

            if (n == 1) {
                isNotPrime = true;
            }

            System.out.println(isNotPrime ? "Not prime" : "Prime");

        }

    }

}
