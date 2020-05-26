package com.alexbzmn;

import java.util.*;

public class CourseSchedule2 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(new CourseSchedule2().findOrder(2, new int[][] { new int[] { 0, 1 }})));
		System.out.println(Arrays.toString(new CourseSchedule2().findOrder(3, new int[][] { new int[] { 1, 0 }, new int[] { 2, 1 } })));
		System.out.println(Arrays.toString(new CourseSchedule2().findOrder(
			8,
			new int[][] {
				new int[] { 1, 0 },
				new int[] { 2, 6 },
				new int[] { 1, 7 },
				new int[] { 6, 4 },
				new int[] { 7, 0 },
				new int[] { 0, 5 } })));
	}

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		Map<Integer, List<Integer>> m = new HashMap<>();
		int[] res = new int[numCourses];

		for (int i = 0; i < prerequisites.length; i++) {
			List<Integer> l = m.getOrDefault(prerequisites[i][0], new ArrayList<>());
			l.add(prerequisites[i][1]);
			m.put(prerequisites[i][0], l);
		}

		Set<Integer> seen = new HashSet<>();
		LinkedList<Integer> q = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			if (cycle(i, m, new HashSet<>(), q, seen)) {
				return new int[0];
			}
		}

		for (int i = 0; i < res.length; i++) {
			res[i] = q.pop();
		}

		return res;
	}

	private boolean cycle(int i, Map<Integer, List<Integer>> m, Set<Integer> v, LinkedList<Integer> q, Set<Integer> seen)
	{
		List<Integer> edges = m.get(i);
		if (edges == null || edges.size() == 0) {
			if (!seen.contains(i)) {
				q.add(i);
				seen.add(i);
			}

			return false;
		}

		v.add(i);
		for (int e : edges) {
			if (v.contains(e)) {
				return true;
			} else {
				if (cycle(e, m, v, q, seen)) {
					return true;
				}
			}
		}

		if (!seen.contains(i)) {
			q.add(i);
			seen.add(i);
		}

		v.remove(i);
		return false;
	}

}
