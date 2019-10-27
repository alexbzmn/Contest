package com.alexbzmn;

public class AddTwoNumbers {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = new ListNode(0);
        return add(l1, l2, result);
    }

    public ListNode add(ListNode l1, ListNode l2, ListNode res) {
        int left = l1 != null ? l1.val : 0;
        int right = l2 != null ? l2.val : 0;

        int sum = left + right + res.val;
        if (sum >= 10) {
            res.val = sum - 10;
        } else {
            res.val = sum;
        }

        if ((l1 != null && l1.next != null) || (l2 != null && l2.next != null)) {
            ListNode next = new ListNode(0);

            if (sum >= 10) {
                next.val = 1;
            }

            res.next = next;
            add(l1 != null ? l1.next : null, l2 != null ? l2.next : null, next);
        } else if (sum >= 10) {
            ListNode next = new ListNode(0);

            next.val = 1;
            res.next = next;
        }

        return res;
    }

}
