package com.alexbzmn;

import java.util.*;

public class Dijkstra2 {
    static class Node extends AbstractMap.SimpleEntry<Integer, Integer> {
        public Node(Integer key, Integer val) {
            super(key, val);
        }
    }

    private static void dijstra(Map<Integer, List<Node>> graph, int[] w) {
        Set<Integer> vis = new HashSet<>();

        while (vis.size() < graph.size()) {
            int minV = Integer.MAX_VALUE;
            Integer next = null;

            for (int i = 0; i < w.length; i++) {
                if (w[i] < minV && !vis.contains(i)) {
                    minV = w[i];
                    next = i;
                }
            }

            vis.add(next);

            List<Node> neighbors = graph.get(next);
            for (Node n : neighbors) {
                Integer greedyVal = n.getValue() + w[next];
                if (w[n.getKey()] > greedyVal) {
                    w[n.getKey()] = greedyVal;
                }
            }

            for (Map.Entry<Integer, List<Node>> entry : graph.entrySet()) {
                if (entry.getKey().equals(next)) {
                    continue;
                }
                List<Node> adj = entry.getValue();
                for (Node n : adj) {
                    if (n.getKey().equals(next)) {
                        Integer greedyVal = n.getValue() + w[next];
                        if (w[entry.getKey()] > greedyVal) {
                            w[entry.getKey()] = greedyVal;
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            int m = in.nextInt();

            Map<Integer, List<Node>> adj = new TreeMap<>();
            for (int a1 = 0; a1 < m; a1++) {
                int x = in.nextInt() - 1;
                int y = in.nextInt() - 1;
                int r = in.nextInt();

                List<Node> nodes;

                if (adj.containsKey(x)) {
                    nodes = adj.get(x);
                } else {
                    nodes = new ArrayList<>();
                }

                nodes.add(new Node(y, r));
                adj.put(x, nodes);
            }

            int[] w = new int[m];

            for (int i = 0; i < m; i++) {
                w[i] = Integer.MAX_VALUE;
            }

            int s = in.nextInt();
            w[s - 1] = 0;

            dijstra(adj, w);

            for (int i : w) {
                if (i == s - 1) {
                    continue;
                }
                if (i == Integer.MAX_VALUE) {
                    System.out.print(-1 + " ");
                }
                System.out.print(i + " ");
            }
        }
    }
}
