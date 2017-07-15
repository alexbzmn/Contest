package com.alexbzmn;

import java.util.*;
import java.util.AbstractMap.SimpleEntry;

/**
 * Created by User on 7/14/2017.
 */

// TODO analyse complexity and optimise
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

            if (!graph.containsKey(nextEdge)) {
                graph.put(nextEdge, new ArrayList<>());
            }
        }

        int startingNode = sc.nextInt();

        Map<Integer, Integer> costs = new HashMap<>();

        for (Integer key : graph.keySet()) {
            costs.put(key, Integer.MAX_VALUE);
        }

        costs.put(startingNode, 0);

        Map<Integer, Integer> costsMst = new HashMap<>();
        costsMst.put(startingNode, 0);

        System.out.println(findMSTSum(graph, costs, costsMst));
    }

    private static int findMSTSum(Map<Integer, List<SimpleEntry<Integer, Integer>>> graph,
                                  Map<Integer, Integer> costs, Map<Integer, Integer> costsMst) {

        Set<Integer> mstSet = new HashSet<>();
        Set<Integer> seen = new HashSet<>();

        while (seen.size() < graph.size()) {

            SimpleEntry<Integer, Integer> cheapest = getClosestUnseenEntry(costs, mstSet);
            mstSet.add(cheapest.getKey());
            seen.add(cheapest.getKey());

            List<SimpleEntry<Integer, Integer>> neighbours = graph.get(cheapest.getKey());
            for (SimpleEntry<Integer, Integer> adj : neighbours) {
                updateCost(adj, costs, cheapest.getValue(), costsMst, mstSet);
            }

            for (Map.Entry<Integer, List<SimpleEntry<Integer, Integer>>> childNode : graph.entrySet()) {
                if (!childNode.getKey().equals(cheapest.getKey())) {
                    List<SimpleEntry<Integer, Integer>> adjList = childNode.getValue();
                    for (SimpleEntry<Integer, Integer> adjLink : adjList) {
                        if (adjLink.getKey().equals(cheapest.getKey())) {
                            updateCost(new SimpleEntry<>(childNode.getKey(), adjLink.getValue()),
                                    costs, cheapest.getValue(), costsMst, mstSet);
                        }
                    }
                }
            }
        }

        return costsMst.entrySet().stream().map(Map.Entry::getValue).reduce((e1, e2) -> e1 + e2).get();
    }

    private static void updateCost(SimpleEntry<Integer, Integer> adj, Map<Integer, Integer> costs, Integer parentCost,
                                   Map<Integer, Integer> costsMst, Set<Integer> mstSet) {
        Integer cost = costs.get(adj.getKey());
        if (cost > adj.getValue() && !mstSet.contains(adj.getKey())) {
            costs.put(adj.getKey(), adj.getValue());
            costsMst.put(adj.getKey(), adj.getValue());
        }
    }

    private static SimpleEntry<Integer, Integer> getClosestUnseenEntry(Map<Integer, Integer> costs, Set<Integer> mst) {
        SimpleEntry<Integer, Integer> closest = new SimpleEntry<>(-1, Integer.MAX_VALUE);

        for (Map.Entry<Integer, Integer> entry : costs.entrySet()) {
            if (mst.contains(entry.getKey())) {
                continue;
            }

            if (entry.getValue() < closest.getValue()) {
                closest = new SimpleEntry<>(entry.getKey(), entry.getValue());
            }
        }

        return closest;
    }
}
