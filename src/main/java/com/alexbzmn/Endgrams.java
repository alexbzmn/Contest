package com.alexbzmn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Endgrams {

	public static void main(String[] args) {

		generateEndGrams(new ArrayList<String>() {{
			add("one");
			add("two");
			add("three");
		}}, 3);
	}

	private static void generateEndGrams(List<String> words, int size) {
		LinkedList<String> queue = new LinkedList<>();
		for (String word : words) {
			queue.addLast(word);

			if (queue.size() > size) {
				queue.removeFirst();
			}

			if (queue.size() == size) {
				System.out.println(queue);
			}
		}

	}

}
