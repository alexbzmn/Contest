package com.alexbzmn;

public class ModularExp {
    public static void main(String[] args) {

        int p = 5;
        int x = 2 % p;
        int y = 3;

        int res = 1;
        while (y > 0) {
            if ((y & 1) == 1) {
                res = (res * x) % p;
            }

            y = y >> 1;
            x = (x * x) % p;
        }

        System.out.println(res);
    }
}
