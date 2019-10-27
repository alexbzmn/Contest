package com.alexbzmn;

import java.util.HashMap;
import java.util.Map;

public class MaxSliceSum {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abba"));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bb"));
    }

    public static int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> map = new HashMap<>();

        int count = 0;
        int max = 0;
        int lastRemove = -1;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {

            if (map.containsKey(chars[i])) {
                if (map.get(chars[i]) > lastRemove) {
                    max = Math.max(max, count);
                    count = i - (map.get(chars[i]) + 1);
                    lastRemove = map.get(chars[i]);
                }
            }

            map.put(chars[i], i);
            count++;
        }

        max = Math.max(max, count);

        return max;

    }


}
