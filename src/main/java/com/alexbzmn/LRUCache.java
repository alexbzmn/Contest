package com.alexbzmn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LRUCache {

	public static void main(String[] args) {
		//		LRUCache cache = new LRUCache(0 /* capacity */);
		//		cache.put(1, 1);
		//		cache.put(2, 2);
		//		cache.get(1);       // returns 1
		//		cache.put(3, 3);    // evicts key 2
		//		cache.get(2);       // returns -1 (not found)
		//		cache.put(4, 4);    // evicts key 1
		//		cache.get(1);       // returns -1 (not found)
		//		cache.get(3);       // returns 3
		//		cache.get(4);       // returns 4

		//		LRUCache cache = new LRUCache(2);
		//		cache.get(2);
		//		cache.put(2, 6);
		//		cache.get(1);
		//		cache.put(1, 5);
		//		cache.put(1, 2);
		//		cache.get(1);
		//		cache.get(2);

		//		LRUCache cache = new LRUCache(10);
		//		List<Integer> res = cache.parseString(
		//			"[[10,13],[3,17],[6,11],[10,5],[9,10],[13],[2,19],[2],[3],[5,25],[8],[9,22],[5,5],[1,30],[11],[9,12],[7],[5],[8],[9],[4,30],[9,3],[9],[10],[10],[6,14],[3,1],[3],[10,11],[8],[2,14],[1],[5],[4],[11,4],[12,24],[5,18],[13],[7,23],[8],[12],[3,27],[2,12],[5],[2,9],[13,4],[8,18],[1,7],[6],[9,29],[8,21],[5],[6,30],[1,12],[10],[4,15],[7,22],[11,26],[8,17],[9,29],[5],[3,4],[11,30],[12],[4,29],[3],[9],[6],[3,4],[1],[10],[3,29],[10,28],[1,20],[11,13],[3],[3,12],[3,8],[10,9],[3,26],[8],[7],[5],[13,17],[2,27],[11,15],[12],[9,19],[2,15],[3,16],[1],[12,17],[9,1],[6,19],[4],[5],[5],[8,1],[11,7],[5,2],[9,28],[1],[2,2],[7,4],[4,22],[7,24],[9,26],[13,28],[11,26]]");
		//
		//		System.out.println(res.stream().map(String::valueOf).collect(Collectors.joining(",")));

		LRUCache cache = new LRUCache(1);
		cache.put(2, 1);
		cache.get(2);
		cache.put(3, 2);
		cache.get(2);
		cache.get(3);

	}

	private List<Integer> parseString(String val) {
		String[] s2 = val.split("],");

		List<Integer> l = new ArrayList<>();
		for (String s : s2) {
			String[] sp = s.replace("[", "").replace("]", "").split(",");
			if (sp.length == 1) {
				l.add(get(Integer.parseInt(sp[0])));
				System.out.println("get " + Integer.parseInt(sp[0]) + " -> " + this.start.print());
			} else if (sp.length == 2) {
				put(Integer.parseInt(sp[0]), Integer.parseInt(sp[1]));
				l.add(null);
				System.out.println("put " + Integer.parseInt(sp[0]) + ", " + Integer.parseInt(sp[1]) + " -> " + this.start.print());
			}

		}
		return l;
	}

	private Node tail;

	private Node start;

	private Map<Integer, Node> map;

	private int capacity;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.map = new HashMap<>(capacity);
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			Node n = map.get(key);
			refresh(n);
			return n.val;
		} else {
			return -1;
		}
	}

	public void put(int key, int value) {
		if (capacity == 0) {
			return;
		}

		boolean exists = map.containsKey(key);
		if (map.size() == capacity && !exists) {
			map.remove(start.key);
			start = start.next;
			if (start != null) {
				start.prev = null;
			}
		}

		if (exists) {
			update(key, value);
		} else {
			add(key, value);
		}

	}

	private void update(int key, int val) {
		Node n = map.get(key);
		n.val = val;
		refresh(n);
	}

	private void add(int key, int val) {
		Node n = new Node(key, val);
		map.put(key, n);
		if (tail != null) {
			tail.next = n;
			n.prev = tail;
		}

		tail = n;
		if (start == null) {
			start = tail;
		}
	}

	private void refresh(Node n) {
		if (tail == n) {
			return;
		}

		if (n.next != null && n.prev != null) {
			n.prev.next = n.next;
			n.next.prev = n.prev;
		} else if (start == n && n.next != null) {
			start = n.next;
			start.prev = null;
		}

		n.prev = tail;
		n.next = null;
		tail.next = n;
		tail = n;
	}

	private static class Node {

		private int key;

		private int val;

		private Node next;

		private Node prev;

		private Node(int key, int val) {
			this.key = key;
			this.val = val;
		}

		@Override public String toString() {
			return "[" + key + "," + val + ']';
		}

		public String print() {
			StringBuilder sb = new StringBuilder();
			sb.append(this.toString());
			Node next = this.next;
			while (next != null) {
				sb.append(next.toString());
				next = next.next;
			}
			return sb.toString();
		}

	}

}
