package com.recusion;

import java.util.HashSet;
import java.util.Set;

public class Prob09_PermutationsWithCaseMixedCase {

	public static void main(String[] args) {
		Set<String> res = new HashSet<>();
		helper("a1B2", "", res);
		for (String s : res) {
			System.out.println(s);
		}
	}

	private static void helper(String ip, String op, Set<String> res) {
		if (0 == ip.length()) {
			res.add(op);
			return;
		}
		char c = ip.charAt(0);
		String op1;
		String op2;

		if (Character.isDigit(c)) {
			op1 = op + c;
			ip = ip.substring(1);
			helper(ip, op1, res);
		} else {
			op1 = op + Character.toUpperCase(ip.charAt(0));
			op2 = op + Character.toLowerCase(ip.charAt(0));
			ip = ip.substring(1);
			helper(ip, op2, res);
			helper(ip, op1, res);
		}

	}
}
