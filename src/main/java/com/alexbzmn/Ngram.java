package com.alexbzmn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public class Ngram {

	/**
	 * Iterate through each line of input.
	 */
	public static void main(String[] args) throws IOException {

		String s =
			"Mary had a little lamb its fleece was white as snow;\n" +
				"And everywhere that Mary went, the lamb was sure to go.\n" +
				"It followed her to school one day, which was against the rule;\n" +
				"It made the children laugh and play, to see a lamb at school.\n" +
				"And so the teacher turned it out, but still it lingered near,\n" +
				"And waited patiently about till Mary did appear.\n" +
				"\"Why does the lamb love Mary so?\" the eager children cry;\"Why, Mary loves the lamb, you know\" the teacher did reply.\"";

		List<String> allWords = new BufferedReader(new StringReader(s)).lines()
			.flatMap(line -> stream(line.split("\\s")))
			.map(w -> w.replaceAll("[^a-zA-Z]", "").toLowerCase())
			.filter(w -> !"".equals(w))
			.collect(toList());

		Set<Integer> differentN = new HashSet<>();

		class Entry {

			int n;

			LinkedList<String> input;

			Entry(int n, LinkedList<String> input) {
				this.n = n;
				this.input = input;
			}
		}

		List<Entry> requests = new ArrayList<>();

		InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
		BufferedReader in = new BufferedReader(reader);
		String line;
		while ((line = in.readLine()) != null) {

			int n = Integer.parseInt(line.substring(0, line.indexOf(",")));
			String words = line.substring(line.indexOf(","));

			List<String> wordsAsList = stream(words.split("\\s")).map(w -> w.replaceAll("[^a-zA-Z]", ""))
				.filter(w -> !"".equals(w)).collect(toList());

			differentN.add(n);

			requests.add(new Entry(n, new LinkedList<>(wordsAsList)));
			break;
		}

		Map<Integer, Map<LinkedList<String>, TreeMap<String, TreeSet<String>>>> globalGramFreq = new HashMap<>();

		for (Integer n : differentN) {

			List<LinkedList<String>> grams = buildGrams(n, allWords);

			Map<LinkedList<String>, List<String>> groupedByGram = new HashMap<>();

			for (LinkedList<String> gram : grams) {
				LinkedList<String> key = new LinkedList<>(gram);
				key.removeLast();

				groupedByGram.computeIfAbsent(key, __ -> new ArrayList<>()).add(gram.getLast());
			}

			Map<LinkedList<String>, TreeMap<String, TreeSet<String>>> result = new HashMap<>();

			groupedByGram.forEach((key, wordList) -> {
				Map<String, Integer> freq = new HashMap<>();
				for (String w : wordList) {
					freq.merge(w, 1, Integer::sum);
				}

				TreeMap<String, TreeSet<String>> freqStr = new TreeMap<>();
				freq.forEach((word, wordCount) -> {
					double f = ((double)wordCount) / wordList.size();
					freqStr
						.computeIfAbsent(String.format("%.3f", f), __ -> new TreeSet<>())
						.add(word);
				});

				result.put(key, freqStr);
			});

			globalGramFreq.put(n, result);
		}

		for (Entry request : requests) {

			Map<LinkedList<String>, TreeMap<String, TreeSet<String>>> gramMapForN = globalGramFreq.get(request.n);
			TreeMap<String, TreeSet<String>> gramFreq = gramMapForN.get(request.input);
			if (gramFreq == null) {
				System.out.println();
			} else {
				List<String> sb = new ArrayList<>();
				gramFreq.forEach((freq, words) -> {
					words.forEach(word -> sb.add(word + ":" + freq));
				});

				String result = String.join(";", sb);
				System.out.println(result);
			}
		}

	}

	private static List<LinkedList<String>> buildGrams(int n, List<String> allWords) {
		List<LinkedList<String>> grams = new ArrayList<>();

		LinkedList<String> currTuple = new LinkedList<>();
		for (String w : allWords) {
			currTuple.add(w);

			if (currTuple.size() == n) {

				grams.add(new LinkedList<>(currTuple));
				currTuple.removeFirst();
			}
		}

		if (currTuple.size() == n) {
			grams.add(currTuple);
		}
		return grams;
	}

}