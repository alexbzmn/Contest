package com.alexbzmn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class MostVisitedSites {

	public static void main(String[] args) {
//		System.out.println(new MostVisitedSites().mostVisitedPattern(
//			new String[] { "joe", "joe", "joe", "james", "james", "james", "james", "mary", "mary", "mary" },
//			new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 },
//			new String[] { "home", "about", "career", "home", "cart", "maps", "home", "home", "about", "career" }));
//
//		System.out.println(new MostVisitedSites().mostVisitedPattern(
//			new String[] { "u1", "u1", "u1", "u2", "u2", "u2" },
//			new int[] { 1, 2, 3, 4, 5, 6 },
//			new String[] { "a", "b", "a", "a", "b", "c" }));

		//		["h","eiy","cq","h","cq","txldsscx","cq","txldsscx","h","cq","cq"]
		//[527896567,334462937,517687281,134127993,859112386,159548699,51100299,444082139,926837079,317455832,411747930]
		//["hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","yljmntrclw","hibympufi","yljmntrclw"]

		System.out.println(new MostVisitedSites().mostVisitedPattern(
			new String[] {
				"h",
				"eiy",
				"cq",
				"h",
				"cq",
				"txldsscx",
				"cq",
				"txldsscx",
				"h",
				"cq",
				"cq" },
			new int[] { 527896567, 334462937, 517687281, 134127993, 859112386, 159548699, 51100299, 444082139, 926837079, 317455832, 411747930 },
			new String[] {
				"hibympufi",
				"hibympufi",
				"hibympufi",
				"hibympufi",
				"hibympufi",
				"hibympufi",
				"hibympufi",
				"hibympufi",
				"yljmntrclw",
				"hibympufi",
				"yljmntrclw" }));

//		System.out.println(new MostVisitedSites().mostVisitedPattern(
//			new String[] {
//				"dowg", "dowg", "dowg" },
//			new int[] { 158931262, 562600350, 148438945 },
//			new String[] {
//				"y", "loedo", "y" }));
	}

	public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
		// user journey of 3 sites with maximum number of users visited

		// generate list-count combinations based on backtracking of forward sites visited by the users

		Map<String, List<Visit>> userVisits = new HashMap<>();

		for (int i = 0; i < username.length; i++) {
			List<Visit> visits = userVisits.getOrDefault(username[i], new ArrayList<>());
			visits.add(new Visit(timestamp[i], website[i]));
			userVisits.put(username[i], visits);
		}

		Map<List<String>, Integer> visitCount = new HashMap<>();

		for (String user : userVisits.keySet()) {
			List<Visit> visits = userVisits.get(user);
			visits.sort((o1, o2) -> {
				if (o1.time - o2.time == 0) {
					return 0;
				}

				return o1.time > o2.time ? 1 : -1;
			});

			if (visits.size() >= 3) {
				calculateVisitCount(visitCount, visits, new Stack<>(), 0);
			}
		}

		return visitCount.entrySet().stream().max((o1, o2) -> {
			int c = o1.getValue().compareTo(o2.getValue());
			if (c == 0) {
				String first = o1.getKey().stream().reduce((s1, s2) -> s1 + s2).get();
				String second = o2.getKey().stream().reduce((s1, s2) -> s1 + s2).get();
				return -first.compareTo(second);
			}

			return c;
		}).map(Map.Entry::getKey).get();
	}

	private void calculateVisitCount(Map<List<String>, Integer> visitCount, List<Visit> visits, Stack<String> comb, int start) {
		if (comb.size() == 3) {
			List<String> resultList = new ArrayList<>(comb);
			visitCount.put(resultList, visitCount.getOrDefault(resultList, 0) + 1);
			return;
		}

		for (int i = start; i < visits.size(); i++) {
			comb.add(visits.get(i).site);
			calculateVisitCount(visitCount, visits, comb, i + 1);
			comb.pop();
		}

	}

	private static class Visit {

		private int time;

		private String site;

		private Visit(int time, String site) {
			this.time = time;
			this.site = site;
		}
	}

}
