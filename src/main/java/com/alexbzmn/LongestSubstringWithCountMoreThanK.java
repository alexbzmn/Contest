package com.alexbzmn;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithCountMoreThanK {

	public static void main(String[] args) {

		System.out.println(new LongestSubstringWithCountMoreThanK().longestSubstring("ababbbcx", 3));
		System.out.println(new LongestSubstringWithCountMoreThanK().longestSubstring("ababbc", 2));
		System.out.println(new LongestSubstringWithCountMoreThanK().longestSubstring("aaab", 3));
		System.out.println(new LongestSubstringWithCountMoreThanK().longestSubstring("abb", 3));
		System.out.println(new LongestSubstringWithCountMoreThanK().longestSubstring("abb", 2));
		System.out.println(new LongestSubstringWithCountMoreThanK().longestSubstring("a", 2));
		System.out.println(new LongestSubstringWithCountMoreThanK().longestSubstring("", 2));
		System.out.println(new LongestSubstringWithCountMoreThanK().longestSubstring("aaaaaaaaaaaaaabbbbbbbbbbbbbbbbbccccxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx", 5));
	}

	public int longestSubstring(String s, int k) {

		//for h unique chars that are repeating no less than k, calculate width of the window

		int maxLen = 0;
		char[] chars = s.toCharArray();

		for (int h = 1; h <= 26; h++) {
			int i = 0;
			int j = 0;
			int mk = 0;
			int[] c = new int[26];
			int unique = 0;

			while (i < chars.length) {

				if (unique <= h) {
					int idx = chars[i] - 'a';

					if (c[idx] == 0) {
						unique++;
					}

					c[idx]++;
					i++;

					if (c[idx] == k) {
						mk++;
					}

				} else {
					int idx = chars[j] - 'a';

					if (c[idx] == k) {
						mk--;
					}

					c[idx]--;
					j++;

					if (c[idx] == 0) {
						unique--;
					}
				}

				if (h == unique && mk == h) {
					maxLen = Math.max(maxLen, i - j);
				}
			}
		}

		return maxLen;
	}

}
