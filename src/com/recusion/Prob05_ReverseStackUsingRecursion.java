package com.recusion;

public class Prob05_ReverseStackUsingRecursion {

	public static void main(String[] args) {
		/*System.out.println(kthGrammar(1, 1));
		System.out.println(kthGrammar(2, 1));
		System.out.println(kthGrammar(2, 2));
		System.out.println(kthGrammar(4, 5));*/
		System.out.println(kthGrammar(30, 434991989));
	}

	static public int kthGrammar(int N, int K) {
		String res = helper(N);
		return res.charAt(K - 1) - 48;
	}

	private static String helper(int n) {
		if (n == 1) {
			return "0";
		}
		String s = helper(n - 1);
		return s + compliment(s);
	}

	private static String compliment(String s) {
		char[] op = s.toCharArray();
		for (int i = 0; i < op.length; i++) {
			if (op[i] == '0') {
				op[i] = '1';
			} else {
				op[i] = '0';
			}
		}
		return new String(op);
	}
}