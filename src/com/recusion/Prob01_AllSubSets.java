package com.recusion;

import java.util.ArrayList;
import java.util.List;

public class Prob01_AllSubSets {

	public static void main(String[] args) {
		List<String> res = new ArrayList<>();
		helper("abb", "", res, 0);
		for (String s : res) {
			System.out.println(" result : " + s);
		}
	}

	private static void helper(String mainStr,  String op, List<String> res, int startAt) {
		if (startAt == mainStr.length() ) {
			res.add(op);
			return;
		}

		// include
		char c = mainStr.charAt(startAt);
		helper(mainStr,  op + c, res, startAt + 1);

		// exclude
		helper(mainStr,  op, res, startAt + 1);
	}

}
