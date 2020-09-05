package com.alexbzmn;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class BasicCalculator2 {

	public static void main(String[] args) {
		//		System.out.println(new BasicCalculator().calculate("3 + 2*2"));
		System.out.println(new BasicCalculator2().calculate("1-1*20"));
	}

	public int calculate(String s) {
		s = s.replace(" ", "");
		Set<String> signs = new HashSet<>();
		signs.add("-");
		signs.add("+");
		signs.add("*");
		signs.add("/");

		Queue<Character> signsQ = new LinkedList<>();
		Queue<Integer> nums = new LinkedList<>();

		// "3+2 "
		int i = 0;
		while (i < s.length()) {
			int j = i + 1;
			String x = s.substring(i, j);
			if (signs.contains(x)) {
				signsQ.add(x.charAt(0));
				i = j;
			} else {
				while (j < s.length() && !signs.contains(String.valueOf(s.charAt(j)))) {
					j++;
				}
				nums.add(Integer.parseInt(s.substring(i, j)));
				i = j;
			}

		}

		if (nums.size() == 1) {
			return nums.poll();
		}

		// 3 + 2 * 2 + 4 - 3 * 3 * 3 - 2 = -18
		// " 3+5 / 2 "
		Stack<Integer> numStack = new Stack<>();
		while (!nums.isEmpty()) {
			int a = numStack.isEmpty() ? nums.poll() : numStack.pop();
			int b = nums.poll();
			char c = signsQ.poll();

			if (c != '/' && c != '*') {
				if (signsQ.isEmpty() || (signsQ.peek() != '/' && signsQ.peek() != '*')) {
					numStack.add(eval(a, b, c));
				} else {
					numStack.add(a);
					numStack.add(c == '-' ? -b : b);
				}
			} else {
				numStack.add(eval(a, b, c));
			}

		}

		int res = 0;
		for (int el : numStack) {
			res += el;
		}

		return res;
	}

	private int eval(int a, int b, char c) {
		if (c == '+') {
			return a + b;
		} else if (c == '-') {
			return a - b;
		} else if (c == '*') {
			return a * b;
		} else {
			return a / b;
		}
	}

}
