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
        int endInd = (n - (k % n)) - 1;

        int[] newArr = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            newArr[endInd--] = a[i];

            if (endInd < 0) {
                endInd = n - 1;
            }
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
