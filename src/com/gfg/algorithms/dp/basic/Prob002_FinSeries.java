package com.gfg.algorithms.dp.basic;

public class Prob002_FinSeries {

	public static void main(String args[]) {
		int n = 9;
		System.out.println(fibMethod1(n));
		System.out.println(fibMethod2(n));
		System.out.println(fibMethod3(n));
	}

	private static int fibMethod3(int n) {
		// http://www.maths.surrey.ac.uk/hosted-sites/R.Knott/Fibonacci/fibFormula.html
		double phi = (1 + Math.sqrt(5)) / 2;
		return (int) Math.round(Math.pow(phi, n) / Math.sqrt(5));
	}

	private static int fibMethod1(int n) {
		int[] fib = new int[n + 1];
		fib[0] = 0;
		fib[1] = 1;

		for (int i = 2; i <= n; i++) {
			fib[i] = fib[i - 1] + fib[i - 2];
		}
		return fib[n];
	}

	private static int fibMethod2(int n) {
		int[][] fib = new int[][] { { 1, 1 }, { 1, 0 } };
		int[][] temp = new int[][] { { 1, 1 }, { 1, 0 } };
		for (int i = 2; i < n; i++) {
			multiply(fib, temp);
		}
		return fib[0][0];
	}

	static void multiply(int a[][], int b[][]) {
		int x = a[0][0] * b[0][0] + a[0][1] * b[1][0];
		int y = a[0][0] * b[0][1] + a[0][1] * b[1][1];
		int z = a[1][0] * b[0][0] + a[1][1] * b[1][0];
		int w = a[1][0] * b[0][1] + a[1][1] * b[1][1];

		a[0][0] = x;
		a[0][1] = y;
		a[1][0] = z;
		a[1][1] = w;
	}
}
