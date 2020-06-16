package com.karumanchi.chap19;

public class LCSRecursive {

	public static void main(String[] args) {
		System.out.println(LCSRecursive("ABCBDAB", "BDCABA"));

	}

	static public String LCSRecursive(String x, String y) {
		int m = x.length();
		int n = y.length();

		if (m == 0 || n == 0) {
			return "";
		} else if (x.charAt(m - 1) == y.charAt(n - 1)) {
			return LCSRecursive(x.substring(0, m - 1), y.substring(0, n - 1)) + x.charAt(m - 1);
		} else {
			String p = LCSRecursive(x.substring(0, m - 1), y);
			String q = LCSRecursive(x, y.substring(0, n - 1));
			if (p.length() > q.length()) {
				return p;
			} else {
				return q;
			}
		}
	}
}
