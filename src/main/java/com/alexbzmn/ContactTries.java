package com.alexbzmn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by User on 7/9/2017.
 */


public class ContactTries {
    static class Node {
        HashMap<String, Node> nodes = new HashMap<>();
        boolean isCompleteWord = false;
    }

    private static Node trieRoot = new Node();

    private static void addLetters(LinkedList<String> queue, Node trie) {

        while (!queue.isEmpty()) {
            String letter = queue.pop();
            if (trie.nodes.containsKey(letter)) {
                Node childNode = trie.nodes.get(letter);
                addLetters(queue, childNode);
            } else {
                Node newNode = new Node();
                if (queue.isEmpty()) {
                    newNode.isCompleteWord = true;
                }
                trie.nodes.put(letter, newNode);
                addLetters(queue, newNode);
            }
        }
    }

    private static void add(String word) {
        String[] letters = word.split("");
        addLetters(new LinkedList<String>(Arrays.asList(letters)), trieRoot);
    }

    private static int find(String partial) {
        String[] letters = partial.split("");
        LinkedList<String> queue = new LinkedList<>(Arrays.asList(letters));
        Node crossNode = findCrossNode(queue, trieRoot);

        if (crossNode == null) {
            return 0;
        }

        return findCount(crossNode);
    }

    private static Node findCrossNode(LinkedList<String> queue, Node trie) {
        if (!queue.isEmpty()) {
            Node childNode = trie.nodes.get(queue.pop());
            if (childNode != null) {
                return findCrossNode(queue, childNode);
            } else {
                return null;
            }

        }

        return trie;
    }

    private static int findCount(Node trie) {
        int result = 0;

        for (Node node : trie.nodes.values()) {
            result += findCount(node);
        }

        result += trie.isCompleteWord ? 1 : 0;

        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int a0 = 0; a0 < n; a0++) {
            String op = in.next();
            String contact = in.next();

            if (op.equals("add")) {
                add(contact);
            } else {
                int res = find(contact);
                System.out.println(res);
            }
        }
    }
}
