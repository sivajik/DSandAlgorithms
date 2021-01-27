package com.gfg.algorithms.backtracking.leetcodepatterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prob47 {

	public static void main(String[] args) {
		for (List<Integer> l : subsets(new int[] { 1, 2, 2 })) {
			System.out.println(l);
		}
	}

	static public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);
		helper(nums, new ArrayList<>(), res, new boolean[nums.length]);
		return res;
	}

	@SuppressWarnings("unchecked")
	private static void helper(int[] nums, ArrayList<Integer> tempList, List<List<Integer>> res, boolean[] used) {
		if (tempList.size() == nums.length) {
			res.add(new ArrayList(tempList));
			return;
		} // else {
			for (int i = 0; i < nums.length; i++) {
				if (used[i] == true || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
					continue;
				}
				used[i] = true;
				tempList.add(nums[i]);
				helper(nums, tempList, res, used);

				used[i] = false;
				tempList.remove(tempList.size() - 1);
			}
		//}
	}
}
