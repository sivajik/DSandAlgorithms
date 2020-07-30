package com.gfg.algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Prob04_SubsetSum {

	public static void main(String[] args) {
		int list[] = { 1, 3, 2, 0, 4, 6};
		subsetSum(list, 0, 0, 6, new ArrayList<Integer>()); // 6   06  24 132 1320
		System.out.println(subsetsCount);
	}

	static int subsetsCount = 0;

	static void subsetSum(int list[], int currSum, int starting_index, int target_sum, List<Integer> l) {
		if (currSum == target_sum) {
			subsetsCount++;
			System.out.println(l);
			return;
		}
		
		for (int i = starting_index; i < list.length; i++) {
			if (currSum + list[i] <= target_sum) {
				l.add(new Integer(list[i]));
				currSum = currSum + list[i];
				subsetSum(list, currSum, i+1, target_sum, l);
				l.remove(new Integer(list[i]));
				currSum = currSum - list[i];
			}
		}
		
	}
	
	static void subsetSum1(int list[], int currSum, int starting_index, int target_sum) {
		if (currSum == target_sum) {
			subsetsCount++;
			// still some more options might have left
			if (starting_index < list.length) {
				subsetSum1(list, currSum - list[starting_index-1], starting_index, target_sum);
			}
		} else {
			for (int i = starting_index; i < list.length; i++) {
				subsetSum1(list, currSum + list[i], i + 1, target_sum);
			}
		}
	}

}
