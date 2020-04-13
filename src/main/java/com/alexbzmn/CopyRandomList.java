package com.alexbzmn;

import java.util.HashMap;
import java.util.Map;

import com.alexbzmn.util.Node;

public class CopyRandomList {

	public Node copyRandomList(Node head) {

		Map<Node, Node> onmb = new HashMap<>();
		Map<Node, Node> onmf = new HashMap<>();

		return copy(head, onmb, onmf);
	}

	private Node copy(Node head, Map<Node, Node> onmb, Map<Node, Node> onmf) {

		if (head == null) {
			return null;
		}

		Node newHead = new Node(head.val);

		if (onmf.containsKey(head)) {
			onmf.get(head).random = newHead;
		}

		if (head.random != null && head.random.equals(head)) {
			newHead.random = newHead;
		} else if (onmb.containsKey(head.random)) {
			newHead.random = onmb.get(head.random);
		} else {
			newHead.random = head.random;
			onmf.put(head.random, newHead);
		}

		onmb.put(head, newHead);

		newHead.next = copy(head.next, onmb, onmf);
		return newHead;
	}

}
