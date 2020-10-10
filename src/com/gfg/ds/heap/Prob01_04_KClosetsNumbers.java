package com.gfg.ds.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Prob01_04_KClosetsNumbers {
	// Kth Closest (means make maxHeap - as largest elements goes to top then we
	// can pop them as we dont need them.. by default its min heap)
	public static void main(String[] args) {
		PriorityQueue<Pair> p = new PriorityQueue<>(new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				// TODO Auto-generated method stub
				return -o1.diff + o2.diff; // so that the one max diff goes to top
			}
		});

		int[] arr = new int[] { 5, 6, 7, 8, 9 };
		int k = 3;
		int num = 7;

		for (int i = 0; i < arr.length; i++) {
			p.add(new Pair(arr[i], Math.abs(arr[i] - num)));
			if (p.size() > k) {
				p.poll();
			}
		}

		while (!p.isEmpty()) {
			System.out.println(p.poll().val);
		}
	}

	static class Pair {
		int val;
		int diff;

		Pair(int a, int b) {
			this.val = a;
			this.diff = b;
		}
	}
}
