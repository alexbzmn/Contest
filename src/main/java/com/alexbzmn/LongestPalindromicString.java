package com.alexbzmn;

public class LongestPalindromicString {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("abbbakkttkk"));
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome("bb"));
    }

    public static String longestPalindrome(String s) {

        int maxLength = 1;
        int start = 0;
        int len = s.length();

        if (len == 0) {
            return s;
        }

        for (int i = 1; i < len; ++i) {

            int low = i - 1;
            int high = i;

            while (low >= 0 && high < len && s.charAt(low) == s.charAt(high)) {
                if ((high - low + 1) > maxLength) {
                    start = low;
                    maxLength = high - low + 1;
                }
                high++;
                low--;
            }

            low = i - 1;
            high = i + 1;
            while (low >= 0 && high < len && s.charAt(low) == s.charAt(high)) {
                if ((high - low + 1) > maxLength) {
                    start = low;
                    maxLength = high - low + 1;
                }
                high++;
                low--;
            }
        }

        return s.substring(start, start + maxLength);
    }
}
