package com.gfg.ds.stack;

import java.util.Arrays;

public class Prob08_RainWaterTapping {
	// find the Max of left, Max of right of each element
	// and do a min of it to know its area.
	public static void main(String[] args) {
		int[] arr = new int[] { 3, 0, 0, 2, 0, 4 };

		int[] mxL = new int[arr.length];
		int[] mxR = new int[arr.length];

		mxL[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			mxL[i] = Math.max(arr[i], mxL[i - 1]);
		}

		mxR[arr.length - 1] = arr[arr.length - 1];
		for (int i = arr.length - 2; i >= 0; i--) {
			mxR[i] = Math.max(arr[i], mxR[i + 1]);
		}

		System.out.println(Arrays.toString(mxL));
		System.out.println(Arrays.toString(mxR));

		int[] wid = new int[arr.length];
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			wid[i] = Math.min(mxL[i], mxR[i]) - arr[i];
			sum += wid[i];
		}
		System.out.println(sum);
	}

}
