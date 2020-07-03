package com.gfg.algorithms.dp.basic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Prob32_WordBreakProblemMem {

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
		return DFS(word, set, new HashMap<String, Boolean>());
	}

	private static boolean DFS(String word, Set<String> set, Map<String, Boolean> map) {
		if (word.length() == 0) {
			return true;
		}
		if (map.containsKey(word)) {
			return map.get(word);
		}

		for (int len = 1; len <= word.length(); len++) {
			String subStr = word.substring(0, len);
			if (set.contains(subStr) && DFS(word.substring(len), set, map)) {
				map.put(word.substring(len), true);
				return true;
			}
		}
		map.put(word, false);
		return false;
	}

}
