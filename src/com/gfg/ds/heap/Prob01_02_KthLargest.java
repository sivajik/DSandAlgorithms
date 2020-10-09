package com.gfg.ds.heap;

import java.util.PriorityQueue;

public class Prob01_02_KthLargest {
	// Kth largest (means make MinHeap - by default its min heap)
	public static void main(String[] args) {
		PriorityQueue<Integer> p = new PriorityQueue<>();

		int[] arr = new int[] { 7, 10, 4, 3, 20, 15 };
		int k = 3;
		int cnt = 0;
		for (; cnt < arr.length; cnt++) {
			p.add(arr[cnt]);

			if (p.size() > k) {
				p.poll();
			}
		}
		System.out.println(p.peek());
	}

}
