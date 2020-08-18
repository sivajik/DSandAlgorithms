package com.recusion;

import java.util.Stack;

public class Prob03_SortStackUsingRecursion {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(2);
		stack.push(6);
		stack.push(0);
		stack.push(3);
		stack.push(1);
		stack.push(4);
		sort(stack);
		System.out.println(stack);

		Stack<Integer> s1 = new Stack<>();
		s1.push(0);
		s1.push(1);
		s1.push(5);
		insert(s1, 2);
		System.out.println(s1);

	}

	private static void sort(Stack<Integer> s) {
		if (s.size() == 1) {
			return;
		}
		int lastValue = s.pop();
		sort(s);
		insert(s, lastValue);
		return;
	}

	// 0 1 5 6
	private static void insert(Stack<Integer> s, int lastValue) {
		if (s.size() == 0 || s.get(s.size() - 1) <= lastValue) {
			s.push(lastValue);
			return;
		}

		int lv = s.pop();
		insert(s, lastValue);
		s.push(lv);
	}

}
