package com.alexbzmn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Subsets {

    public static void main(String[] args) {
        System.out.println(new Subsets().subsetsB(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        for (int i = 0; i < nums.length; i++) {
            int l = res.size();
            for (int j = 0; j < l; j++) {
                List<Integer> temp = new ArrayList<>(res.get(j));
                temp.add(nums[i]);
                res.add(temp);
            }

        }
        return res;
    }

    public void backTrack(int l, int h, List<Integer> curr, List<List<Integer>> res, int[] nums) {
        if (curr.size() == h) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = l; i < nums.length; i++) {
            curr.add(nums[i]);

            backTrack(i + 1, h, curr, res, nums);

            curr.remove(curr.size() - 1);
        }


    }

    public List<List<Integer>> subsetsB(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i <= nums.length; i++) {
            backTrack(0, i, new ArrayList<Integer>(), res, nums);
        }

        return res;
    }

}
