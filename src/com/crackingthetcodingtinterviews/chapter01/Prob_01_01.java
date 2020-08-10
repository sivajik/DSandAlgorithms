package com.crackingthetcodingtinterviews.chapter01;

import java.util.Arrays;

/*
 * Is Unique: Implement an algorithm to determine if a string has all unique characters. 
 * What if you "cannot" use additional data structures?
 */
public class Prob_01_01 {

	public static void main(String[] args) {
		System.out.println((isUnique("abcdefg") == isUniqueNoStorage1("abcdefg"))
				&& (isUniqueNoStorage1("abcdefg") == isUniqueNoStorage2("abcdefg")));
		System.out.println((isUnique("abcdefga") == isUniqueNoStorage1("abcdefga"))
				&& (isUniqueNoStorage1("abcdefga") == isUniqueNoStorage2("abcdefga")));
	}

	private static final int MAX_UNIQ_CHARS = 128;

	private static boolean isUnique(String str) {
		if (str.length() > MAX_UNIQ_CHARS) {
			return false;
		}

		boolean[] chars = new boolean[MAX_UNIQ_CHARS];
		for (char c : str.toCharArray()) {
			if (chars[c]) {
				return false;
			}
			chars[c] = true;
		}
		return true;
	}

	private static boolean isUniqueNoStorage1(String str) {
		if (str.length() > MAX_UNIQ_CHARS) {
			return false;
		}

		char[] chars = str.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			for (int j = i + 1; j < chars.length; j++) {
				if (chars[i] == chars[j]) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean isUniqueNoStorage2(String str) {
		if (str.length() > MAX_UNIQ_CHARS) {
			return false;
		}

		char[] chars = str.toCharArray();
		Arrays.sort(chars); // does it use internally any storage?
		for (int i = 0; i < chars.length - 1; i++) {
			if (chars[i] == chars[i + 1]) {
				return false;
			}
		}
		return true;
	}
}
