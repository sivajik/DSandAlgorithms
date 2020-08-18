package com.recusion;

import java.util.Stack;

public class Prob04_DeleteMiddleElementStackUsingRecursion {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		deleteMidElem(stack, 0, stack.size() / 2);
		System.out.println(stack);
	}

	private static void deleteMidElem(Stack<Integer> s, int counter, int size) {
		if (counter == size) {
			s.pop();
			return;
		}
		int lastValue = s.pop();
		deleteMidElem(s, 1 + counter, size);
		s.push(lastValue);
		return;
	}
}
