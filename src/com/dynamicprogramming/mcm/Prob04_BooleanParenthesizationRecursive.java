package com.dynamicprogramming.mcm;

public class Prob04_BooleanParenthesizationRecursive {

	public static void main(String[] args) {
		String s = "T|F&T^F";
		System.out.println(countBooleanParen(s));
	}

	private static int countBooleanParen(String s) {
		return solve(s, 0, s.length() - 1, true);
	}

	private static int solve(String s, int i, int j, boolean isTrue) {
		if (i > j) {
			return 0;
		}
		if (i == j) {
			if (isTrue) {
				if( s.charAt(i) == 'T') {
					return 1;
				} else {
					return 0;
				}
			} else {
				if (s.charAt(i) == 'F') {
					return 1;
				} else {
					return 0;
				}
			}
		}
		int ans = 0;
		for (int k = i + 1; k < j; k += 2) {
			int lt = solve(s, i, k - 1, true);
			int lf = solve(s, i, k - 1, false);
			int rt = solve(s, k + 1, j, true);
			int rf = solve(s, k + 1, j, false);

			if (s.charAt(k) == '&') {
				if (isTrue) {
					ans += (lt * rt);
				} else {
					ans += (lf * rt + lf * rf + lt * rf);
				}
			} else if (s.charAt(k) == '|') {
				if (isTrue) {
					ans += (lt * rt + lt * rf + lf * rt);
				} else {
					ans += (lf * rf);
				}
			} else if (s.charAt(k) == '^') {
				if (isTrue) {
					ans += (lf *rt + lt * rf);
				} else {
					ans += (lt *rt + lf * rf);
				}
			}
		}

		return ans;
	}

}
