package com.cracking.the.coding.interviews;

/*
 * Is Unique: Implement an algorithm to determine if a string has all unique characters. 
 * What if you cannot use additional data structures?
 */
public class Prob_01_01 {

	public static void main(String[] args) {
		System.out.println(isUnique("abcdefg"));
		System.out.println(isUnique("abcdefga"));
	}

	private static boolean isUnique(String str) {
		if (str.length() > 128) {
			return false;
		}

		boolean[] chars = new boolean[128];
		for (char c : str.toCharArray()) {
			if (chars[c]) {
				return false;
			}
			chars[c] = true;
		}
		return true;
	}

}
