package com.alexbzmn;

public class InterativePow {
    public static void main(String[] args) {

        System.out.println(pow(2, 4));
        System.out.println(pow(2, 4));

        System.out.println(mult(2, 8));
        System.out.println(mult(4, 8));
        System.out.println(mult(1000, 1000));
    }

    private static int pow(int x, int y) {
        int res = 1;
        while (y > 0) {
            if ((y & 1) == 1) {
                return x;
            }

            y = y >> 1;
            x = mult(x, x);
        }

        return res;
    }

    private static int mult(int x, int y) {
        return mult(x + x, x, y - 1);
    }

    private static int mult(int x, int a, int y) {
        if (y == 1) {
            return x;
        }
        return mult(x + a, a, y - 1);
    }
}
