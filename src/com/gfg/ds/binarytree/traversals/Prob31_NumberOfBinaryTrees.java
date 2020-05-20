package com.gfg.ds.binarytree.traversals;

public class Prob31_NumberOfBinaryTrees {

	public static void main(String[] args) {
		int n = 5;
		int[] BT = new int[n + 1];
		BT[0] = 1;
		BT[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				BT[i] += BT[j] * BT[i - j - 1];
			}
		}
		System.out.println(BT[n]);
	}

	/*
	 (2n) !
	 ------
	 (n)! * (n+1)!
	 */
}
