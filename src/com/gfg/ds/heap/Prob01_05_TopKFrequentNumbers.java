package com.gfg.ds.heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Prob01_05_TopKFrequentNumbers {
	// top K Frequent means less frequency shoudl go out
	// means Min Heap we need to keep less freq on top of the heap for easy popping
	// out
	public static void main(String[] args) {
		PriorityQueue<Pair> p = new PriorityQueue<>(new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				// TODO Auto-generated method stub
				return o1.freq - o2.freq; // so that the one min freq diff goes to top
			}
		});

		int[] arr = new int[] { 1, 1, 1, 3, 2, 2, 4 };
		int k = 2;

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				map.put(arr[i], 1 + map.get(arr[i]));
			} else {
				map.put(arr[i], 1);
			}
		}

		for (Map.Entry<Integer, Integer>entry : map.entrySet()) {
			p.add(new Pair(entry.getKey(), entry.getValue()));
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
		int freq;

		Pair(int a, int b) {
			this.val = a;
			this.freq = b;
		}
	}
}
