package com.alexbzmn;

public class MergeTwoLinkedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        Integer value = getNextValue(l1, l2);
        if (value == null) {
            return null;
        }

        ListNode root = new ListNode(value);
        splice(l1.next, l2.next, root);
        return root;
    }

    private ListNode splice(ListNode l1, ListNode l2, ListNode parent) {
        Integer nextVal = getNextValue(l1, l2);
        if (nextVal == null) {
            return parent;
        }

        ListNode node = new ListNode(nextVal);
        parent.next = node;

        return splice(l1 != null ? l1.next : null, l2 != null ? l2.next : null, node);
    }

    private Integer getNextValue(ListNode l1, ListNode l2) {
        Integer left = l1 != null ? l1.val : null;
        Integer right = l2 != null ? l2.val : null;

        if (left == null && right == null) {
            return null;
        }

        if (left == null && right != null) {
            left = right;
        }

        if (right == null && left != null) {
            right = left;
        }

        return left < right ? left : right;
    }


    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
