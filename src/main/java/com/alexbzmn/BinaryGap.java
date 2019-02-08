package com.alexbzmn;

public class BinaryGap {

	public int solution(int N) {
		String bin = Integer.toBinaryString(N);

		int longest = 0;
		char prev = ' ';
		int len = 0;

		for (char c : bin.toCharArray()) {
			if (c == '1') {
				if (prev == '0') {
					longest = Math.max(longest, len);
					len = 0;
				}

			} else {
				len++;
			}

			prev = c;
		}

		return longest;
	}
}
