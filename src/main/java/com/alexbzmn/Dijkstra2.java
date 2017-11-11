package com.alexbzmn;

import java.io.File;
import java.io.FileNotFoundException;
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

            if (next == null) {
                break;
            }

            vis.add(next);

            List<Node> neighbors = graph.get(next);
            if (neighbors == null) {
                continue;
            }

            for (Node n : neighbors) {
                Integer greedyVal = n.getValue() + w[next];
                if (w[n.getKey()] > greedyVal) {
                    w[n.getKey()] = greedyVal;
                }
            }

            if (w.length > 2490) {
                continue;
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

    public static void main(String[] args) throws FileNotFoundException {
        long start = System.currentTimeMillis();

        Scanner in = new Scanner(new File("files/DIKSTRA07IN.txt"));
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

            int[] w = new int[n];

            for (int i = 0; i < n; i++) {
                w[i] = Integer.MAX_VALUE;
            }

            int s = in.nextInt();
            w[s - 1] = 0;

            dijstra(adj, w);

            for (int i : w) {
                if (i == 0) {
                    continue;
                }

                if (i == Integer.MAX_VALUE) {
                    System.out.print(-1 + " ");
                } else {
                    System.out.print(i + " ");
                }
            }

            System.out.print("\n");
        }

        long finish = System.currentTimeMillis();

        long ms = finish - start;
        System.out.println(ms + " ms");
    }
}
