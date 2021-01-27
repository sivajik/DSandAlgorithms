package com.gfg.algorithms.backtracking.leetcodepatterns;

import java.util.ArrayList;
import java.util.List;

public class Prob46 {

	public static void main(String[] args) {
		for (List<Integer> l : subsets(new int[] { 1, 2, 3 })) {
			System.out.println(l);
		}
	}

	static public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		helper(nums, new ArrayList<>(), res);
		return res;
	}

	@SuppressWarnings("unchecked")
	private static void helper(int[] nums, ArrayList<Integer> tempList, List<List<Integer>> res) {
		if (tempList.size() == nums.length) {
			res.add(new ArrayList(tempList));
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (tempList.contains(nums[i])) {
					continue;
				}
				tempList.add(nums[i]);
				helper(nums, tempList, res);
				tempList.remove(tempList.size() - 1);
			}
		}
	}
}
