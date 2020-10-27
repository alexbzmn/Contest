package com.alexbzmn;

import java.util.PriorityQueue;

public class Reduction {

	static int reductionCost(int[] num) {

		int cost = 0;
		PriorityQueue<Integer> queue = new PriorityQueue<>();

		for (int val : num) {
			queue.add(val);
		}

		while (queue.size() > 1) {

			int first = queue.poll();
			int second = queue.poll();

			cost += first + second;
			queue.add(first + second);

		}

		return cost;
	}

	static String rollingString(String s, String[] operations) {

		char[] chars = s.toCharArray();

		for (String op : operations) {

			String[] vals = op.split(" ");
			boolean right = vals[2].equals("R");

			int start = Integer.parseInt(vals[0]);
			int finish = Integer.parseInt(vals[1]);
			while (start <= finish) {
				int c = chars[start] - 'a';
				char val;

				if (right) {
					val = (char)('a' + (c + 1) % 26);
				} else {
					if (c - 1 < 0) {
						val = (char)('a' + 25);
					} else {
						val = (char)('a' + (c - 1) % 26);
					}
				}

				chars[start] = val;
				start++;
			}

		}

		return new String(chars);

	}

}
