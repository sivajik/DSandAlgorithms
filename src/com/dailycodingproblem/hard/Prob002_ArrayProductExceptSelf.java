package com.dailycodingproblem.hard;

import java.util.Arrays;

public class Prob002_ArrayProductExceptSelf {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(arrayProdExceptSelf(new int[] { 1, 2, 3, 4, 5 })));
		System.out.println(Arrays.toString(arrayProdExceptSelf(new int[] { 3, 2, 1 })));

		System.out.println(Arrays.toString(arrayProdExceptSelfFixedSpace(new int[] { 1, 2, 3, 4, 5 })));
		System.out.println(Arrays.toString(arrayProdExceptSelfFixedSpace(new int[] { 3, 2, 1 })));
	}

	public static int[] arrayProdExceptSelf(int[] nums) {
		System.out.println();
		int[] leftArray = new int[nums.length];
		int[] rightArray = new int[nums.length];
		int[] outputArray = new int[nums.length];

		leftArray[0] = 1;
		rightArray[rightArray.length - 1] = 1;

		for (int i = 1; i < leftArray.length; i++) {
			leftArray[i] = leftArray[i - 1] * nums[i - 1];
		}

		for (int i = rightArray.length - 2; i >= 0; i--) {
			rightArray[i] = rightArray[i + 1] * nums[i + 1];
		}

		for (int i = 0; i < leftArray.length; i++) {
			outputArray[i] = leftArray[i] * rightArray[i];
		}
		return outputArray;
	}

	public static int[] arrayProdExceptSelfFixedSpace(int[] nums) {
		System.out.println();
		int[] outputArray = new int[nums.length];
		Arrays.fill(outputArray, 1);

		int temp = 1;
		for (int i = 0; i < nums.length; i++) {
			outputArray[i] *= temp;
			temp *= nums[i];
		}

		temp = 1;
		for (int i = outputArray.length - 1; i >= 0; i--) {
			outputArray[i] *= temp;
			temp *= nums[i];
		}

		return outputArray;
	}
}
