package com.alexbzmn;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class StringToNumber {

	public static void main(String[] args) {

		System.out.println(toInt("123,435"));
		System.out.println(toInt("123,332,120"));
		//		System.out.println(toInt("123,000,000,000"));
		System.out.println(toInt("1,001"));
	}

	private static long toInt(String val) {

		Queue<Integer> queue = new LinkedList<>();
		Map<Integer, Integer> scales = new HashMap<>();
		scales.put(0, 1);
		scales.put(1, 1000);
		scales.put(2, 1000000);
		scales.put(3, 1000000000);

		long result = 0L;
		String[] sections = val.split(",");
		for (int i = 0; i < sections.length; i++) {
			result += scales.get(sections.length - (i + 1)) * Integer.parseInt(sections[i]);
		}

		return result;
	}

}
