package com.gfg.algorithms.backtracking.leetcodepatterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prob39 {

	public static void main(String[] args) {
		for (List<Integer> l : combinationSum(new int[] { 10, 1, 2, 7, 6, 1, 5 }, 8)) {
			System.out.println(l);
		}
	}

	static public List<List<Integer>> combinationSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);
		helper(nums, new ArrayList<>(), res, 0, target);
		return res;
	}

	private static void helper(int[] nums, ArrayList temp, List<List<Integer>> res, int start, int target) {
		if (target < 0) {
			return;
		}
		if (target == 0) {
			res.add(new ArrayList<>(temp));
			return;
		}
		for (int i = start; i < nums.length; i++) {
			if (i > start && nums[i] == nums[i - 1]) {
				continue;
			}
			temp.add(nums[i]);
			helper(nums, temp, res, i + 1, target - nums[i]);
			temp.remove(temp.size() - 1);
		}
	}

}
