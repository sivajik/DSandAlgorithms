package com.recusion;

import java.util.Arrays;

public class Prob12_JosephusProblem {

	public static void main(String[] args) {
		int n = 40;
		int k = 7;

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = i + 1;
		}
		System.out.println(solve(arr, k - 1, 0));

	}

	public static int solve(int[] arr, int k, int startAt) {
		if (arr.length == 1) {
			return arr[0];
		}
		int positionToPlace = (startAt + k) % arr.length;
		for (int i = positionToPlace; i < arr.length-1; i++) {
			arr[i] = arr[i+1]; 
		}
		arr = Arrays.copyOf(arr, arr.length-1);
		return solve(arr, k, positionToPlace);
		
	}
}
