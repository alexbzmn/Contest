package com.alexbzmn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MergeSort {

    private static long inversionCount = 0;

    public static void main(String[] args) {
        int[] a = {6, 4, 2, 7, 3, -1, 0, 2}; //-1 0 2 2 3 4 6 7

        sortTwo(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }


    private static void insertionSort(int[] a) {

        for (int i = 1; i < a.length; i++) {
            int j = i;

            while (j > 0 && a[j] < a[j - 1]) {
                int b = a[j];
                a[j] = a[j - 1];
                a[j - 1] = b;

                j--;
            }
        }

    }


//    public static void main(String[] args) throws Exception {
//        long s = System.currentTimeMillis();
//
//        Scanner in = new Scanner(new File("files/MSINVIN.txt"));
//        int t = in.nextInt();
//        for (int a0 = 0; a0 < t; a0++) {
//            int n = in.nextInt();
//            int arr[] = new int[n];
//            for (int arr_i = 0; arr_i < n; arr_i++) {
//                arr[arr_i] = in.nextInt();
//            }
//            System.out.println(countInversions(arr));
//        }
//
//        long f = System.currentTimeMillis();
//
//        System.out.println(f - s);
//    }

    public static long countInversions(int[] arr) {
        inversionCount = 0;
        sort(0, arr.length - 1, arr);
        return inversionCount;
    }

    private static void sortTwo(int[] a, int l, int r) {
        if (l == r) {
            return;
        }

        int m = (l + r) / 2;
        sortTwo(a, l, m);
        sortTwo(a, m + 1, r);

        int[] copy = new int[r - l + 1];
        System.arraycopy(a, l, copy, 0, r - l + 1);

        int j = l;
        int k = m + 1;

        int i = l;

        while (j <= m || k <= r) {
            if (k <= r - l && copy[j - l] <= copy[k - l]) {
                a[i] = copy[j - l];
                j++;
                i++;
            } else if (k <= r - l && copy[j - l] > copy[k - l]) {
                a[i] = copy[k - l];
                k++;
                i++;
            } else {
                a[i] = copy[j - l];
                j++;
                i++;
            }
        }
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
