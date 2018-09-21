package com.alexbzmn;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Palindrome {

    public static void main(String[] args) {
        System.out.println(getLongestPalindromeFromString("abcdd"));
        System.out.println(getLongestPalindromeFromString(""));
        System.out.println(getLongestPalindromeFromString("a"));
        System.out.println(getLongestPalindromeFromString("null"));
        System.out.println(getLongestPalindromeFromString(null));
        System.out.println(getLongestPalindromeFromString("erererererererererere"));
        System.out.println(getLongestPalindromeFromString("Rdeder"));

    }

    private static String getLongestPalindromeFromString(String value) {
        if (value == null || value.length() == 0) {
            return null;
        }

        String[] strings = value.split("");

        Map<String, Integer> counts = new HashMap<>();

        Arrays.stream(strings).forEach(x -> {
            if (counts.containsKey(x)) {
                counts.put(x, counts.get(x) + 1);
            } else {
                counts.put(x, 1);
            }
        });

        StringBuilder builder = new StringBuilder();
        counts.entrySet().stream().filter(stringIntegerEntry -> stringIntegerEntry.getValue() > 1)
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder())).forEach(entry -> {
            String letter = entry.getKey();
            Integer occurrenceCount = entry.getValue();

            if (occurrenceCount % 2 == 0) {
                appendNElements(builder, letter, occurrenceCount / 2);
            } else {
                appendNElements(builder, letter, (occurrenceCount - 1) / 2);
            }
        });

        counts.entrySet().stream().filter(entry -> entry.getValue() == 1).findAny().ifPresent(x -> builder.append(x.getKey()));
        return builder.substring(0, builder.length() - 1) + builder.reverse().
                toString();
    }

    private static void appendNElements(StringBuilder stringBuilder, String value, Integer n) {
        for (int i = 0; i < n; i++) {
            stringBuilder.append(value);
        }
    }
}
