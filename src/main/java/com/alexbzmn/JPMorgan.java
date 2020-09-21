package com.alexbzmn;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class JPMorgan {

	public static void main(String[] args) {

		// handle multiple words in an input string
		// create tokens from the text, to list without commas and such lowercase
		// do the simple example of one two three with predictions
		// test the algorithm on the given text
		// handle various ngram lengths

//		System.out.println(new TypeAhead().autocomplete("2,the"));
		System.out.println(new TypeAhead().autocomplete("2,the"));
		//		System.out.println(new TypeAhead().autocomplete(2, "TWO"));
	}

	private static class TypeAhead {

		private static final String SOURCE_TEXT = "Mary had a little lamb its fleece was white as snow;\n"
			+ "And everywhere that Mary went, the lamb was sure to go.\n"
			+ "It followed her to school one day, which was against the rule;\n"
			+ "It made the children laugh and play, to see a lamb at school.\n"
			+ "And so the teacher turned it out, but still it lingered near,\n"
			+ "And waited patiently about till Mary did appear.\n"
			+ "\"Why does the lamb love Mary so?\" the eager children cry;\"Why, Mary loves the lamb, you know\" the teacher did reply.\"";

		final List<String> tokens;

		private TypeAhead() {
			tokens = prepareTokens();
		}

		private List<String> prepareTokens() {
			final List<String> tokens = new ArrayList<>();

			for (String word : SOURCE_TEXT.replaceAll("[^A-Za-z0-9 ]", " ").split("\\s")) {
				if (word.length() > 0) {
					tokens.add(word.toLowerCase());
				}
			}

			return tokens;
		}

		private String autocomplete(String input) {
			String[] args = input.split(",");
			return autocomplete(Integer.parseInt(args[0]), args[1]);
		}

		private String autocomplete(int n, String input) {
			Map<String, Double> nGram = generateNGram(input.toLowerCase(), n);

			List<String> sortedKeys = new ArrayList<>(nGram.keySet());
			sortedKeys.sort((o1, o2) -> {
				int val = -nGram.get(o1).compareTo(nGram.get(o2));
				if (val == 0) {
					return o1.compareTo(o2);
				}

				return val;
			});

			StringBuilder res = new StringBuilder();
			for (String key : sortedKeys) {
				Double val = nGram.get(key);
				res.append(key).append(',').append(String.format("%.3f", val)).append(';');
			}

			return res.substring(0, res.length() - 1);
		}

		private Map<String, Double> generateNGram(String input, int n) {
			Map<String, Double> result = new HashMap<>();
			int count = 0;

			LinkedList<String> queue = new LinkedList<>();
			for (String word : tokens) {
				queue.addLast(word);

				if (queue.size() > n) {
					queue.removeFirst();
				}

				if (queue.size() == n && queue.getFirst().equals(input)) {
					String key = String.join(" ", queue);
					key = key.substring(input.length() + 1);
					result.put(key, result.getOrDefault(key, 0.0) + 1d);
					count++;
				}
			}

			for (String key : result.keySet()) {
				result.put(key, result.get(key) / count);
			}

			return result;
		}
	}

}
