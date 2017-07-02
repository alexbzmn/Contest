package com.alexbzmn;

import java.util.Scanner;


public class BFS1 {

    private static class Node {
        Node left;
        Node right;
        int idx;
        int val = Integer.MAX_VALUE;
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
        System.out.println(nNodes);
        int[] costs = new int[nNodes];
        for (int i = 0; i < costs.length; i++) {
            costs[i] = -1;
        }
        costs[root.idx - 1] = 0;
        root.val = 0;

        countPath(root, costs);
    }

    private static void countPath(Node root, int[] costs) {
        if (costs[root.idx - 1] == -1) {
            costs[root.idx - 1] = root.val;
        }

        if (root.left != null) {
            int leftVal = root.left.val;

            if (leftVal > root.val + 6) {
                root.left.val = root.val + 6;
                countPath(root.left, costs);
            }

        } else if (root.right != null) {
            int rightVal = root.right.val;

            if (rightVal > root.val + 6) {
                root.right.val = root.val + 6;
                countPath(root.right, costs);
            }
        }

    }
}