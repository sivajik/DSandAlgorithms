package com.gfg.algorithms.backtracking.leetcodepatterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prob90 {

	public static void main(String[] args) {
		for (List<Integer> l : subsets(new int[] { 1, 2, 2 })) {
			System.out.println(l);
		}
	}

	static public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);
		helper(nums, 0, new ArrayList<>(), res);
		return res;
	}

	@SuppressWarnings("unchecked")
	private static void helper(int[] nums, int currIndex, ArrayList<Integer> tempList, List<List<Integer>> res) {
		res.add(new ArrayList(tempList));
		for (int i = currIndex; i < nums.length; i++) {
			if (i > currIndex && nums[i] == nums[i-1]) {
				continue;
			}
			tempList.add(nums[i]);
			helper(nums, i + 1, tempList, res);
			tempList.remove(tempList.size() - 1);
		}
	}
}
