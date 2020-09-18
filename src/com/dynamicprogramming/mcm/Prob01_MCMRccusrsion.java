package com.dynamicprogramming.mcm;

public class Prob01_MCMRccusrsion {

	public static void main(String[] args) {
		int[] ip = new int[] { 40, 20, 30, 10, 30 };
		int i = 1;
		int j = ip.length - 1;
		System.out.println(calcMatrixMulCost(ip, i, j));
	}

	static int min = Integer.MAX_VALUE;

	static int calcMatrixMulCost(int[] arr, int i, int j) {
		if (i >= j) {
			return 0;
		}
		for (int k = i; k <= j - 1; k++) {
			int tempAns = calcMatrixMulCost(arr, i, k) + calcMatrixMulCost(arr, k + 1, j)
					+ arr[i - 1] * arr[k] * arr[j];
			if (tempAns < min) {
				min = tempAns;
			}
		}
		return min;
	}
}
