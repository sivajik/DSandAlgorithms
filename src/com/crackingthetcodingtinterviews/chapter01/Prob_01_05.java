package com.crackingthetcodingtinterviews.chapter01;

public class Prob_01_05 {

	public static void main(String[] args) {
		System.out.println(oneAway("pale", "ple") == true);
		System.out.println(oneAway("pales", "pale") == true);
		System.out.println(oneAway("pale", "bale") == true);
		System.out.println(oneAway("pale", "bae") == false);
	}

	private static boolean oneAway(String s, String t) {
		int[][] dp = new int[s.length() + 1][t.length() + 1];

		for (int i = 0; i <= s.length(); i++) {
			for (int j = 0; j <= t.length(); j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else if (s.charAt(i - 1) == t.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		int lenOfLCS = dp[s.length()][t.length()];
		return Math.max(s.length(), t.length()) - lenOfLCS == 1;
	}
}
