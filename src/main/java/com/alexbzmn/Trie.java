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

		add(trie, Arrays.asList("apple", "applet", "ap", "appstore", "aston", "bpple"));

		System.out.println();
	}

	private static void add(Trie trie, List<String> s) {
		for (String s1 : s) {
			trie.insert(s1);
		}
	}
	//apple, applet, ap, appstore, aston, bpple

	// new leaf is inserted after the existing key parent
	// new is equal to the parent
	// new leaf is inserted as split of an existing entry

	//
	//["Trie","insert","search","search","startsWith","insert","search"]
	//[[],["apple"],["apple"],["app"],["app"],["app"],["app"]]
	private Node root;

	/**
	 * Initialize your data structure here.
	 */
	public Trie() {
		this.root = new Node("", false);
	}

	private static class Node {

		private String val;

		private boolean isKey;

		private List<Node> nodes = new ArrayList<>();

		private Node(String val, boolean isKey) {
			this.val = val;
			this.isKey = isKey;
		}

		private void insert(String v) {
			if (v.equals(this.val)) {
				return;
			} else if (this.val.startsWith(v)) {
				Node newRoot = new Node(this.val, true);
				newRoot.nodes = this.nodes;

				this.nodes = new ArrayList<>();
				this.nodes.add(newRoot);
				this.val = v;
				return;
			}

			for (Node c : nodes) {
				if (v.startsWith(c.val) || c.val.startsWith(v)) {
					c.insert(v);
					return;
				} else {
					int i = 0;
					while (i < v.length() - 1) {
						if (v.charAt(i) == c.val.charAt(i)) {
							i++;
						} else {
							break;
						}
					}

					if (i > 0) {
						Node r = new Node(c.val, true);
						r.nodes = c.nodes;

						c.val = c.val.substring(0, i);
						c.nodes = new ArrayList<>();
						c.nodes.add(r);
						c.nodes.add(new Node(v, true));
						c.isKey = false;

						return;
					}
				}
			}

			if (v.startsWith(this.val)) {
				this.nodes.add(new Node(v, true));
			}
		}

		private boolean search(String word) {
			if (this.val.equals(word) && this.isKey) {
				return true;
			}

			for (Node n : this.nodes) {
				if (word.startsWith(n.val)) {
					return n.search(word);
				}
			}

			return false;
		}

		private boolean startsWith(String word) {
			if (this.val.startsWith(word)) {
				return true;
			}

			for (Node n : this.nodes) {
				if (n.val.startsWith(word)) {
					return true;
				}

				if (word.startsWith(n.val)) {
					return n.startsWith(word);
				}
			}

			return false;
		}
	}

	/**
	 * Inserts a word into the trie.
	 */
	public void insert(String word) {
		this.root.insert(word);
	}

	/**
	 * Returns if the word is in the trie.
	 */
	public boolean search(String word) {
		return this.root.search(word);
	}

	/**
	 * Returns if there is any word in the trie that starts with the given prefix.
	 */
	public boolean startsWith(String prefix) {
		return this.root.startsWith(prefix);
	}

}
