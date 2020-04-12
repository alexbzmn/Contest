package com.alexbzmn;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

	public static void main(String[] args) {
		List<List<String>> res = new PalindromePartitioning().partition("aab");
		res = new PalindromePartitioning().partition("abbab");
		System.out.println(new PalindromePartitioning().isP("abbab"));
	}

	public List<List<String>> partition(String s) {
		List<List<String>> r = new ArrayList<>();

		solve(s, 0, new ArrayList<>(), r);

		return r;
	}

	private void solve(String s, int start, List<String> pol, List<List<String>> r) {
		if (start == s.length()) {
			r.add(new ArrayList<>(pol));
			return;
		}

		for (int i = start + 1; i <= s.length(); i++) {
			String sub = s.substring(start, i);
			if (isP(sub)) {
				pol.add(sub);
				solve(s, i, pol, r);
				pol.remove(pol.size() - 1);
			}
		}

	}

	private boolean isP(String s) {
		if (s.length() == 1) {
			return true;
		}

		int i = 0;
		int k = s.length() - 1;
		while (i < k) {
			if (s.charAt(i) != s.charAt(k)) {
				return false;
			}

			i++;
			k--;
		}

		return true;
	}
}
