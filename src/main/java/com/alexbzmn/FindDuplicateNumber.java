package com.alexbzmn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindDuplicateNumber {

	public int findDuplicate(int[] nums) {
		int hare = 0;
		int tortoise = 0;

		hare = nums[nums[hare]];
		tortoise = nums[tortoise];

		while (hare != tortoise) {
			hare = nums[nums[hare]];
			tortoise = nums[tortoise];
		}

		tortoise = 0;
		while (hare != tortoise) {
			hare = nums[hare];
			tortoise = nums[tortoise];
		}

		return hare;
	}

	public static List<String> smallestNegativeBalance(List<List<String>> debts) {

		Map<String, Integer> borrow = new HashMap<>();
		Map<String, Integer> lend = new HashMap<>();

		for (List<String> row : debts) {
			String borrower = row.get(0);
			String lender = row.get(1);
			Integer amount = Integer.parseInt(row.get(2));

			borrow.put(borrower, borrow.getOrDefault(borrower, 0) - amount);
			lend.put(lender, lend.getOrDefault(lender, 0) + amount);
		}

		Map<String, Integer> finalBalance = new HashMap<>(borrow);
		for (String lender : lend.keySet()) {
			finalBalance.put(lender, finalBalance.getOrDefault(lender, 0) + lend.get(lender));
		}

		Map<Integer, List<String>> balancePerUser = new HashMap<>();
		for (String user : finalBalance.keySet()) {
			List<String> list = balancePerUser.getOrDefault(finalBalance.get(user), new ArrayList<>());
			list.add(user);
			balancePerUser.put(finalBalance.get(user), list);
		}

		int min = balancePerUser.keySet().stream().min(Integer::compareTo).get();
		List<String> users = balancePerUser.get(min);
		if (users.size() > 1) {
			return users.stream().sorted(String::compareTo).collect(Collectors.toList());
		}

		return users;
	}
}

