package com.gfg.ds.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Prob01_01_KthSmallest {
	// Kth smallest (means make MaxHeap)
	public static void main(String[] args) {
		PriorityQueue<Integer> p = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});

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
