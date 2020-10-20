package com.gfg.algorithms.swapsort;

public class Prob02_FindMissingDoops_SwapSort {

	public static void main(String[] args) {
		int[] a = new int[] { 2, 3, 1, 8, 2, 3, 5, 1 };
		int i = 0;
		while (i < a.length) {
			if (a[i] != a[a[i] - 1]) {
				int temp = a[i];
				a[i] = a[a[i] - 1];
				a[temp - 1] = temp; // very imp to use temp-1 as a[i] is updated above
			} else {
				i++;
			}
		}

		for (i = 0; i < a.length; i++) {
			if (i + 1 != a[i]) {
				System.out.println("Missing: " + (i + 1));
				System.out.println("Duplication: " + a[i]);
			}
		}
	}
}
