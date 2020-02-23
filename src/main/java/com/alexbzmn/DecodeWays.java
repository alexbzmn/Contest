package com.alexbzmn;

import java.util.HashSet;
import java.util.Set;

public class DecodeWays {
    public static void main(String[] args) {
//        System.out.println(new DecodeWays().numDecodings("123456789121"));
//        System.out.println(countDecoding("123456789121".toCharArray(), "123456789121".length()));
        System.out.println(countDecoding("121212121212".toCharArray(), "121212121212".length()));
//        System.out.println(countDecoding("123".toCharArray(), "123".length()));
    }

    public int numDecodings(String s) {
        Set<Integer> m = new HashSet<>();
        for (int i = 1; i <= 26; i++) {
            m.add(i);
        }

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i + 2 >= s.length()) {
                count = count + parseShort(s, m, i);
                break;
            }
            int a = parse(s, i, i);
            int b = parse(s, i + 1, i + 1);
            int c = parse(s, i + 2, i + 2);
            int ab = parse(s, i, i + 1);
            int bc = parse(s, i + 1, i + 2);

            if (m.contains(a) || m.contains(b) || m.contains(c)) {
                count++;
            }

            if (m.contains(a) && m.contains(bc)) {
                count++;
            }

            if (m.contains(ab) && m.contains(c)) {
                count++;
            }
        }


        return count;
    }

    private int parseShort(String s, Set<Integer> m, int i) {
        int count = 0;
        if (s.length() - i == 1 && m.contains(parse(s, i, i))) {
            count = 1;
        } else if (s.length() - i == 2) {
            if (m.contains(parse(s, i, i)) || m.contains((parse(s, i + 1, i + 1)))) {
                count++;
            }

            if (m.contains(parse(s, i, i + 1))) {
                count++;
            }
        }

        return count;
    }

    private int parse(String s, int l, int h) {
        if (l == h) {
            return s.charAt(l) - '0';
        }

        return Integer.parseInt(s.substring(l, h + 1));
    }

    static int countDecoding(char[] digits, int n) {
        // base cases
        if (n == 0 || n == 1)
            return 1;

        // Initialize count
        int count = 0;

        // If the last digit is not 0, then
        // last digit must add to
        // the number of words
        if (digits[n - 1] > '0')
            count = countDecoding(digits, n - 1);

        // If the last two digits form a number
        // smaller than or equal to 26,
        // then consider last two digits and recur
        if (digits[n - 2] == '1' ||
                (digits[n - 2] == '2' && digits[n - 1] < '7'))
            count += countDecoding(digits, n - 2);

        return count;
    }
}
