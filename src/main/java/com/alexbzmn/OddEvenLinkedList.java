package com.alexbzmn;

public class OddEvenLinkedList {

	public static void main(String[] args) {
		System.out.println(new OddEvenLinkedList().oddEvenList(new ListNode(
			1,
			new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7, new ListNode(8, new ListNode(9)))))))))));
		System.out.println(new OddEvenLinkedList().oddEvenList(new ListNode(
			1,
			new ListNode(
				2,
				new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7, new ListNode(8, new ListNode(9, new ListNode(10))))))))))));
		System.out.println(new OddEvenLinkedList().oddEvenList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))))));
		System.out.println(new OddEvenLinkedList().oddEvenList(new ListNode(1, new ListNode(2, new ListNode(3, null)))));
		System.out.println(new OddEvenLinkedList().oddEvenList(new ListNode(1, new ListNode(2, null))));
		System.out.println(new OddEvenLinkedList().oddEvenList(new ListNode(1)));
	}

	public ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		oddEven(null, null, null, head, 1);
		return head;
	}

	private void oddEven(ListNode odd, ListNode even, ListNode evenHead, ListNode root, int count) {
		if (root == null) {
			odd.next = evenHead;
			even.next = null;
			return;
		}

		if ((count & 1) == 1) {
			if (odd == null) {
				odd = root;
			} else {
				odd.next = root;
				odd = odd.next;
			}
		} else {
			if (even == null) {
				even = root;
				evenHead = even;
			} else {
				even.next = root;
				even = even.next;
			}
		}

		oddEven(odd, even, evenHead, root.next, ++count);
	}

	public static class ListNode {

		@Override public String toString() {
			return "ListNode{" +
				"val=" + val +
				", next=" + next +
				'}';
		}

		int val;

		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
}
