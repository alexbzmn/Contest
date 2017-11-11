package com.alexbzmn;

//taken from http://www.geeksforgeeks.org/summation-gcd-pairs-n/
public class Totient {

    private static int MAX = 100000;


    private static long[] totient() {
        long[] phi = new long[MAX];

        for (int i = 2; i < MAX; i++) {
            if (phi[i] == 0) {
                phi[i] = i - 1;

                for (int j = (i << 1); j < MAX; j += i) {
                    if (phi[j] == 0) {
                        phi[j] = j;
                    }

                    phi[j] = (phi[j] / i) * (i - 1);
                }
            }
        }

        return phi;
    }

    static void sumOfGcdPairs() {
        long[] phi = totient();
        long[] result = new long[MAX];

        for (int i = 1; i < MAX; ++i) {
            // Iterate throght all the divisors
            // of i.
            for (int j = 2; i * j < MAX; ++j)
                result[i * j] += i * phi[j];
        }

        // Add summation of previous calculated sum
        for (int i = 2; i < MAX; i++)
            result[i] += result[i - 1];

        System.out.println();
    }

    public static void main(String[] args) {
        sumOfGcdPairs();
    }
}
