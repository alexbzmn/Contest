package com.alexbzmn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Trie {

	public static void main(String[] args) {
		Trie trie = new Trie();
		//		trie.insert("apple");
		//		System.out.println(trie.search("apple"));
		//		System.out.println(trie.search("app"));
		//		System.out.println(trie.startsWith("app"));
		//		trie.insert("app");
		//		System.out.println(trie.search("app"));

		add(trie, Arrays.asList("apple", "applet", "ap", "appstore", "appstoret", "appstoree", "aston", "bpple"));

		System.out.println();
	}

	private static void add(Trie trie, List<String> s) {
		for (String s1 : s) {
			trie.insert(s1);
		}
	}
	//apple, applet, ap, appstore, aston, bpple

	private Node root;

	public Trie() {
		this.root = new Node();
	}

	private static class Node {

		private static final int R = 26;

		private boolean isEnd;

		private Node[] nodes = new Node[R];

		private boolean containsKey(char c) {
			return nodes[c - 'a'] != null;
		}

		private void addKey(char c) {
			this.nodes[c - 'a'] = new Node();
		}

		private Node getKey(char c) {
			return this.nodes[c - 'a'];
		}

	}

	/**
	 * Inserts a word into the trie.
	 */
	public void insert(String word) {
		Node n = this.root;

		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);

			if (!n.containsKey(c)) {
				n.addKey(c);
			}

			n = n.getKey(c);
		}

		n.isEnd = true;
	}

	private Node getPrefix(String word) {
		Node n = this.root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (!n.containsKey(c)) {
				return null;
			} else {
				n = n.getKey(c);
			}
		}

		return n;
	}

	/**
	 * Returns if the word is in the trie.
	 */
	public boolean search(String word) {
		Node n = getPrefix(word);
		return n != null && n.isEnd;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given prefix.
	 */
	public boolean startsWith(String prefix) {
		return getPrefix(prefix) != null;
	}

}
