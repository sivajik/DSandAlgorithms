package com.karumanchi.chap19;

public class LCSRecursive {

	public static void main(String[] args) {
		System.out.println(LCSRecursiveApproach("ABCBDAB", "BDCABA"));

	}

	static public String LCSRecursiveApproach(String x, String y) {
		int m = x.length();
		int n = y.length();

		if (m == 0 || n == 0) {
			return "";
		} else if (x.charAt(m - 1) == y.charAt(n - 1)) {
			return LCSRecursiveApproach(x.substring(0, m - 1), y.substring(0, n - 1)) + x.charAt(m - 1);
		} else {
			String p = LCSRecursiveApproach(x.substring(0, m - 1), y);
			String q = LCSRecursiveApproach(x, y.substring(0, n - 1));
			if (p.length() > q.length()) {
				return p;
			} else {
				return q;
			}
		}
	}
}
