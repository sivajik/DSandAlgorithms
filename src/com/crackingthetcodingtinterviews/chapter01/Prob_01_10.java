package com.crackingthetcodingtinterviews.chapter01;

public class Prob_01_10 {

	public static void main(String[] args) {
		System.out.println(isRotation("waterbottle", "erbottlewat"));
		System.out.println(isRotation("waterbottle", "exbottlewat"));

	}

	private static boolean isRotation(String s1, String s2) {
		return (s1+s1).indexOf(s2) != -1;
	}
}
