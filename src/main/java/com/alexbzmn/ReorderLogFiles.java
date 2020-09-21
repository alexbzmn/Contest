package com.alexbzmn;

import java.util.*;

public class ReorderLogFiles {

	public static void main(String[] args) {
				System.out.println(Arrays.toString(new ReorderLogFiles().reorderLogFiles(new String[] {
					"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero" })));

//		System.out.println(Arrays.toString(new ReorderLogFiles().reorderLogFiles(new String[] {
//			"27 85717 7", "2 y xyr fc", "52 314 99", "d 046099 0", "m azv x f", "7e apw c y", "8 hyyq z p", "6 3272401", "c otdk cl", "8 ksif m u" })));
	}

	public String[] reorderLogFiles(String[] logs) {
		List<String> letterLogsList = new ArrayList<>();
		List<String> digitLogs = new ArrayList<>();

		for (String log : logs) {
			String[] tokens = log.split(" ");
			if (Character.isDigit(tokens[1].charAt(0))) {
				digitLogs.add(log);
			} else {
				letterLogsList.add(log);
			}
		}

		letterLogsList.sort((o1, o2) -> {
			String key1 = o1.split(" ")[0];
			String key2 = o2.split(" ")[0];

			int res = o1.substring(key1.length()).compareTo(o2.substring(key2.length()));
			if (res == 0) {
				return key1.compareTo(key2);
			} else {
				return res;
			}
		});

		letterLogsList.addAll(digitLogs);

		String[] res = new String[logs.length];
		for (int i = 0; i < res.length; i++) {
			res[i] = letterLogsList.get(i);
		}

		return res;
	}

}
