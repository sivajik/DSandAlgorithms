package com.gfg.ds.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Prob01_03_KSortedArray {
	// Kth largest (means make MinHeap - by default its min heap)
	public static void main(String[] args) {
		PriorityQueue<Integer> p = new PriorityQueue<>();

		int[] arr = new int[] { 6, 5, 3, 2, 8, 10, 9 };
		int k = 3;

		for (int i = 0; i < k + 1; i++) {
			p.add(arr[i]);
		}
		List<Integer> l = new ArrayList<>();
		for (int i = k + 1; i < arr.length; i++) {
			l.add(p.poll());
			p.add(arr[i]);
		}
		while (!p.isEmpty()) {
			l.add(p.poll());
		}
		System.out.println(l);
	}

}
