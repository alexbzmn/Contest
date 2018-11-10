package com.alexbzmn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class BracketsCodility {
	public int solution(String S) {
		if (S.length() == 0) {
			return 1;
		}

		if (S.length() % 2 != 0) {
			return 0;
		}

		Stack<Character> chars = new Stack<>();
		Map<Character, Character> map = new HashMap<>();
		map.put('}', '{');
		map.put(']', '[');
		map.put(')', '(');

		Set<Character> toPush = new HashSet<>();
		toPush.add('{');
		toPush.add('[');
		toPush.add('(');

		for (int i = 0; i < S.length(); i++) {
			Character val = S.charAt(i);
			if (toPush.contains(val)) {
				chars.push(val);
			} else {
				if (chars.isEmpty() || !chars.pop().equals(map.get(val))) {
					return 0;
				}
			}
		}

		return chars.size() == 0 ? 1 : 0;
	}

}
