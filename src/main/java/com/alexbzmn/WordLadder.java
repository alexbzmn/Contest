package com.alexbzmn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordLadder {

	public static void main(String[] args) {

		System.out.println(new WordLadder().ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
		System.out.println(new WordLadder().ladderLength("lap", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
		System.out.println(new WordLadder().ladderLength(
			"qa",
			"sq",
			Arrays.asList(
				"si",
				"go",
				"se",
				"cm",
				"so",
				"ph",
				"mt",
				"db",
				"mb",
				"sb",
				"kr",
				"ln",
				"tm",
				"le",
				"av",
				"sm",
				"ar",
				"ci",
				"ca",
				"br",
				"ti",
				"ba",
				"to",
				"ra",
				"fa",
				"yo",
				"ow",
				"sn",
				"ya",
				"cr",
				"po",
				"fe",
				"ho",
				"ma",
				"re",
				"or",
				"rn",
				"au",
				"ur",
				"rh",
				"sr",
				"tc",
				"lt",
				"lo",
				"as",
				"fr",
				"nb",
				"yb",
				"if",
				"pb",
				"ge",
				"th",
				"pm",
				"rb",
				"sh",
				"co",
				"ga",
				"li",
				"ha",
				"hz",
				"no",
				"bi",
				"di",
				"hi",
				"qa",
				"pi",
				"os",
				"uh",
				"wm",
				"an",
				"me",
				"mo",
				"na",
				"la",
				"st",
				"er",
				"sc",
				"ne",
				"mn",
				"mi",
				"am",
				"ex",
				"pt",
				"io",
				"be",
				"fm",
				"ta",
				"tb",
				"ni",
				"mr",
				"pa",
				"he",
				"lr",
				"sq",
				"ye")));

	}

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Map<String, List<String>> map = new HashMap<>();
		for (String word : wordList) {
			for (int i = 0; i < beginWord.length(); i++) {
				String template = word.substring(0, i) + "*" + word.substring(i + 1, beginWord.length());
				List<String> list = map.getOrDefault(template, new ArrayList<>());
				list.add(word);
				map.put(template, list);
			}
		}

		LinkedList<String> q = new LinkedList<>();
		Set<String> v = new HashSet<>();
		v.add(beginWord);
		q.add(beginWord);

		Map<String, Integer> c = new HashMap<>();
		c.put(beginWord, 1);

		while (!q.isEmpty()) {
			String w = q.pop();

			for (int i = 0; i < beginWord.length(); i++) {
				String template = w.substring(0, i) + "*" + w.substring(i + 1, beginWord.length());
				List<String> adj = map.getOrDefault(template, new ArrayList<>());
				for (String adjWord : adj) {
					if (adjWord.equals(endWord)) {
						return c.get(w) + 1;
					} else {
						if (!v.contains(adjWord)) {
							v.add(adjWord);
							q.add(adjWord);
							c.put(adjWord, c.get(w) + 1);
						}
					}
				}
			}
		}

		return 0;
	}
}
