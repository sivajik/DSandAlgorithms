package com.gfg.ds.heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Prob01_06_FrequencySort {
	// Frequency in Descending order means, top freq at the top mean max heap
	public static void main(String[] args) {
		PriorityQueue<Pair> p = new PriorityQueue<>(new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				if (o1.freq == o2.freq) {
					return o1.val - o2.val;
				} else {
					return -o1.freq + o2.freq; // so that the one with max freq diff goes to top
				}
			}
		});

		int[] arr = new int[] { 1, 1, 1, 3, 2, 2, 4 };

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				map.put(arr[i], 1 + map.get(arr[i]));
			} else {
				map.put(arr[i], 1);
			}
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			p.add(new Pair(entry.getKey(), entry.getValue()));
		}

		while (!p.isEmpty()) {
			Pair elem = p.poll();
			int fre = elem.freq;
			int val = elem.val;

			for (int i = 0; i < fre; i++) {
				System.out.println(val);
			}
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
