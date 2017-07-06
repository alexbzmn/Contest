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
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }

        int ind = 0;
        while(k >= 0) {
            if (ind < 0) {
                ind = n - 1;
            } else {
                ind--;
            }
            k--;
        }

        int[] newArr = new int[n];
        for (int i = 0; i < n; i++) {
            if (ind == n) {
                ind = 0;
            }

            newArr[ind++] = a[i];

        }

        System.out.println(
                Arrays
                        .stream(newArr)
                        .mapToObj(String::valueOf)
                        .reduce("", (s, s2) -> s + " " + s2)
                        .replaceFirst(" ", "")
        );
    }
}
