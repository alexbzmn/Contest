package com.alexbzmn;

import java.util.HashMap;
import java.util.Map;

public class LRUCache2 {
	// invariant 1 = key to be removed next is always the head of the list

	public static void main(String[] args) {
		LRUCache2 lruCache2 = new LRUCache2(2);
//		lruCache2.put(1, 1);
//		lruCache2.put(2, 2);
//		lruCache2.get(1);
//		lruCache2.put(3, 3);
//		lruCache2.get(2);
//		lruCache2.put(4, 4);
//		lruCache2.get(1);
//		lruCache2.get(3);
//		lruCache2.get(4);

		lruCache2.get(2);
		lruCache2.get(2);
		lruCache2.put(2, 6);
		lruCache2.get(1);
		lruCache2.put(1, 5);
		lruCache2.put(1, 2);
		lruCache2.get(1);
		lruCache2.get(2);
	}

	private static class Node {

		private Node prev;

		private Node next;

		private Integer key;

		private Node(Integer key) {
			this.key = key;
		}
	}

	private Map<Integer, Integer> keyVal = new HashMap<>();

	private Map<Integer, Node> keyNode = new HashMap<>();

	private Node head;

	private Node tail;

	private int capacity;

	public LRUCache2(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {
		if (!this.keyVal.containsKey(key)) {
			return -1;
		}

		Node node = this.keyNode.get(key);

		this.excludeNode(node);
		this.renewNode(node);
		return this.keyVal.get(key);
	}

	public void put(int key, int value) {
		Node node = this.keyNode.getOrDefault(key, new Node(key));
		if (keyNode.containsKey(key)) {
			this.excludeNode(node);
		}

		// here the node should be excluded from the list

		if (!this.keyVal.containsKey(key) && this.keyVal.size() == capacity) {
			this.keyVal.remove(this.head.key);
			this.keyNode.remove(this.head.key);
			this.excludeNode(this.head);
		}

		this.keyVal.put(key, value);
		this.keyNode.put(key, node);
		renewNode(node);
	}

	private void renewNode(Node node) {
		if (this.tail == null) {
			this.tail = node;
			this.head = node;
		} else {
			this.tail.next = node;
			node.prev = this.tail;
			this.tail = node;
			this.tail.next = null;
		}
	}

	private void excludeNode(Node node) {
		if (head == node) {
			head = head.next;
			head.prev = null;
			if (node == tail) {
				tail = null;
			}
		} else {
			node.prev.next = node.next;
			if (node.next == null) {
				this.tail = node.prev;
			} else {
				node.next.prev = node.prev;
			}
		}
	}

}
