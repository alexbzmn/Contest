package com.alexbzmn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;


public class BFS1 {

    private static class Node {
        Node left;
        Node right;
        int idx;
        int val = -1;
    }

    public static void main(String[] args) {
        bfs();
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

            printPaths(rootNode, n);
        }

    }

    private static void printPaths(Node root, int nNodes) {
        int[] costs = new int[nNodes];
        for (int i = 0; i < costs.length; i++) {
            costs[i] = -1;
        }
        costs[root.idx - 1] = 0;
        root.val = 0;

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);

        countPath(queue, costs);

        System.out.println(Arrays.toString(costs));
    }

    private static void countPath(LinkedList<Node> queue, int[] costs) {
        Node next = queue.poll();

        if (next == null) {
            return;
        }

        costs[next.idx - 1] = next.val;

        Node leftChild = next.left;
        if (leftChild != null) {
            leftChild.val = next.val + 6;
            queue.add(leftChild);
        }

        Node rightChild = next.left;
        if (rightChild != null) {
            rightChild.val = next.val + 6;
            queue.add(rightChild);
        }

        countPath(queue, costs);
    }
}