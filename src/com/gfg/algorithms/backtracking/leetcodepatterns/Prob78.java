package com.gfg.algorithms.backtracking.leetcodepatterns;

import java.util.ArrayList;
import java.util.List;

public class Prob78 {

	public static void main(String[] args) {
		for (List<Integer> l : subsets(new int[] { 1, 2, 3 })) {
			System.out.println(l);
		}
	}

	static public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		helper(nums, 0, new ArrayList<>(), res);
		return res;
	}

	@SuppressWarnings("unchecked")
	private static void helper(int[] nums, int currIndex, ArrayList<Integer> tempList, List<List<Integer>> res) {
		System.out.println("Current: " + currIndex);
		res.add(new ArrayList<>(tempList));
		for (int i = currIndex; i < nums.length; i++) {
			tempList.add(nums[i]);
			helper(nums, i + 1, tempList, res);
			tempList.remove(tempList.size() - 1);
		}
		System.out.println("Now current index: " + currIndex);
	}
}
