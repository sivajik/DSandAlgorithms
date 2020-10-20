package com.gfg.algorithms.swapsort;

public class Prob01_FindMissingAndDuplicateNumber_1toN {

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 5, 3, 4, 5 };

		int n = 5; // sum of 1->5 = 15

		int sum = 0;
		for (int e : arr) {
			sum += e;
		} // a+e+c+d+e

		int sumSq = 0;
		for (int e : arr) {
			sumSq += (e * e);
		} // a2+e2+c2+d2+e2

		int normalSqSum = 0;
		for (int i = 1; i <= 5; i++) {
			normalSqSum += (i * i);
		} // s2+b2+c2+d2+e2

		// a2 + b2 + c2+ d2+ e2 - [a2+e2+c2+d2+e2] => b2-e2
		int bPlusE = (normalSqSum - sumSq) / (15 - sum); // (b2-e2)/ (a+b+c+d+e-a-e-c-d-e)
		System.out.println("b + e = " + bPlusE);
		
		int bMinuse = 15 - sum ;// a+b+c+d+e-a-e-c-d-e
		System.out.println("b - e = " + bMinuse);
		
		int b = (bPlusE + bMinuse) / 2;
		int e = (bPlusE - b);
		
		System.out.println("b = " + b);
		System.out.println("e = " + e);
	}

}
