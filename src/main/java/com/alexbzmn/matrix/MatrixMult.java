package com.alexbzmn.matrix;

import org.apache.commons.lang3.time.StopWatch;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MatrixMult {

    public static void main(String[] args) {

        StopWatch stopWatch = StopWatch.createStarted();

        int dimensionSize = 32768;
        for (int i = 2; i <= dimensionSize; i *= i) {
            for (int j = 2; j <= dimensionSize; j *= j) {
                double[][] a = random(i, j);
                double[][] b = random(j, i);

                double[][] expected = PrincetonMatrix.multiply(a, b);
                double[][] actual = naiveMult(a, b);

                assertEqual(expected, actual);
            }
        }


        System.out.println(stopWatch.getTime(TimeUnit.MILLISECONDS));
    }

    private static void printMatrix(double[][] matrix) {
        Arrays.stream(matrix).forEach(doubles -> System.out.println(Arrays.toString(doubles)));
    }

    private static void assertEqual(double[][] expected, double[][] actual) {
        int x = expected.length;
        int y = expected[0].length;

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (expected[i][j] != actual[i][j]) {
                    throw new AssertionError();
                }
            }
        }
    }

    private static double[][] random(int x, int y) {
        double[][] res = new double[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                res[i][j] = new Random().nextInt(1000);
            }
        }

        return res;
    }

    private static double[][] naiveMult(double[][] a, double[][] b) {
        int n = a.length;
        int m = a[0].length;
        int p = b[0].length;

        double[][] res = new double[n][p];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < p; k++) {
                    res[i][k] += a[i][j] * b[j][k];
                }
            }
        }

        return res;
    }
}
