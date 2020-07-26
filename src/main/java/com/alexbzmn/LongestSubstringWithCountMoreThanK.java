package com.alexbzmn;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithCountMoreThanK {

	public static void main(String[] args) {

	}

	public int longestSubstring(String s, int k) {
		// what if the invariant holds only without previous symbols: a,b,b; b,a,b

		int maxC = 0;
		for (int i = 0; i < s.length(); i++) {
			Map<Character, Integer> m = new HashMap<>();

			if (s.length() - i <= maxC) {
				break;
			}

			for (int j = i; j < s.length(); j++) {
				Character ch = s.charAt(j);
				if (!m.containsKey(ch)) {
					m.put(ch, 1);
				} else {
					m.put(ch, m.get(ch) + 1);
				}

				if (checkValid(m, k)) {
					maxC = Math.max(maxC, j - i + 1);
				}
			}
		}

		return maxC;
	}

	private boolean checkValid(Map<Character, Integer> m, int k) {
		boolean res = true;
		for (Character c : m.keySet()) {
			res = res & (m.get(c) >= k);
		}

		return res;
	}

}
