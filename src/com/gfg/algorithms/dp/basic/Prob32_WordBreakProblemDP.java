package com.gfg.algorithms.dp.basic;

import java.util.HashSet;

public class Prob32_WordBreakProblemDP {

	public static void main(String[] args) {
		// array of strings to be added in dictionary set.
		String temp_dictionary[] = { "c", "od", "e", "x" };

		// sample input cases
		System.out.println(wordBreakRec("code", temp_dictionary));
	}

	private static boolean wordBreakRec(String word, String[] temp_dictionary) {
		java.util.Set<String> set = new HashSet<String>();
		for (String s : temp_dictionary) {
			set.add(s);
		}

		boolean[] dp = new boolean[word.length() + 1];
		dp[0] = true;
		
		for (int len = 1; len <= word.length(); len++) {
			for (int i = 0; i < len; i++) {
				if (dp[i] && set.contains(word.subSequence(i, len))) {
					dp[len] = true;
					break;
				}
			}
		}
		return dp[word.length()];
	}

}
