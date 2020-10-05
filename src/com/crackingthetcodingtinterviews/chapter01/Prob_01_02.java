package com.crackingthetcodingtinterviews.chapter01;

import java.util.Arrays;

public class Prob_01_02 {

	public static void main(String[] args) {
		System.out.println(permutation("dog", "god") == permutation1("dog", "god"));
		System.out.println(permutation("dogx", "goxd") == permutation1("dogx", "goxd"));
	}

	private static boolean permutation1(String s, String t) {
		int[] allChars = new int[128];
		for (char c : s.toCharArray()) {
			int index = c - 'a';
			if (allChars[index] == 0) {
				allChars[index]++;
			}
		}

		for (char c : t.toCharArray()) {
			int index = c - 'a';
			allChars[index]--;
			if (allChars[index] < 0) {
				return false;
			}
		}

		return true;
	}

	static boolean permutation(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		return sort(s).equals(sort(t));
	}

	private static String sort(String s) {
		char[] c = s.toCharArray();
		Arrays.sort(c);
		return new String(c);
	}
}
