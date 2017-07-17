package com.alexbzmn;

/**
 * Created by User on 7/17/2017.
 */
public class GCD {

    private static int gcd(int x, int y) {
        if (y == 0) {
            return x;
        }

        return gcd(y, x % y);
    }

    public static void main(String[] args) {
        System.out.println(gcd(48, 18));
        System.out.println(gcd(54, 24));
    }
}
