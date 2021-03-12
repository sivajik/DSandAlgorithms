package com.gfg.ds.heap;

import java.util.PriorityQueue;

public class P16_ConnectN_Ropes {

	public static void main(String[] args) {
		int len[] = { 4, 3, 2, 6 };
		int size = len.length;

		System.out.println("Total cost for connecting ropes is " + minCost(len, size));

	}

	private static int minCost(int[] len, int size) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int eachLen : len) {
			pq.add(eachLen);
		}
		int totalCost = 0;
		while (pq.size() > 1) { // imp: we do 2 polls.
			int fLow = pq.poll();
			int sLow = pq.poll();

			totalCost += (fLow + sLow);
			pq.add(fLow + sLow);
		}

		return totalCost;
	}

}
