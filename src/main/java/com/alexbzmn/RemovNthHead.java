package com.alexbzmn;

public class RemovNthHead {
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
        System.out.printf("");
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (n != 0) {
            removeEnd(head, n);
        }

        return head;
    }

    public static int removeEnd(ListNode head, int n) {
        if (head.next == null) {
            return n - 1;
        }

        int res = removeEnd(head.next, n);
        if (res < n && res > 0) {
            return res - 1;
        }

        if (res == 0) {
            if (head.next.next != null) {
                head.next = head.next.next;
            } else {
                head.next = null;
            }
        }

        return -1;
    }

    public void rotate(int[][] matrix) {
        int depth = matrix[0].length / 2;

        for (int i = 0; i <= depth; i++) {


            for (int j = 0; j < matrix[0].length - 1; j++) {
                int buf = matrix[i][matrix[i].length - 1 - j];
                matrix[i][matrix[i].length - 1 - j] = matrix[i][j];

                int buf2 = matrix[matrix[i].length - 1 - j][matrix[i].length - 1];
                matrix[matrix[i].length - 1 - j][matrix[i].length - 1] = buf;

                buf = matrix[matrix[i].length - 1][j];
                matrix[matrix[i].length - 1][j] = buf2;

                matrix[i][j] = buf;
            }

        }
    }
}
