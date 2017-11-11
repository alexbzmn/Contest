package com.alexbzmn;

import java.util.Arrays;

/**
 * Created by User on 7/9/2017.
 */
public class QuickSort {
    public static void main(String[] args) {
//        int[] a = new int[]{1, 3, 9, 8, 2, 7, 5};
        int[] a = new int[]{9, 8, 6, 7, 3, 5, 4, 1, 2};
//        Random r = new Random();
//        a = r.ints(30, -10000, 10000).toArray();
        int n = a.length;

        quicksort(0, n - 1, a);
    }

    private static void sort(int[] a, int start, int finish) {
        if (start >= finish) {
            return;
        }

        int pivot = a[finish];

        int k = start;
        int l = finish - 1;

        while (k < l) {
            while (a[k] <= pivot && k != l) {
                k++;
            }

            while (a[l] > pivot && l != k) {
                l--;
            }

            if (k != l) {
                int buf = a[k];
                a[k] = a[l];
                a[l] = buf;
            }

        }

        if (pivot < a[k]) {
            a[finish] = a[k];
            a[k] = pivot;
        }

        sort(a, start, k);
        sort(a, k + 1, finish);
    }

    /**
     * impl from http://www.vogella.com/tutorials/JavaAlgorithmsQuicksort/article.html
     *
     * @param low  start
     * @param high end
     * @param a    array
     */
    private static void quicksort(int low, int high, int[] a) {
        int i = low, j = high;
        // Get the pivot element from the middle of the list
        int pivot = a[low + (high - low) / 2];

        // Divide into two lists
        while (i <= j) {
            // If the current value from the left list is smaller than the pivot
            // element then get the next element from the left list
            while (a[i] < pivot) {
                i++;
            }
            // If the current value from the right list is larger than the pivot
            // element then get the next element from the right list
            while (a[j] > pivot) {
                j--;
            }

            // If we have found a value in the left list which is larger than
            // the pivot element and if we have found a value in the right list
            // which is smaller than the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            if (i <= j) {
                int buf = a[i];
                a[i] = a[j];
                a[j] = buf;

                i++;
                j--;
            }
        }
        // Recursion
        if (low < j) {
            quicksort(low, j, a);
            System.out.println(Arrays.toString(a));
        }
        if (i < high) {
            System.out.println(Arrays.toString(a));
            quicksort(i, high, a);
        }

    }
}
