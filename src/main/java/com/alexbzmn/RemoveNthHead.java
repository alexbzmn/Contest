package com.alexbzmn;

public class RemoveNthHead {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);


        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        ListNode res = removeNthFromEnd(one, 2);
        System.out.println("");
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (n != 0 && head != null) {
            int result = remove(head, n);
            if (result == 0) {
                return head.next;
            }

        }

        return head;
    }

    public static int remove(ListNode head, int n) {
        if (head.next != null) {
            int result = remove(head.next, n);
            if (result == 0) {
                if (head.next.next != null) {
                    head.next = head.next.next;
                } else {
                    head.next = null;
                }
            } else {
                return result - 1;
            }
        } else {
            return n - 1;
        }

        return -1;
    }

}
