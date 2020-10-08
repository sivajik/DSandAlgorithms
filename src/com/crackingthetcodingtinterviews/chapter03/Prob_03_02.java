package com.crackingthetcodingtinterviews.chapter03;

import java.util.Stack;

public class Prob_03_02 {
	public static void main(String[] args) {
		StackWithMin s = new StackWithMin();
		s.push(5);
		s.push(6);
		s.push(3);
		s.push(7);
		System.out.println(s.pop() + "," + s.min());
		System.out.println(s.pop() + "," + s.min());
	}
}

class StackWithMin extends Stack<Integer> {
	Stack<Integer> minStack;

	public StackWithMin() {
		this.minStack = new Stack<>();
	}

	public void push(int i) {
		if (i <= min()) {
			minStack.push(i);
		}
		super.push(i);
	}

	public Integer pop() {
		int value = super.pop();
		if (value == min()) { // no way value can be less than min()
			minStack.pop();
		}
		return value;
	}

	public int min() {
		if (minStack.isEmpty()) {
			return Integer.MAX_VALUE;
		} else {
			return minStack.peek();
		}
	}
}