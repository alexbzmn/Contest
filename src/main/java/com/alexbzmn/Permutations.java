package com.alexbzmn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {

    public static void main(String[] args) {
        System.out.println(new Permutations().permute(new int[] {1, 2, 3, 4}));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        permute(list, nums, 0);
        return list;
    }

    private void permute(List<List<Integer>> list, int[] nums, int l) {
        if (l == nums.length - 1) {
            list.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }

        for (int i = l; i < nums.length; i++) {
            int[] copy = Arrays.copyOf(nums, nums.length);

            int b = copy[i];
            copy[i] = copy[l];
            copy[l] = b;
            permute(list, copy, l + 1);
        }
    }
}
