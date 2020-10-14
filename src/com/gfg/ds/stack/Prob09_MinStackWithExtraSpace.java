package com.gfg.ds.stack;

import java.util.Stack;

public class Prob09_MinStackWithExtraSpace {
	// keep supporting stack keeps so far min elem.
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
	static Stack<Integer> ss = new Stack<>(); // supporting stack

	public static void push(int i) {
		s.push(i);
		if (s.isEmpty()) {
			ss.push(i);
		} else {
			if (i <= ss.peek()) { // must keep = so that if same elements are coming we are good
				ss.push(i);
			}
		}
	}

	public static int pop() {
		if (!s.isEmpty()) {
			int i = s.pop();
			if (ss.peek() == i) {
				ss.pop();
			}
			return i;
		} else {
			return -1;
		}
	}
	
	public static int getMin() {
		if (ss.isEmpty()) {
			return -1;
		}
		return ss.peek();
	}
}
