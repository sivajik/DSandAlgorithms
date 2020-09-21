package com.dynamicprogramming.mcm;

public class Prob03_CountOfPalinPartitions {

	public static void main(String[] args) {
		System.out.println(countOfPalinPartitions("nitin")) ;
	}

	static int countOfPalinPartitions(String str) {
		return solve(str.toCharArray(), 0, str.length() - 1);
	}

	static int solve(char[] str, int i, int j) {
		if (i > j) {
			return 0;
		}
		
		if (i == j) {
			return 0;
		}
		if (isPalindrome(str, i, j)) {
			return 0; // already pal, so no need to parition
		}
		int min = Integer.MAX_VALUE;
		for (int k = i; k <= j - 1; k++) {
			int tempAns = solve(str, i, k) + solve(str, k + 1, j) + 1;
			// +1 is here arr[i-1]*arr[k]*arr[j] because we made a "one" partition 
			// so adding "one" partiton to number of partitions between i->k plus 
			// number of partitions between k+1 to j
			if (tempAns < min) {
				min = tempAns;
			}
		}
		return min;
	}

	private static boolean isPalindrome(char[] str, int i, int j) {
		// TODO Auto-generated method stub
		return false;
	}
}
