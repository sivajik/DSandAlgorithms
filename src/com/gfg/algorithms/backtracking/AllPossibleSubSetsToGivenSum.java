package com.gfg.algorithms.backtracking;

public class AllPossibleSubSetsToGivenSum {

	public static void main(String[] args) {
	    int N = 4;
        printSubSets(N,N,"");
	}

	private static void printSubSets(int n, int curr, String str) {
		if (curr == 0) {
			System.out.println(str);
			return;
		}
		
		for (int i = 1; i <= n; i++) {
			if (i <= curr) {
				printSubSets(n, curr-i, str + "" +i);
			}
		}
	}

}
