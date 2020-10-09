package com.gfg.ds.heap;

import java.util.PriorityQueue;

public class Prob01_01_Demo {

	public static void main(String[] args) {
		PriorityQueue<Integer> p = new PriorityQueue<>();
		p.add(2);
		p.add(6);
		p.add(0);
		p.add(3);
		p.add(1);
		p.add(4);
		
		while (!p.isEmpty()) {
			System.out.println(p.poll());
		}
	}

}
