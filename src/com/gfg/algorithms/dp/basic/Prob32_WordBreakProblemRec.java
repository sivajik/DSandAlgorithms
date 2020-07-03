package com.gfg.algorithms.dp.basic;

import java.util.HashSet;
import java.util.Set;

public class Prob32_WordBreakProblemRec {

	public static void main(String[] args) {
		// array of strings to be added in dictionary set.
		String temp_dictionary[] = { "c", "od", "e", "x" };

		// sample input cases
		System.out.println(wordBreakRec("code", temp_dictionary));
	}

	private static boolean wordBreakRec(String word, String[] temp_dictionary) {
		Set<String> set = new HashSet<>();
		for (String s : temp_dictionary) {
			set.add(s);
		}
		return DFS(word, set);
	}

	private static boolean DFS(String word, Set<String> set) {
		if (word.length() == 0) {
			return true;
		}

		for (int len = 1; len <= word.length(); len++) {
			String subStr = word.substring(0, len);
			if (set.contains(subStr) && DFS(word.substring(len), set)) {
				return true;
			}
		}
		return false;
	}

}
