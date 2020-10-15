package com.gfg.ds.stack;

import java.util.Stack;

public class Prob10_MinStackWithConstantSpace {
	// cosntant space.
	// try with 5 7 and 5 3
	public static void main(String[] args) {
		int[] arr = new int[] { 18, 19, 29, 15, 16 };

		for (int i = 0; i < arr.length; i++) {
			push(arr[i]);
		}
		System.out.println(pop() + ", " + getMin());
		System.out.println(pop() + ", " + getMin());
		System.out.println(pop() + ", " + getMin());
		System.out.println(pop() + ", " + getMin());
		System.out.println(pop() + ", " + getMin());
	}

	static Stack<Integer> s = new Stack<>();
	static int minElem;

	public static void push(int i) {
		if (s.isEmpty()) {
			minElem = i;
			s.push(i);
		} else {
			// if we are pushing > minElem then no change to min
			// else push 2*elem-minelem to push
			if (i >= minElem) {
				// don't do
				s.push(i);
			} else {
				s.push(2 * i - minElem);
				minElem = i;
			}
		}
	}

	public static int pop() {
		if (!s.isEmpty()) {

			if (s.peek() >= minElem) {
				return s.pop();
			} else {
				minElem = 2 * minElem - s.peek();
				return s.pop();
			}
		} else {
			return -1;
		}
	}

	public static int top() {
		if (s.size() == 0) {
			return -1;
		} else if (s.peek() > minElem) {
			return s.peek();
		} else {
			return minElem;
		}
	}

	public static int getMin() {
		if (s.isEmpty()) {
			return -1;
		}
		return minElem;
	}
}