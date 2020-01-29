package com.alexbzmn;

public class MyPow {
    public static void main(String[] args) {
        System.out.println(new MyPow().myPowNestedNeg(1.0 / 2, -3));
        System.out.println(new MyPow().myPow(2, 10));
    }

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            return myPowNestedNeg(1 / x, n);
        }

        return myPowNested(x, n);
    }

    public double myPowNestedNeg(double x, int n) {
        double res = 1;

        while (n < 0) {
            if ((n & 1) == 1) {
                res = res * x;
            }

            n = n / 2;
            x = x * x;
        }

        return res;
    }

    public double myPowNested(double x, int n) {
        double res = 1;

        //r = 1  1  4  4   1024
        //n = 10 5  2  1   0
        //x = 2  4  16 256 65536

        while (n > 0) {
            if ((n & 1) == 1) {
                res = res * x;
            }

            n = n >> 1;
            x = x * x;
        }

        return res;
    }
}
