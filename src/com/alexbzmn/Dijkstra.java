package com.alexbzmn;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Dijkstra {
    class Node extends AbstractMap.SimpleEntry<Integer, Integer> {

        public Node(Integer key, Integer value) {
            super(key, value);
        }
    }
    public static void main(String[] args) {
        bfs();
    }

    private static void bfs() {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();

        for (int i = 0; i < q; i++) {
            int n = in.nextInt();
            int m = in.nextInt();

            List<List<Integer>> graph = new ArrayList<>();
            int[] costs = new int[n];

            for (int k = 0; k < n; k++) {
                graph.add(new ArrayList<>());
                costs[k] = Integer.MAX_VALUE;
            }

            for (int k = 0; k < m; k++) {
                int from = in.nextInt() - 1;
                int to = in.nextInt() - 1;

                graph.get(from).add(to);
            }

            int rootIdx = in.nextInt();

            costs[rootIdx - 1] = 0;

            countPath(graph, costs);
            printResult(costs);
        }

    }


    private static void countPath(List<List<Integer>> graph, int[] costs) {
        List<Integer> nodeSet = new ArrayList<>();
        nodeSet.addAll(IntStream.range(0, costs.length).boxed().collect(Collectors.toList()));

        while (!nodeSet.isEmpty()) {
            Integer next = null;
            int minCost = Integer.MAX_VALUE;

            for (int i = 0; i < costs.length; i++) {
                if (costs[i] < minCost && nodeSet.contains(i)) {
                    minCost = costs[i];
                    next = i;
                }
            }

            if (next == null) {
                break;
            }

            nodeSet.remove(next);

            List<Integer> neighbours = graph.get(next);
            for (int i = 0; i < neighbours.size(); i++) {
                int neighbour = neighbours.get(i);
                if (costs[neighbour] > minCost + 6) {
                    costs[neighbour] = minCost + 6;
                }
            }

            for (int i = 0; i < graph.size(); i++) {
                if (graph.get(i).contains(next)) {
                    if (costs[i] > minCost + 6) {
                        costs[i] = minCost + 6;
                    }
                }
            }
        }

    }

    private static void printResult(int[] costs) {
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
}