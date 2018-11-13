package com.alexbzmn;

public class IntShuffle {

	public static void main(String[] args) {
		System.out.println(solution(123456)); //162534
		System.out.println(solution(0)); //0
		System.out.println(solution(100000000)); //100000000
		System.out.println(solution(94070600)); //90400670
		System.out.println(solution(99070609)); //99900670
		System.out.println(solution(130)); //103
		System.out.println(solution(67)); //67
		System.out.println(solution(12345)); //15243
	}

	public static int solution(int A) {
		String[] digits = Integer.toString(A).split("");
		if (digits.length == 1) {
			return Integer.parseInt(digits[0]);
		}

		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < digits.length / 2; i++) {
			stringBuilder.append(digits[i]);
			stringBuilder.append(digits[(digits.length - 1) - i]);
		}

		if (digits.length % 2 != 0) {
			stringBuilder.append(digits[digits.length / 2]);
		}

		return Integer.valueOf(stringBuilder.toString());
	}

}
