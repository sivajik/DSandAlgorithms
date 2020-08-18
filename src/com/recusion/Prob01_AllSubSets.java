package com.recusion;

import java.util.ArrayList;
import java.util.List;

public class Prob01_AllSubSets {

	public static void main(String[] args) {
		List<String> res = new ArrayList<>();
		helper("abcd", "", res);
	}

	private static void helper(String ip, String op, List<String> res) {
		if (0 == ip.length()) {
			// res.add(op);
			System.out.println(op);
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
