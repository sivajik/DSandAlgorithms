package com.gfg.ds.heap;

import java.util.PriorityQueue;

public class Prob01_08_ConnectRopesToMinimiseCost {
	// everytime take LESS two values and add them push to heap
	public static void main(String[] args) {
		PriorityQueue<Integer> p = new PriorityQueue<>();

		int[] arr = new int[] { 1, 2, 3, 4, 5 };
		for (int elem : arr) {
			p.add(elem);
		}

		int totalCost = 0;
		int cumCost = 0;

		while (p.size() > 1) {
			totalCost = p.poll() + p.poll();
			p.add(totalCost);
			cumCost += totalCost;
		}
		System.out.println(cumCost);
	}

}
