package com.alexbzmn;

public class DivideIntegers {
    public static void main(String[] args) {
        new DivideIntegers().divide(-2147483648, 2);
    }

    public int divide(int dividend, int divisor) {

        boolean isNegative = false;
        if (dividend < 0 && divisor < 0) {
            isNegative = false;
        } else if (dividend < 0 || divisor < 0) {
            isNegative = true;
        }

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        if (dividend == Integer.MIN_VALUE && divisor == 1) {
            return Integer.MIN_VALUE;
        }

        int s = Math.abs(dividend);
        int c = 0;
        int div = Math.abs(divisor);

        if (s >= 0) {
            while (s >= div) {
                s -= div;
                c++;
            }
        } else {
            div = div > 0 ? -div : div;
            while (s <= div) {
                s -= div;
                c++;
            }
        }

        return isNegative ? -c : c;
    }
}
