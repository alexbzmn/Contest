package com.alexbzmn;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class KFrequentWords {

	public static void main(String[] args) {
		//		System.out.println(new KFrequentWords().topKFrequent(new String[] { "i", "love", "leetcode", "i", "love", "coding" }, 2));
		System.out.println(new KFrequentWords().topKFrequent(new String[] { "i", "love", "leetcode", "i", "love", "coding" }, 1));
		//		System.out.println(new KFrequentWords().topKFrequent(new String[] { "the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is" }, 4));
	}

	public List<String> topKFrequent(String[] words, int k) {

		// create a counts hashmap
		// nlogn = sort keys based on value or key value on ties
		// nlogk = partition map around occurrences value with lex order on ties

		Map<String, Integer> c = new HashMap<>();
		for (int i = 0; i < words.length; i++) {
			c.put(words[i], c.getOrDefault(words[i], 0) + 1);
		}

		List<String> list = new ArrayList<>(c.keySet());
		partitionKeys(list, c, 0, list.size() - 1, k - 1);

		Map<Integer, List<String>> l = new HashMap<>();
		for (Map.Entry<String, Integer> entry : c.entrySet()) {
			List<String> w = l.getOrDefault(entry.getValue(), new ArrayList<>());
			w.add(entry.getKey());
			l.put(entry.getValue(), w);
		}

		List<String> res = new ArrayList<>();
		for (int i = 0; i <= k - 1; i++) {
			res.add(list.get(i));
		}

		String minW = res.stream().min((o1, o2) -> -c.get(o1).compareTo(c.get(o2))).get();
		List<String> strings = l.get(c.get(minW));
		strings.sort(Comparator.naturalOrder());



		return res.stream().sorted((a, b) -> {
			int v = -c.get(a).compareTo(c.get(b));
			return v != 0 ? v : a.compareTo(b);
		}).collect(Collectors.toList());
	}

	private int partitionKeys(List<String> keys, Map<String, Integer> c, int low, int high, int k) {
		int p = partition(keys, c, low, high);
		if (p == k) {
			return p;
		} else if (p > k) {
			return partitionKeys(keys, c, low, p - 1, k);
		} else {
			return partitionKeys(keys, c, p + 1, high, k);
		}
	}

	private int partition(List<String> keys, Map<String, Integer> c, int low, int high) {
		int p = (low + high) / 2;
		int pVal = f(p, keys, c);
		swap(p, high, keys);

		int start = low;
		int i = low;
		while (i < high) {
			if (f(i, keys, c) > pVal) {
				swap(i, start, keys);
				start++;
			}

			i++;
		}

		swap(start, high, keys);
		return start;
	}

	private int f(int i, List<String> keys, Map<String, Integer> c) {
		return c.get(keys.get(i));
	}

	private void swap(int a, int b, List<String> list) {
		String buf = list.get(a);
		list.set(a, list.get(b));
		list.set(b, buf);
	}
}
