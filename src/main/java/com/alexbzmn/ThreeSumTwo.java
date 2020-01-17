package com.alexbzmn;

import java.util.*;

public class ThreeSumTwo {

    public static void main(String[] args) {
        System.out.println(new ThreeSumTwo().threeSum(new int[]{-4, -1, -1, 0, 1, 2}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return Collections.emptyList();
        }

        Set<List<Integer>> set = new HashSet<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            int l = i + 1;
            int r = nums.length - 1;

            while (l < r && r > i) {
                if (l == i) {
                    l++;
                    continue;
                }

                if (nums[l] + nums[i] + nums[r] == 0) {
                    if (nums[l] <= nums[i]) {
                        set.add(Arrays.asList(nums[l], nums[i], nums[r]));
                    } else {
                        set.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    }

                    l++;
                    continue;
                }

                if (nums[l] + nums[i] + nums[r] < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }

        return new ArrayList<List<Integer>>(set);
    }
}
