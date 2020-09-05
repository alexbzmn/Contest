package com.alexbzmn;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class BasicCalculator {

	public static void main(String[] args) {
		//		System.out.println(new BasicCalculator().calculate("3 + 2*2"));
		System.out.println(new BasicCalculator().calculate("1-1*20"));
	}

	public int calculate(String s) {
		Set<String> firstOrder = new HashSet<>();
		firstOrder.add("*");
		firstOrder.add("/");

		LinkedList<Integer> q = new LinkedList<>();
		LinkedList<String> si = new LinkedList<>();

		for (String c : s.replace(" ", "").split("\\D")) {
			q.add(Integer.parseInt(c));
		}

		for (String c : s.replace(" ", "").split("\\d")) {
			if (!c.isEmpty()) {
				si.add(c);
			}
		}

		while (!si.isEmpty()) {

			String sign = si.pop();
			String nextSign = si.peek();
			if (!firstOrder.contains(sign) && firstOrder.contains(nextSign)) {
				if (!sign.equals("-")) {
					si.add(sign);
					q.add(q.pop());
				} else {
					si.add("+");
					q.add(q.pop());
					q.addFirst(-q.pop());
				}
				continue;
			}

			int a = q.pop();
			int b = q.pop();
			if (sign.equals("*")) {
				q.addFirst(a * b);
			} else if (sign.equals("/")) {
				q.addFirst(a / b);
			} else if (sign.equals("-")) {
				q.addFirst(a - b);
			} else if (sign.equals("+")) {
				q.addFirst(a + b);
			}

		}

		return q.pop();
	}



}
