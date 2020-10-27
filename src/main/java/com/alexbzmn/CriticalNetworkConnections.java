package com.alexbzmn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CriticalNetworkConnections {

	public static void main(String[] args) {

		List<List<Integer>> lists = new ArrayList<>();
		lists.add(Arrays.asList(0, 1));
		lists.add(Arrays.asList(1, 2));
		lists.add(Arrays.asList(2, 0));
		lists.add(Arrays.asList(1, 3));
		lists.add(Arrays.asList(3, 4));
		lists.add(Arrays.asList(4, 5));
		lists.add(Arrays.asList(1, 0));
		lists.add(Arrays.asList(2, 0));
		lists.add(Arrays.asList(3, 2));
		lists.add(Arrays.asList(4, 2));
		lists.add(Arrays.asList(4, 3));
		lists.add(Arrays.asList(3, 0));
		lists.add(Arrays.asList(4, 0));
		lists.add(Arrays.asList(5, 4));
		lists.add(Arrays.asList(3, 5));
		lists.add(Arrays.asList(6, 4));
		lists.add(Arrays.asList(7, 6));

		System.out.println(new CriticalNetworkConnections().criticalConnections(5, lists));
	}

	public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

		Map<Integer, Set<Integer>> g = new HashMap<>();
		for (List<Integer> edge : connections) {
			int first = edge.get(0);
			int second = edge.get(1);

			Set<Integer> firstEdges = g.getOrDefault(first, new HashSet<>());
			Set<Integer> secondEdges = g.getOrDefault(second, new HashSet<>());
			firstEdges.add(second);
			secondEdges.add(first);

			g.put(first, firstEdges);
			g.put(second, secondEdges);
		}

		Map<Integer, Set<Integer>> cycles = new HashMap<>();
		for (Integer node : g.keySet()) {
			if (cycles.containsKey(node)) {
				continue;
			}
			Map<Integer, Integer> v = new HashMap<>();
			removeCycles(node, v, g, cycles, node, 0);
		}

		List<List<Integer>> res = new ArrayList<>();

		for (Integer node : g.keySet()) {
			Set<Integer> edges = g.get(node);
			Set<Integer> c = cycles.get(node);
			Set<Integer> criticalConnections = new HashSet<>();

			for (Integer edge : edges) {
				if (c == null || !c.contains(edge)) {
					g.get(edge).remove(node);
					criticalConnections.add(edge);
				}
			}

			for (Integer edge : criticalConnections) {

				res.add(Arrays.asList(node, edge));
			}
		}

		return res;
	}

	private int removeCycles(Integer node, Map<Integer, Integer> v, Map<Integer, Set<Integer>> g, Map<Integer, Set<Integer>> cycles, int parentCall, int rank) {
		if (v.containsKey(node)) {
			if (v.get(node) < rank) {
				return v.get(node);
			}
		}

		v.put(node, rank);

		if (!g.containsKey(node)) {
			return rank;
		}

		int min = rank;
		for (Integer edge : g.get(node)) {

			if (edge == parentCall) {
				continue;
			}

			int res = removeCycles(edge, v, g, cycles, node, rank + 1);
			if (res < rank + 1) {
				removeConnection(cycles, node, edge);
				min = Math.min(res, min);
			}

		}

		return min;
	}

	private void removeConnection(Map<Integer, Set<Integer>> cycles, Integer a, Integer b) {
		Set<Integer> cycleEdges = cycles.getOrDefault(a, new HashSet<>());
		cycleEdges.add(b);
		cycles.put(a, cycleEdges);

		cycleEdges = cycles.getOrDefault(b, new HashSet<>());
		cycleEdges.add(a);
		cycles.put(b, cycleEdges);
	}

}
