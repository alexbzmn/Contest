package com.alexbzmn;

import java.util.*;


public class BFS1 {
    public static void main(String[] args) {
        bfs();
    }

    private static class Node {
        Node left;
        Node right;
        int idx;
        Integer val = Integer.MAX_VALUE;
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
            costs[i] = Integer.MAX_VALUE;
        }

        root.val = 0;

        countPath(graph, costs);

        for (int i = 0; i < costs.length; i++) {
            if (costs[i] == Integer.MAX_VALUE || costs[i] < -1) {
                costs[i] = -1;
            }
        }

        String res = Arrays.stream(costs)
                .filter(value -> value != 0)
                .mapToObj(String::valueOf)
                .reduce("", (s, s2) -> s + " " + s2)
                .replaceFirst(" ", "");

        System.out.println(res);
    }

    private static void countPath(Node[] graph, int[] costs) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        priorityQueue.addAll(Arrays.asList(graph));

        while (!priorityQueue.isEmpty()) {
            Node n = priorityQueue.poll();
            priorityQueue.add(n);

            Node next = priorityQueue.poll();

            costs[next.idx - 1] = next.val;

            int nextDist = next.val + 6;
            if (next.right != null && next.right.val > nextDist) {
                next.right.val = nextDist;
            }

            if (next.left != null && next.left.val > nextDist) {
                next.left.val = nextDist;
            }

            for (Node node : priorityQueue) {
                if (node.idx != next.idx) {
                    if (node.left != null && node.left.idx == next.idx && node.val > nextDist) {
                        node.val = nextDist;
                    }

                    if (node.right != null && node.right.idx == next.idx && node.val > nextDist) {
                        node.val = nextDist;
                    }
                }
            }

        }

    }
}