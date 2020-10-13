package com.gfg.ds.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Prob06_MaximumAreaHistogram {
	// this is same as difference between "Nearest Smallest Right"
	// minus "Nearest Smallest Left" and minus 1
	// this will give width then multiply by hiehgt of the building
	public static void main(String[] args) {
		int[] arr = new int[] { 6, 2, 5, 4, 5, 1, 6 };

		List<Integer> nsrIndexes = getNSRIndexes(arr);
		List<Integer> nslIndexes = getNSLIndexes(arr);

		System.out.println(nsrIndexes);
		System.out.println(nslIndexes);
		
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			max = Math.max(max, arr[i] * (nsrIndexes.get(i) - nslIndexes.get(i) - 1));
		}
		System.out.println(max);
	}

	public static List<Integer> getNSLIndexes(int[] arr) {
		Stack<Pair> s = new Stack<Pair>();
		List<Pair> result = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {
			if (s.isEmpty()) {
				result.add(new Pair(-1, arr[i]));
			} else if (s.size() > 0 && s.peek().val < arr[i]) {
				result.add(s.peek());
			} else if (s.size() > 0 && s.peek().val >= arr[i]) {

				while (s.size() > 0 && s.peek().val >= arr[i]) {
					s.pop();
				}
				if (s.size() == 0) {
					result.add(new Pair(-1, arr[i]));
				} else {
					result.add(s.peek());
				}
			}
			s.push(new Pair(i, arr[i]));
		}
		List<Integer> l = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			l.add(result.get(i).index);
		}
		return l;
	}

	public static List<Integer> getNSRIndexes(int[] arr) {
		Stack<Pair> s = new Stack<Pair>();
		List<Pair> result = new ArrayList<>();

		for (int i = arr.length - 1; i >= 0; i--) {
			if (s.isEmpty()) {
				result.add(new Pair(-1, arr[i]));
			} else if (s.size() > 0 && s.peek().val < arr[i]) {
				result.add(s.peek());
			} else if (s.size() > 0 && s.peek().val >= arr[i]) {

				while (s.size() > 0 && s.peek().val >= arr[i]) {
					s.pop();
				}
				if (s.size() == 0) {
					result.add(new Pair(-1, arr[i]));
				} else {
					result.add(s.peek());
				}
			}
			s.push(new Pair(i, arr[i]));
		}
		List<Integer> l = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			l.add(result.get(i).index == -1 ? arr.length : result.get(i).index);
		}
		Collections.reverse(l);
		return l;
	
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
