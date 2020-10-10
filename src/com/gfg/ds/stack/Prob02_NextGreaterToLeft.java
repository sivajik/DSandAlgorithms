package com.gfg.ds.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Prob02_NextGreaterToLeft {
	// Try with 1 3 2 4 and a picture it on paper.
	public static void main(String[] args) {
		int[] arr = new int[] { 1, 3, 2, 4 };
		// int[] arr = new int[] { 1, 3, 0, 0, 1, 2, 4 };

		Stack<Integer> s = new Stack<Integer>();
		List<Integer> result = new ArrayList<>();
		
		// change 1 : for (int i = arr.length - 1; i >= 0; i--) {
		for (int i = 0; i < arr.length; i++) {
			if (s.isEmpty()) {
				result.add(-1);
			} else if (s.size() > 0 && s.peek() > arr[i]) {
				result.add(s.peek());
			} else if (s.size() > 0 && s.peek() <= arr[i]) {

				while (s.size() > 0 && s.peek() <= arr[i]) {
					s.pop();
				}
				if (s.size() == 0) {
					result.add(-1);
				} else {
					result.add(s.peek());
				}
			}
			s.push(arr[i]);
		}
		// change 2: no need to reverse
		// Collections.reverse(result);
		System.out.println(result);
	}

}
