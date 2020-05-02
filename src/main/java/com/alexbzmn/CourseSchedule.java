package com.alexbzmn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CourseSchedule {

	/*
		2
		[[1,0]]
		2
		[[1,0],[0,1]]
		5
		[[0,1],[1,3],[1,4],[3,2],[4,2]]
		5
		[[0,1],[0,2],[1,2],[1,3],[3,4],[4,1]]
		3
		[[0,1],[0,2],[1,2],[2,0]]
		3
		[[1,0],[2,1]]
	* */

	public static void main(String[] args) {
		System.out.println(new CourseSchedule().canFinish(3, new int[][] { new int[] { 1, 0 }, new int[] { 2, 1 } }));
		System.out.println(new CourseSchedule().canFinish(8,
			new int[][] {
				new int[] { 1, 0 },
				new int[] { 2, 6 },
				new int[] { 1, 7 },
				new int[] { 6, 4 },
				new int[] { 7, 0 },
				new int[] { 0, 5 } }));
	}

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		Map<Integer, List<Integer>> m = new HashMap<>();

		for (int i = 0; i < prerequisites.length; i++) {
			List<Integer> l = m.getOrDefault(prerequisites[i][0], new ArrayList<>());
			l.add(prerequisites[i][1]);
			m.put(prerequisites[i][0], l);
		}

		for (int i = 0; i < numCourses; i++) {

			if (cycle(i, m, new HashSet<>())) {
				return false;
			}

		}

		return true;
	}

	private boolean cycle(int i, Map<Integer, List<Integer>> m, Set<Integer> v) {
		List<Integer> edges = m.get(i);
		if (edges == null || edges.size() == 0) {
			return false;
		}

		v.add(i);
		for (int e : edges) {
			if (v.contains(e)) {
				return true;
			} else {
				if (cycle(e, m, v)) {
					return true;
				}
			}
		}

		v.remove(i);
		return false;
	}

}
