package com.alexbzmn;

import java.util.HashMap;
import java.util.Map;

import com.alexbzmn.AddTwoNumbers.ListNode;

public class CheckListIsPalindrome {

	public static void main(String[] args) {

		//		System.out.println(new CheckListIsPalindrome().isPalindrome(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(1, null)))))));
		//		System.out.println(new CheckListIsPalindrome().isPalindrome(new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1, null))))));
		System.out.println(new CheckListIsPalindrome().isPalindrome(new ListNode(1, new ListNode(2, new ListNode(3, null)))));

	}

	public boolean isPalindrome(AddTwoNumbers.ListNode head) {
		if (head == null) {
			return true;
		}
		// 1 2 3 4 4 3 2 1
		// 1 2 3 4 5 4 3 2 1
		int length = 0;

		ListNode start = head;
		while (start.next != null) {
			length++;
			start = start.next;
		}

		int mid = length / 2 + 1;
		start = head;
		ListNode midNode = null;
		int i = 0;
		while (start != null) {

			if (i == mid) {
				midNode = start;
				break;
			}

			i++;
			start = start.next;
		}

		ListNode reversedHead = reverseList(null, midNode);
		boolean isPalindrome = true;

		i = 0;
		while (i < mid && (head != null && reversedHead != null)) {
			isPalindrome = isPalindrome && reversedHead.val == head.val;
			reversedHead = reversedHead.next;
			head = head.next;
			i++;
		}

		return isPalindrome;
	}

	// 4 3 2 1
	private AddTwoNumbers.ListNode reverseList(AddTwoNumbers.ListNode prev, ListNode next) {
		if (next == null) {
			return prev;
		}

		ListNode nextNext = next.next;
		next.next = prev;

		return reverseList(next, nextNext);
	}

	public boolean isAnagram(String s, String t) {
		Map<Character, Integer> ch = new HashMap<>();
		for (char c : s.toCharArray()) {
			ch.put(c, ch.getOrDefault(c, 0) + 1);
		}

		for (char c : t.toCharArray()) {
			if (!ch.containsKey(c) || ch.get(c) == 0) {
				return false;
			} else {
				ch.put(c, ch.get(c) - 1);
			}
		}

		for (char c : ch.keySet()) {
			if (ch.get(c) != 0) {
				return false;
			}
		}

		return true;
	}

}
