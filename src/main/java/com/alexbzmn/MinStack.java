package com.alexbzmn;

import java.util.ArrayList;
import java.util.List;

public class MinStack {

	private List<StackNode> storage;

	/**
	 * initialize your data structure here.
	 */
	public MinStack() {
		this.storage = new ArrayList<>();
	}

	public void push(int x) {

		if (storage.isEmpty()) {
			storage.add(new StackNode(x, x));
		} else {
			StackNode top = storage.get(storage.size() - 1);
			int min = top.min < x ? top.min : x;
			storage.add(new StackNode(x, min));
		}

	}

	public void pop() {
		Integer topVal = storage.get(storage.size() - 1).val;
		storage.remove(storage.size() - 1);
	}

	public int top() {
		return storage.get(storage.size() - 1).val;
	}

	public int getMin() {
		return storage.get(storage.size() - 1).min;
	}

	private static class StackNode {

		int val;

		int min;

		private StackNode(int val, int min) {
			this.val = val;
			this.min = min;
		}
	}
}
