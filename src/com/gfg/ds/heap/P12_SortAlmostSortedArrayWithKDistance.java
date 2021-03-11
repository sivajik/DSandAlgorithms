package com.gfg.ds.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class P12_SortAlmostSortedArrayWithKDistance {

	public static void main(String[] args) {
		int k = 3;
		int arr[] = { 2, 6, 3, 12, 56, 8 };
		int n = arr.length;
		kSort(arr, n, k);
	}

	private static void kSort(int[] arr, int n, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < k + 1; i++) {
			pq.add(arr[i]);
		}
		List<Integer> l = new ArrayList<>();
		for (int i = k + 1; i < arr.length; i++) {
			l.add(pq.poll());
			pq.add(arr[i]);
		}
		while (!pq.isEmpty()) {
			l.add(pq.poll());
		}
		System.out.println(l);
	}

}
