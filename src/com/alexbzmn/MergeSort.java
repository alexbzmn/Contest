package com.alexbzmn;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class MergeSort {

    private static long inversionCount = 0;

//    public static void main(String[] args) {
////        int[] a = {6, 4, 2, 7, 3, -1, 0, 2}; //-1 0 2 2 3 4 6 7
//        long s = System.currentTimeMillis();
//
//        int[] a = new Random().ints(1000000, -1000, 1000).toArray();
////        System.out.println(Arrays.toString(a));
//
//        sort(a);
//
////        Arrays.sort(a);
//
//        for (int i = 1; i < a.length; i++) {
//
//            if (a[i] < a[i - 1]) {
//                System.out.println("Assertion failed");
//            }
//        }
//
////        System.out.println(Arrays.toString(a));
//
//        long f = System.currentTimeMillis();
//
//        System.out.println("TIME: " + (f - s));
//    }


    public static void main(String[] args) throws Exception {
        long s = System.currentTimeMillis();

        Scanner in = new Scanner(new File("files/MSINVIN.txt"));
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            int arr[] = new int[n];
            for (int arr_i = 0; arr_i < n; arr_i++) {
                arr[arr_i] = in.nextInt();
            }
            System.out.println(countInversions(arr));
        }

        long f = System.currentTimeMillis();

        System.out.println(f - s);
    }

    public static long countInversions(int[] arr) {
        inversionCount = 0;
        sort(0, arr.length - 1, arr);
        return inversionCount;
    }

    private static void sort(int[] arr) {
        sort(0, arr.length - 1, arr);
    }

    private static void sort(int start, int finish, int[] a) {

        if (start >= finish) {
            return;
        }

        int m = start + (finish - start) / 2;

        sort(start, m, a);
        sort(m + 1, finish, a);

        merge(start, m, finish, a);
    }

    private static void merge(int start, int m, int finish, int[] a) {

        int l = start;
        int k = m + 1;

//        int[] copy = new int[finish - start];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = start; i <= finish; i++) {
            map.put(i, a[i]);
        }

//        System.arraycopy(a, start, copy, start, finish - start);

        for (int i = start; i <= finish; i++) {

            if (k > finish || (l <= m && map.get(l) <= map.get(k))) {
                a[i] = map.get(l);
                l++;
            } else if (k <= finish && map.get(k) < map.get(l)) {
                inversionCount += k - i;
                a[i] = map.get(k);
                k++;
            } else if (l > m) {
                inversionCount += k - i;
                a[i] = map.get(k);
                k++;
            } else {
                a[i] = map.get(l);
                l++;
            }

        }

    }
}
