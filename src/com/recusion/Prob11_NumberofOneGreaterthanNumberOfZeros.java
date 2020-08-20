package com.recusion;

import java.util.ArrayList;
import java.util.List;

public class Prob11_NumberofOneGreaterthanNumberOfZeros {

	public static void main(String[] args) {
		List<String> l = new ArrayList<>();
		solve(0, 0, l, "", 5);
		for (String sss : l) {
			System.out.println(sss);
		}

	}

	public static void solve(int numOfOnes, int numOfZeros, List<String> res, String op, int n) {
		if (n == 0) {
			res.add(op);
			return;
		}

		solve(numOfOnes + 1, numOfZeros, res, op + "1", n - 1);
		if (numOfOnes - numOfZeros >= 1) {
			solve(numOfOnes , numOfZeros+ 1, res, op + "0", n - 1);
		} 
	}
}
