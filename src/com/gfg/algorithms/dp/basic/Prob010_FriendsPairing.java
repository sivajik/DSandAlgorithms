package com.gfg.algorithms.dp.basic;

public class Prob010_FriendsPairing {

	public static void main(String[] args) {
		System.out.println(friendsPairing(3));
		System.out.println(friendsPairing(5));
	}

	static int friendsPairing(int n) {
		int[] dp = new int[n + 1];

		dp[0] = 0; // no friends, no pairing
		dp[1] = 1; // lone ranger, 1 possibilty.
		dp[2] = 2; // 2 people, option 1 -> both separate option 2 -> paired as one group.
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + (dp[i - 2] * (i - 1));
		}
		return dp[n];
	}
}
