package com.alexbzmn;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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


    public List<String> letterCombinations(String digits) {
        Map<Integer, List<Character>> mapping = new HashMap<>();
        mapping.put(2, Stream.of('a', 'b', 'c').collect(Collectors.toList()));
        mapping.put(3, Stream.of('d', 'e', 'f').collect(Collectors.toList()));
        mapping.put(4, Stream.of('g', 'h', 'i').collect(Collectors.toList()));
        mapping.put(5, Stream.of('j', 'k', 'l').collect(Collectors.toList()));
        mapping.put(6, Stream.of('m', 'n', 'o').collect(Collectors.toList()));
        mapping.put(7, Stream.of('p', 'q', 'r', 's').collect(Collectors.toList()));
        mapping.put(8, Stream.of('t', 'u', 'v').collect(Collectors.toList()));
        mapping.put(9, Stream.of('w', 'x', 'y', 'z').collect(Collectors.toList()));

        List<String> combinations = new LinkedList<>();
        int[] d = Arrays.stream(digits.split("")).mapToInt(Integer::parseInt).toArray();

        return combinations;
    }
}
