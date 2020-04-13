package com.alexbzmn.util;

import java.util.LinkedList;
import java.util.List;

public class Node {

	public Integer val;

	public Node random;

	public Node next;

	public List<Node> edges = new LinkedList<>();

	public Node(Integer val) {
		this.val = val;
	}

	public Node() {
	}
}
