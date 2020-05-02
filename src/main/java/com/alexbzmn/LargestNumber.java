package com.alexbzmn;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LargestNumber {

	public static void main(String[] args) {
		int[] arr = new int[] { 3, 30, 34, 5, 9 };
		System.out.println(new LargestNumber().largestNumber(arr));
		//		System.out.println(new LargestNumber().largestNumber(new int[] {}));
		System.out.println(new LargestNumber().largestNumber(new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 9 }));
		System.out.println(new LargestNumber().largestNumber(new int[] { 12345, 5, 78, 9 }));
		System.out.println(new LargestNumber().largestNumber(new int[] { 121, 12 }));

	}

	public String largestNumber(int[] nums) {

		StringBuilder sb = new StringBuilder();
		Arrays.stream(nums).boxed().sorted((o1, o2) -> {
			String aString = o1.toString();
			String bString = o2.toString();

			long s1 = Long.parseLong(aString + bString);
			long s2 = Long.parseLong(bString + aString);

			if (s1 > s2) {
				return -1;
			} else {
				return 1;
			}

		}).forEach(sb::append);

		String res = sb.toString();
		if (res.length() > 0 && res.charAt(0) == '0') {
			return "0";
		}

		return sb.toString();
	}
}
