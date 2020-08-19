package com.recusion;

import java.util.ArrayList;
import java.util.List;

public class Prob10_BalancedParenthesis {

	public static void main(String[] args) {
		List<String> l = new ArrayList<>();
		solve(3, 3, l, "");
		for (String sss : l) {
			System.out.println(sss);
		}

	}

	public static void solve(int open, int closed, List<String> res, String op) {
		if (open == closed && open == 0) {
			res.add(op);
			return;
		}

		if (open == 0 && closed > 0) {
			solve(open, closed - 1, res, op + ")");
		} else if (closed > open) {
			solve(open-1, closed, res, op + "("); // option 1
			solve(open, closed-1, res, op + ")"); // option 1
		} else if (open >= closed){
			solve(open - 1, closed, res, op + "(");
		}
	}
}
