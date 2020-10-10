package com.gfg.ds.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Prob01_09_SumOfNumberBetweenK1andK2 {
	// find K1 smallest, K2 smallest and loop for numbers between them and add
	public static void main(String[] args) {
		int[] arr = new int[] { 1, 3, 12, 5, 15, 11 };
		int a = findKthSmallest(arr, 3);
		int b = findKthSmallest(arr, 6);
		System.out.println(a + " , " + b);
		int sum = 0;
		for (int elem : arr) {
			if (elem > a && elem < b) {
				sum += elem;
			}
		}
		System.out.println(sum);
	}

	private static int findKthSmallest(int[] arr, int k) {
		PriorityQueue<Integer> p = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return -o1 + o2;
			}
		});

		for (int elem : arr) {
			p.add(elem);
			if (p.size() > k) {
				p.poll();
			}
		}

		return p.peek();
	}

}
