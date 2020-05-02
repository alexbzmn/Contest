package com.alexbzmn;

import com.alexbzmn.MergeTwoLinkedLists.ListNode;

public class SortLinkedListOLGN {

	public ListNode sortList(ListNode head) {
		if (head != null && head.next != null) {
			ListNode m = partition(head);

			head = sortList(head);
			m = sortList(m);

			ListNode merged = merge(head, m);
			return merged;
		}

		return head;
	}

	private ListNode merge(ListNode n, ListNode m) {
		ListNode r = null;

		if (n.val <= m.val) {
			r = n;
			n = n.next;
		} else {
			r = m;
			m = m.next;
		}

		ListNode start = r;

		while (n != null || m != null) {
			if (m == null) {
				r.next = n;
				n = n.next;
			} else if (n == null) {
				r.next = m;
				m = m.next;
			} else {
				if (n.val <= m.val) {
					r.next = n;
					n = n.next;
				} else {
					r.next = m;
					m = m.next;
				}
			}

			r = r.next;
		}

		return start;
	}

	private ListNode partition(ListNode n) {
		MergeTwoLinkedLists.ListNode n0 = n;
		MergeTwoLinkedLists.ListNode n1 = n.next;
		ListNode n2 = n.next;

		while (n2.next != null && n2.next.next != null) {
			n0 = n1;
			n1 = n1.next;
			n2 = n2.next.next;
		}

		n0.next = null;
		return n1;
	}
}
