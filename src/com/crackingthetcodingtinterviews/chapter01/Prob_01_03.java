package com.crackingthetcodingtinterviews.chapter01;

public class Prob_01_03 {

	public static void main(String[] args) {
		System.out.println(urlify("Mr John Smith    ", 13));
	}

	private static String urlify(String s, int len) { // 17
		char[] tkns = s.toCharArray();
		int cntr = s.length() - 1;
		for (int i = len - 1; i >= 0; i--) {
			if (tkns[i] == ' ') {
				tkns[cntr--] = '0';
				tkns[cntr--] = '2';
				tkns[cntr--] = '%';
			} else {
				tkns[cntr--] = tkns[i];
			}
		}
		return new String(tkns);
	}
}
