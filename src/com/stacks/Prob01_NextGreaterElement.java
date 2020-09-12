package com.stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Prob01_NextGreaterElement {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(nextGreater(new int[] { 1, 3, 2, 4 })));
	}

	static int[] nextGreater(int[] nums) {
		Stack<Integer> s = new Stack<>();
		List<Integer> ans = new ArrayList<>();

		for (int i = nums.length - 1; i >= 0; i--) {
			if (s.isEmpty()) {
				ans.add(-1);
			} else if (!s.isEmpty() && s.peek() > nums[i]) { // you found max.
				ans.add(s.peek());
			} else if (!s.isEmpty() && s.peek() < nums[i]) { // pop until you find max
				while (!s.isEmpty() && s.peek() < nums[i]) {
					s.pop();
				}
				if (s.isEmpty()) {
					ans.add(-1);
				} else {
					ans.add(s.peek());
				}
			}
			s.push(nums[i]);
		}
		int[] op = new int[ans.size()];
		for (int i = ans.size() - 1; i >= 0; i--) {
			op[ans.size() - i - 1] = ans.get(i);
		}
		return op;
	}
}