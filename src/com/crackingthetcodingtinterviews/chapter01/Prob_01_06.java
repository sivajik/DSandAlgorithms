package com.crackingthetcodingtinterviews.chapter01;

public class Prob_01_06 {

	public static void main(String[] args) {
		System.out.println(compress("aabcccccaaa"));
		System.out.println(compress("aabcccccaab"));
		System.out.println(compress("aabcccccabc"));
		System.out.println(compress("aabcccccacc"));
	}

	private static String compress(String s) {
		StringBuilder sbr = new StringBuilder();
		int counter = 1;
		for (int i = 0; i < s.length(); i++) {
			if (i == s.length() - 1) {
				sbr.append(s.charAt(i));
				sbr.append(counter);
				counter = 1;
			} else {
				if (s.charAt(i) == s.charAt(i + 1)) {
					counter++;
				} else {
					sbr.append(s.charAt(i));
					sbr.append(counter);
					counter = 1;
				}
			}
		}
		return sbr.toString();
	}
}
