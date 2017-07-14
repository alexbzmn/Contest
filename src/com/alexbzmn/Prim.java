package com.alexbzmn;

import java.util.*;
import java.util.AbstractMap.SimpleEntry;

/**
 * Created by User on 7/14/2017.
 */
public class Prim {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        Map<Integer, List<SimpleEntry<Integer, Integer>>> graph = new HashMap<>();

        for (int i = 0; i < m; i++) {
            int nextNode = sc.nextInt();
            int nextEdge = sc.nextInt();
            int nextCost = sc.nextInt();

            if (!graph.containsKey(nextNode)) {
                List<SimpleEntry<Integer, Integer>> adj = new ArrayList<>();
                adj.add(new SimpleEntry<>(nextEdge, nextCost));

                graph.put(nextNode, adj);
            } else {
                List<SimpleEntry<Integer, Integer>> adj = graph.get(nextNode);
                adj.add(new SimpleEntry<>(nextEdge, nextCost));
            }
        }

        int startingNode = sc.nextInt();

        Map<Integer, Integer> costs = new HashMap<>();

        for (Integer key : graph.keySet()) {
            costs.put(key, Integer.MAX_VALUE);
        }

        costs.put(startingNode, 0);

        System.out.println(graph);
    }

    private static SimpleEntry<Integer, Integer> getClosestEntry(Map<Integer, Integer> costs) {
        SimpleEntry<Integer, Integer> closest = new SimpleEntry<>(-1, Integer.MAX_VALUE);

        for (Map.Entry<Integer, Integer> entry : costs.entrySet()) {
            if (entry.getValue() < closest.getValue()) {
                closest = new SimpleEntry<>(entry.getKey(), entry.getValue());
            }
        }

        return closest;
    }

    private static int findMSTSum(Map<Integer, List<SimpleEntry<Integer, Integer>>> graph,
                                  Map<Integer, Integer> costs) {

        Set<Integer> seen = new HashSet<>();
        SimpleEntry<Integer, Integer> next = getClosestEntry(costs);
        seen.add(next.getKey());

        List<SimpleEntry<Integer, Integer>> neigbours = graph.get(next.getKey());

        neigbours.forEach(entry -> {
            Integer cost = costs.get(entry.getKey());
            if (cost > entry.getValue()) {
                costs.put(entry.getKey(), entry.getValue());
            }
        });

        return 0;
    }
}
