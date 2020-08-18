package com.recusion;

import java.util.HashSet;
import java.util.Set;

public class Prob07_PermutationsWithSpaces {

	public static void main(String[] args) {
		Set<String> res = new HashSet<>();
		helper("abc", "", res);
		for (String s : res) {
			System.out.println(s);
		}
	}

	private static void helper(String ip, String op, Set<String> res) {
		if (0 == ip.length()) {
			res.add(op);
			return;
		}

		if (op.length() == 0) {
			op = "" + ip.charAt(0);
			ip = ip.substring(1);
		}

		String op1 = op + "_" + ip.charAt(0);
		String op2 = op + ip.charAt(0);
		ip = ip.substring(1);
		helper(ip, op1, res);
		helper(ip, op2, res);
	}
}
