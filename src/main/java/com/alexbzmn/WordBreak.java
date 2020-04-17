package com.alexbzmn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

	public static void main(String[] args) {
		System.out.println(new WordBreak().wordBreak("aaaaaaa", Arrays.asList("aaa", "aaaa")));
		System.out.println(new WordBreak().wordBreak("aaaaaaa", Arrays.asList("aaaa", "aa")));
		System.out.println(new WordBreak().wordBreak("cars", Arrays.asList("car", "ca", "rs")));
		System.out.println(new WordBreak().wordBreak("goalspecial", Arrays.asList("go", "goal", "goals", "special")));
	}

	public boolean wordBreak(String s, List<String> wordDict) {
		Set<String> set = new HashSet<>(wordDict);

		if (s == null || s.length() == 0) {
			return false;
		}

		return wBreak(0, s, set, new HashSet<>());
	}

	private boolean wBreak(int i, String s, Set<String> w, Set<Integer> ind) {
		int st = i;
		int f = st + 1;

		while (f <= s.length()) {

			for (int k = f + 1; k <= s.length(); k++) {
				String s2 = s.substring(st, k);
				if (w.contains(s2) && !ind.contains(k)) {
					boolean t = wBreak(k, s, w, ind);
					if (t) {
						return true;
					}

					ind.add(k);
				}
			}

			String s1 = s.substring(st, f);
			if (w.contains(s1)) {
				st = f;
			}

			f++;
		}

		return st == s.length();
	}

}
