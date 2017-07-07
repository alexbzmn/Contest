package com.alexbzmn;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by User on 7/6/2017.
 */
public class ArrayRotation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            int newIndex = (a_i + (n - k)) % n;
            a[newIndex] = in.nextInt();
        }

        for (int i : a) {
            System.out.print(i + " ");
        }

    }
}
