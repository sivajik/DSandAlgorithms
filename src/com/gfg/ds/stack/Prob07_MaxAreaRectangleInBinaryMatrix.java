package com.gfg.ds.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Prob07_MaxAreaRectangleInBinaryMatrix {
	// this is same as MAH but from matrix bottom to top as building
	public static void main(String[] args) {
		int[][] arr = new int[][] {
			{0,1,1,0},
			{1,1,1,1},
			{1,1,1,1},
			{1,1,0,0}
		};
		
		int n = 4, m = 4;
		int[] v = new int[n];
		for (int col = 0; col < m; col++) {
			v[col] = arr[0][col];
		}
		int mx = MAH(v);
		
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 0) {
					v[j] = 0;
				} else {
					v[j] = v[j] + arr[i][j];
				}
			}
			mx = Math.max(mx, MAH(v));
		}
		System.out.println(mx);
	}

	public static int MAH(int[] arr) {
		List<Integer> nsrIndexes = getNSRIndexes(arr);
		List<Integer> nslIndexes = getNSLIndexes(arr);

		// System.out.println(nsrIndexes);
		// System.out.println(nslIndexes);

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			max = Math.max(max, arr[i] * (nsrIndexes.get(i) - nslIndexes.get(i) - 1));
		}
		return max;
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
