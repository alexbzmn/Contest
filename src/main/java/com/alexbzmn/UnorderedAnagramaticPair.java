package com.alexbzmn;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UnorderedAnagramaticPair {
    public static int sherlockAndAnagrams(String s) {
        int count = 0;

        for (int substringLength = 1; substringLength <= s.length(); substringLength++) {
            Map<Map<Character, Integer>, Integer> substringsCounts = new HashMap<>();

            for (int index = 0; index <= s.length() - substringLength; index++) {

                String substring = s.substring(index, index + substringLength);

                Map<Character, Integer> characterCounts = getCharacterCounts(substring);

                Integer substringCounts = substringsCounts.get(characterCounts);

                if (substringCounts == null) {
                    substringsCounts.put(characterCounts, 1);
                } else {
                    count += substringCounts;
                    substringsCounts.put(characterCounts, substringCounts + 1);
                }
            }

        }

        return count;
    }

    public static Map<Character, Integer> getCharacterCounts(String s) {
        Map<Character, Integer> characterCounts = new HashMap<>();

        for (char c : s.toCharArray()) {
            Integer characterCount = characterCounts.get(c);
            if (characterCount == null) {
                characterCounts.put(c, 1);
            } else {
                characterCounts.put(c, characterCount + 1);
            }
        }

        return characterCounts;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int a0 = 0; a0 < q; a0++) {
            String s = in.next();
            int result = sherlockAndAnagrams(s);
            System.out.println(result);
        }
    }
}
