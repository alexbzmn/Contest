package com.alexbzmn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {

	public static void main(String[] args) {
		System.out.println(new MostCommonWord().mostCommonWord(
			"Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"}));

		System.out.println(new MostCommonWord().mostCommonWord(
			"B", new String[]{"a"}));

		System.out.println(new MostCommonWord().mostCommonWord(
			"B a as as sd gfd", new String[]{}));

		System.out.println(new MostCommonWord().mostCommonWord(
			"a, a, a, a, b,b,b,c, c", new String[]{"a"}));
	}

	public String mostCommonWord(String paragraph, String[] banned) {
		Set<String> b = new HashSet<>();
		for (String str : banned) {
			b.add(str);
		}

		Map<String, Integer> m = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		for (char c : paragraph.toCharArray()) {
			if (Character.isLetter(c)) {
				sb.append(Character.toLowerCase(c));
			} else {
				if (sb.length() > 0 && !b.contains(sb.toString())) {
					m.put(sb.toString(), m.getOrDefault(sb.toString(), 0) + 1);
				}
				sb = new StringBuilder();
			}
		}

		if (sb.length() > 0 && !b.contains(sb.toString())) {
			m.put(sb.toString(), m.getOrDefault(sb.toString(), 0) + 1);
		}

		int c = 0;
		String word = "";

		for (Map.Entry<String, Integer> e : m.entrySet()) {
			if (e.getValue() > c) {
				c = e.getValue();
				word = e.getKey();
			}
		}

		return word;
	}

}
