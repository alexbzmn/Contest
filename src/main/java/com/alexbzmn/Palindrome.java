package com.alexbzmn;

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
        System.out.println(getLongestPalindromeFromString("aaa"));
        System.out.println(getLongestPalindromeFromString("aaabbb"));
        System.out.println(getLongestPalindromeFromString("aaaabbbb"));
    }

    private static String getLongestPalindromeFromString(String value) {
        if (value == null || value.length() == 0) {
            return null;
        }

        String[] strings = value.split("");

        Map<String, Integer> counts = new HashMap<>();

        for (String letter : strings) {
            if (counts.containsKey(letter)) {
                counts.put(letter, counts.get(letter) + 1);
            } else {
                counts.put(letter, 1);
            }
        }

        if (counts.size() == 1) {
            return value;
        }

        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, Integer> stringIntegerEntry : counts.entrySet()) {
            if (stringIntegerEntry.getValue() > 1) {
                String letter = stringIntegerEntry.getKey();
                Integer occurrenceCount = stringIntegerEntry.getValue();

                if (occurrenceCount % 2 == 0) {
                    appendNElements(builder, letter, occurrenceCount / 2);
                } else {
                    appendNElements(builder, letter, (occurrenceCount - 1) / 2);
                }
            }
        }

        boolean singleAppended = false;
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            if (entry.getValue() == 1) {
                builder.append(entry.getKey());
                singleAppended = true;
                break;
            }
        }
        if (!singleAppended) {
            return builder.toString() + builder.reverse().toString();
        } else {
            return builder.substring(0, builder.length() - 1) + builder.reverse().
                    toString();
        }

    }

    private static void appendNElements(StringBuilder stringBuilder, String value, Integer n) {
        for (int i = 0; i < n; i++) {
            stringBuilder.append(value);
        }
    }
}
