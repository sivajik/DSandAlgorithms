package com.gfg.ds.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Prob05_StockSpan {
	// this is same as nearest greater to LEFT problem 
	// but we need index of that value rather value itself
	// once we have such index do currIndex - NGL Index to get the span.
	public static void main(String[] args) {
		int[] arr = new int[] { 100, 80, 60, 70,60, 75, 85 };
		Stack<Pair> s = new Stack<Pair>();
		List<Pair> result = new ArrayList<>();
		
		for (int i = 0; i < arr.length; i++) {
			if (s.isEmpty()) {
				result.add(new Pair(i, -1));
			} else if (s.size() > 0 && s.peek().val > arr[i]) {
				result.add(s.peek());
			} else if (s.size() > 0 && s.peek().val <= arr[i]) {

				while (s.size() > 0 && s.peek().val <= arr[i]) {
					s.pop();
				}
				if (s.size() == 0) {
					result.add(new Pair(i, -1));
				} else {
					result.add(s.peek());
				}
			}
			s.push(new Pair(i,arr[i]));
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(Math.abs(i - result.get(i).index) + " ");
		}
	}

	static class Pair {
		int index;
		int val;
		
		Pair(int a, int b) {
			this.index = a;
			this.val = b;
		}
	}
}
