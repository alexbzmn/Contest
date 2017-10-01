package com.alexbzmn;

import java.util.Arrays;

public class KthSmallest {

    public static void main(String[] args) {

        int[] arr = new int[]{7, -7, 10, 20, 4, 3, -5, 20, 15, -7};
//        int[] arr = new int[]{7, 10, 4, 3, 20, 15};


        int res = findKthSmallest(3, arr, 0, arr.length - 1);
        System.out.println(res);

        System.out.println(Arrays.toString(arr));


    }

    private static int findKthSmallest(int k, int[] a, int start, int finish) {

        if (start >= finish || a == null) {
            return -1;
        }

        int pivot = finish;

        int l = start;
        int r = finish - 1;

        while (r > l) {

            while (a[l] < a[pivot] && l < finish) {
                l++;
            }

            while (a[r] >= a[pivot] && r > l) {
                r--;
            }


            if (r > l) {

                int buf = a[l];
                a[l] = a[r];
                a[r] = buf;

            }
        }


        if (pivot > l && a[pivot] < a[l]) {

            int buf = a[l];
            a[l] = a[pivot];
            a[pivot] = buf;

            if (l == k) {
                return a[l];
            }

        }

        if (pivot == 3) {
            return a[pivot];
        }

        if (l > k) {
            return findKthSmallest(k, a, start, l - 1);
        } else {
            return findKthSmallest(k, a, l + 1, finish);
        }

    }

}
