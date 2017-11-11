package com.alexbzmn;

import java.util.Scanner;

/**
 * @author Aleksei Batcman <aleksei.batcman@wirecard.com>
 * @since 17.07.2017
 */
public class OnceInATram {
    static private String onceInATram(int x) {
        while (true) {
            int[] a = getArray(++x);

            int first = a[0] + a[1] + a[2];
            int second = a[3] + a[4] + a[5];

            if (first == second) {
                return String.valueOf(x);
            }
        }
    }

    private static int[] getArray(int x) {
        String s = String.valueOf(x);
        String[] arr = s.split("");

        int[] a = new int[arr.length];
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.valueOf(arr[i]);
        }

        return a;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        String result = onceInATram(x);
        System.out.println(result);
    }
}
