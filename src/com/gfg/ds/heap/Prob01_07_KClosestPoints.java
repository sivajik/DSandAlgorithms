package com.gfg.ds.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Prob01_07_KClosestPoints {
	// K closest is "min" distance to centre
	// means use max heap to chop out far away points
	public static void main(String[] args) {
		PriorityQueue<Pair> p = new PriorityQueue<>(new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				return (int) (-o1.dist + o2.dist);
			}
		});

		int[][] arr = new int[][] { { 1, 3 }, { -2, 2 }, { 5, 8 }, { 0, 1 } };
		int k = 2;
		for (int[] eachPoint : arr) {
			p.add(new Pair(eachPoint[0], eachPoint[1],
					Math.sqrt((eachPoint[0] * eachPoint[0]) + (eachPoint[1] * eachPoint[1]))));
			if (p.size() > k) {
				p.poll();
			}
		}

		while (!p.isEmpty()) {
			System.out.println(p.peek().x + " , " + p.peek().y + " by dis: " + p.peek().dist);
			p.poll();
		}
	}

	static class Pair {
		int x;
		int y;
		double dist;

		Pair(int a, int b, double d) {
			this.x = a;
			this.y = b;
			this.dist = d;
		}
	}
}
