package com.alexbzmn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                int idx = Arrays.binarySearch(nums, -sum);
                if (idx == i || idx == j) {
                    if (idx == i) {
                    }
                }
                if (idx != -1) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[idx]);

                    res.add(list);
                }
            }
        }

        return res;
    }

    /*
    private int binarySearch (int i, int j, int sum, int[] nums) {
        int midIdx = nums.length / 2;
        int mid = nums[midIdx];
        if (mid > sum) {
            int[] left = new int[midIdx];
            System.arraycopy(nums, 0, left, 0, midIdx);
            return binarySearch(i, j, sum, left)
        }
    }

    */

}
