package com.recusion;

import java.util.Stack;

public class Prob05_ReverseStackUsingRecursion {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		System.out.println(stack);
		reverseStack(stack);
		System.out.println(stack);
	}

	private static void reverseStack(Stack<Integer> s) {
		if (s.size() == 0) {
			return;
		}
		int lastValue = s.pop();
		reverseStack(s);
		// s.add(0, lastValue);
		insertAtStart(s, lastValue);
	}

	private static void insertAtStart(Stack<Integer> s, int lastValue) {
		if (s.size() == 0) {
			s.push(lastValue);
			return;
		}
		int lastEle = s.pop();
		insertAtStart(s, lastValue);
		s.push(lastEle);

	}
}
