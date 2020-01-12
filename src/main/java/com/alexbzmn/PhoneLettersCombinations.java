package com.alexbzmn;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PhoneLettersCombinations {
    public static void main(String[] args) {
        System.out.println(new PhoneLettersCombinations().letterCombinations("2379"));
    }

    public List<String> letterCombinations(String digits) {
        String[] mapping = {"", "abc", "def", "ghi", "jkf", "mno", "pqrs", "tuv", "wxyz"};
        int[] numbers = new int[digits.length()];

        for (int i = 0; i < digits.length(); i++) {
            numbers[i] = Integer.parseInt("" + digits.charAt(i));
        }

        return createCombinations(mapping, numbers);
    }

    private List<String> createCombinations(String[] mapping, int[] numbers) {

        Queue<String> q = new LinkedList<>();
        q.add("");

        while (!q.isEmpty()) {

        }


        return null;
    }

}
