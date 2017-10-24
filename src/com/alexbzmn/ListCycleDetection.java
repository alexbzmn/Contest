package com.alexbzmn;

/**
 * Created by User on 7/8/2017.
 */
public class ListCycleDetection {
    class Node {
        int data;
        Node next;
    }

    // Tortoise and Hare algorithm
    boolean hasCycle(Node head) {
        if (head == null) {
            return false;
        }

        Node slow = head;
        Node fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }
}
