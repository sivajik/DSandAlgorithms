package com.dynamicprogramming.mcm;

import java.util.HashMap;
import java.util.Map;

public class Prob05_BooleanParenthesizationMemoization {

	public static void main(String[] args) {
		System.out.println(countBooleanParen("T|F&T^F"));
		System.out.println(countBooleanParen("T|T&F^T"));
	}

	static class Pair {
		int i;
		int j;
		boolean isTrue;

		public Pair(int i, int j, boolean isTrue) {
			super();
			this.i = i;
			this.j = j;
			this.isTrue = isTrue;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + i;
			result = prime * result + (isTrue ? 1231 : 1237);
			result = prime * result + j;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pair other = (Pair) obj;
			if (i != other.i)
				return false;
			if (isTrue != other.isTrue)
				return false;
			if (j != other.j)
				return false;
			return true;
		}

	}

	static Map<Pair, Integer> dp = new HashMap<>();

	private static int countBooleanParen(String s) {
		dp.clear();
		return solve(s, 0, s.length() - 1, true);
	}

	private static int solve(String s, int i, int j, boolean isTrue) {
		if (i > j) {
			return 0;
		}

		if (i == j) {
			if (isTrue) {
				if (s.charAt(i) == 'T') {
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
		// check the dp first
		if (dp.containsKey(new Pair(i, j, isTrue))) {
			return dp.get(new Pair(i, j, isTrue));
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
					ans += (lf * rt + lt * rf);
				} else {
					ans += (lt * rt + lf * rf);
				}
			}
		}
		// put it back
		dp.put(new Pair(i, j, isTrue), ans);
		return ans;
	}

}
