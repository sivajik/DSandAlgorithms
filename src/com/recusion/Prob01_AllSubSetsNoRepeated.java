package com.recusion;

import java.util.HashSet;
import java.util.Set;

public class Prob01_AllSubSetsNoRepeated {

	public static void main(String[] args) {
		Set<String> res = new HashSet<>();
		helper("aab", "", res);
		for(String s : res) {
			System.out.println(s);
		}
	}

	private static void helper(String ip, String op, Set<String> res) {
		if (0 == ip.length()) {
			res.add(op);
			return;
		}

		String op1 = op;
		String op2 = op + ip.charAt(0);
		ip = ip.substring(1);

		helper(ip, op1, res);
		helper(ip, op2, res);
		return;
	}
}
