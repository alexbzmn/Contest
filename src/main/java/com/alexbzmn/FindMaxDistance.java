package com.alexbzmn;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.max;

public class FindMaxDistance {

    public static void main(String[] args) {
        int[] A = {8, 2, 4, 20, 5, 8, 0, 3, 8, 2};

        printTripletSum(A, 33);

    }

    private static void printTripletSum(int[] A, int x) {

        if (A == null || A.length < 3) {
            return;
        }

        Arrays.sort(A);

        mainLoop:
        for (int i = 0; i < A.length - 2; i++) {

            int l = i + 1;
            int r = A.length - 1;

            while (l < r) {
                if (A[l] + A[r] + A[i] == x) {
                    System.out.println(MessageFormat.format("{0} {1} {2}", A[l], A[r], A[i]));
                    break mainLoop;
                } else if (A[l] + A[r] + A[i] < x) {
                    l++;
                } else {
                    r++;
                }
            }
        }
    }

    private static void distance(int[] A) {
        int j = 0;
        int result = 0;

        for (int i = 1; i < A.length; i++) {
            int total = A[i] + i + A[j] - j;

            result = max(result, total);
            if (A[i] - i > A[j] - j) {
                j = i;
            }
        }
        System.out.println(result);
    }

    private static void findSumUnsorted(int x, int[] A) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i : A) {
            if (map.containsKey(i)) {
                System.out.println(map.get(i) + " " + i);
                break;
            } else {
                map.put(x - i, i);
            }
        }

    }

}
