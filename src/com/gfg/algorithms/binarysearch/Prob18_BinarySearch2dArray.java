package com.gfg.algorithms.binarysearch;

public class Prob18_BinarySearch2dArray {

	public static void main(String[] args) {
		int[][] arr = new int[][] { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 27, 29, 37, 48 }, { 32, 33, 39, 50 } };
		System.out.println(bs(arr, 29));
		System.out.println("====");
		System.out.println(bs(arr, 23));
	}

	public static int bs(int[][] arr, int ele) {
		// start at first row, last col then keep comparing
		int i = 0;
		int j = arr[0].length - 1;
		
		int n = arr.length;
		int m = arr[0].length;
		
		while (i >= 0 && i < n && j >= 0 && j < m) {
			System.out.println(arr[i][j]);
			if (ele == arr[i][j]) {
				return arr[i][j];
			} else if (ele < arr[i][j]) {
				j--;
			} else {
				i++;
			}
		}
		return -1;
	}
}
