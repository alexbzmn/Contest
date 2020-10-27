package com.alexbzmn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {
	public List<Integer> partitionLabels(String S) {

		// as many as possible partitions
		// each letter only in one partition
		// count end index, set max part index on every new character and decide if I need to extend the partition

		Map<Character, Integer> m = new HashMap<>();
		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			m.put(c, i);
		}

		int maxIndex = 0;
		int minIndex = 0;
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < S.length(); i++) {

			if (maxIndex < i) {
				list.add(maxIndex + 1 - minIndex);
				maxIndex = i;
				minIndex = i;
			}

			maxIndex = Math.max(maxIndex, m.get(S.charAt(i)));
		}

		list.add(maxIndex + 1 - minIndex);

		return list;
	}

}
