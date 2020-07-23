package com.alexbzmn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 * <p>
 * // @return true if this NestedInteger holds a single integer, rather than a nested list.
 * public boolean isInteger();
 * <p>
 * // @return the single integer that this NestedInteger holds, if it holds a single integer
 * // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 * <p>
 * // @return the nested list that this NestedInteger holds, if it holds a nested list
 * // Return null if this NestedInteger holds a single integer
 * public List<NestedInteger> getList();
 * }
 */

//[[[[1]]], 2]
//[[[1,2],3],4] (0, 0, 1) -> (0, 1) -> (1)
public class NestedIterator implements Iterator<Integer> {

	//[[1,1],2,[1,1]]
	public static void main(String[] args) {
		Map<Integer, Integer> count = new HashMap<>();

//		List<NestedInteger> list = List.of(
//			new NestedInteger(List.of(new NestedInteger(1), new NestedInteger(1))),
//			new NestedInteger(2),
//			new NestedInteger(List.of(new NestedInteger(1), new NestedInteger(1)))
//		);
//
//		List<NestedInteger> list1 = List.of(
//			new NestedInteger(List.of(new NestedInteger(List.of(new NestedInteger(List.of(new NestedInteger(List.of(new NestedInteger(1))))))))),
//			new NestedInteger(2)
//		);
//
//		List<NestedInteger> list2 = List.of(new NestedInteger(List.of(
//			new NestedInteger(List.of(new NestedInteger(1), new NestedInteger(2))),
//			new NestedInteger(3))), new NestedInteger(4));
//
//		//		List<NestedInteger> list3 = List.of(new NestedInteger(2));
//		List<NestedInteger> list4 = List.of(new NestedInteger(2));
//
//		//		NestedIterator iterator = new NestedIterator(list);
//		//		NestedIterator iterator = new NestedIterator(list1);
//		//		NestedIterator iterator = new NestedIterator(List.of(new NestedInteger(List.of()), new NestedInteger(1)));
//		NestedIterator iterator = new NestedIterator(List.of(new NestedInteger(List.of())));
//		//		NestedIterator iterator = new NestedIterator(list2);
//		while (iterator.hasNext()) {
//			System.out.println(iterator.next());
//		}
	}

	private Integer next;

	private List<NestedInteger> nested;

	private Stack<Integer> stack = new Stack<Integer>();

	private boolean finished = false;

	public NestedIterator(List<NestedInteger> nestedList) {
		this.nested = nestedList;
		this.next = getNext();
		this.finished = this.stack.isEmpty();
	}

	@Override
	public Integer next() {
		int val = next;

		if (this.finished) {
			next = null;
			return val;
		}

		next = getNext();
		this.finished = this.stack.isEmpty();

		return val;
	}

	@Override
	public boolean hasNext() {
		return (!this.finished || next != null);
	}

	private Integer getNext() {
		Integer val = getNext(this.nested);

		while (val == null && !this.stack.isEmpty()) {
			val = getNext(this.nested);
		}

		return val;
	}

	private Integer getNext(List<NestedInteger> list) {
		if (list.isEmpty()) {
			return null;
		}

		int pointer;
		if (stack.isEmpty()) {
			pointer = 0;
		} else {
			pointer = stack.pop();
		}

		NestedInteger e = list.get(pointer);
		if (e.isInteger()) {
			int val = e.getInteger();
			if (list.size() - 1 > pointer) {
				stack.push(++pointer);
			}
			return val;
		} else {
			Integer val = getNext(e.getList());
			if (list.size() - 1 > pointer) {
				if (stack.size() == 0) {
					stack.push(++pointer);
				} else {
					stack.push(pointer);
				}
			} else if (list.size() - 1 == pointer && stack.size() > 0) {
				stack.push(pointer);
			}

			return val;
		}
	}

	private static class NestedInteger {

		private List<NestedInteger> list = new ArrayList<>();

		private Integer val;

		private NestedInteger(Integer val) {
			this.val = val;
		}

		private NestedInteger(List<NestedInteger> list) {
			this.list = list;
		}

		public List<NestedInteger> getList() {
			return list;
		}

		public boolean isInteger() {
			return val != null;
		}

		public int getInteger() {
			return val;
		}

		@Override public String toString() {
			return val.toString();
		}
	}

}