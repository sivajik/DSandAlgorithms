package com.crackingthetcodingtinterviews.chapter01;

import java.util.*;

public class Prob_01_04 {

	public static void main(String[] args) {
		System.out.println(isPermutationOfPalindrome("Tact Coa"));
		System.out.println(isPermutationOfPalindrome("tactcoapapa"));
	}

	private static boolean isPermutationOfPalindrome(String s) {
		s = s.toLowerCase();
		Map<Character, Integer> m = new HashMap<>();
		for (char c : s.toCharArray()) {
			if (c >= 'a' && c <= 'z') {
				if (m.containsKey(c)) {
					m.put(c, 1 + m.get(c));
				} else {
					m.put(c, 1);
				}
			}
		}

		boolean oddElemFound = false;
		for (Map.Entry<Character, Integer> entry : m.entrySet()) {
			if (entry.getValue() % 2 == 0) {
				; //nothing to do.
			} else {
				if (oddElemFound == false) {
					oddElemFound = true;
				} else {
					return false;
				}
			}
		}
		return true;
	}
}
