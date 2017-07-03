package com.alexbzmn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;


public class BFS1 {
    public static void main(String[] args) {
        bfs();
    }

    private static class Node {
        Node left;
        Node right;
        int idx;
        int val = -1;
    }

    private static void bfs() {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();

        int g = 0;

        for (int i = 0; i < q; i++) {
            int n = in.nextInt();
            int m = in.nextInt();

            Node[] graph = new Node[n];

            for (int k = 0; k < n; k++) {
                Node node = new Node();
                node.idx = k + 1;

                graph[k] = node;
            }

            for (int k = 0; k < m; k++) {
                int from = in.nextInt();
                int to = in.nextInt();

                Node fromNode = graph[from - 1];
                Node toNode = graph[to - 1];

                if (fromNode.left == null) {
                    fromNode.left = toNode;
                } else {
                    fromNode.right = toNode;
                }
            }

            int rootIdx = in.nextInt();
            Node rootNode = graph[rootIdx - 1];

            printPaths(rootNode, graph, n);
        }

    }

    private static void printPaths(Node root, Node[] graph, int nNodes) {
        int[] costs = new int[nNodes];
        for (int i = 0; i < costs.length; i++) {
            costs[i] = -1;
        }
        costs[root.idx - 1] = 0;
        root.val = 0;

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);

        countPath(queue, graph, costs);

        String res = Arrays.stream(costs)
                .filter(value -> value != 0)
                .mapToObj(String::valueOf)
                .reduce("", (s, s2) -> s + " " + s2)
                .replaceFirst(" ", "");

        System.out.println(res);
    }

    private static void countPath(LinkedList<Node> queue, Node[] graph, int[] costs) {

        while (!queue.isEmpty()) {
            Node next = queue.poll();

            if (next == null) {
                return;
            }

            costs[next.idx - 1] = next.val;

            Node leftChild = next.left;
            if (leftChild != null) {
                if (leftChild.val == -1) {
                    leftChild.val = next.val + 6;
                    queue.add(leftChild);
                }
            }

            Node rightChild = next.right;
            if (rightChild != null) {
                if (rightChild.val == -1) {
                    rightChild.val = next.val + 6;
                    queue.add(rightChild);
                }
            }

            //todo optimize
            Arrays.stream(graph).forEach(node -> {
                if (node.left != null && node.left.idx == next.idx && node.val == -1) {
                    node.val = next.val + 6;
                    queue.add(node);
                }

                if (node.right != null && node.right.idx == next.idx && node.val == -1) {
                    node.val = next.val + 6;
                    queue.add(node);
                }
            });
        }

    }
}