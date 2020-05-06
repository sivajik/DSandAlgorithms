package com.karumanchi.chap06;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Prob35_VerticalSum {

	public static void main(String[] args) {

		BinaryTreeNode n1 = new BinaryTreeNode(1);

		BinaryTreeNode n2 = new BinaryTreeNode(2);
		BinaryTreeNode n3 = new BinaryTreeNode(3);

		BinaryTreeNode n4 = new BinaryTreeNode(4);
		BinaryTreeNode n5 = new BinaryTreeNode(5);
		BinaryTreeNode n6 = new BinaryTreeNode(6);
		BinaryTreeNode n7 = new BinaryTreeNode(7);

		n1.left = n2;
		n1.right = n3;

		n2.left = n4;
		n2.right = n5;

		n3.left = n6;
		n3.right = n7;

		int sum = n1.verticalSum(n1);
		System.out.println(sum);

	}

	private static void print(BinaryTreeNode reverseed) {
		if (reverseed != null) {
			print(reverseed.left);
			System.out.print(reverseed.value + " ");
			print(reverseed.right);
		}
	}

	static class BinaryTreeNode {
		BinaryTreeNode left;
		BinaryTreeNode right;
		int value;

		BinaryTreeNode() {
		}

		BinaryTreeNode(int x) {
			this.value = x;
			this.left = null;
			this.right = null;
		}

		public int verticalSum(BinaryTreeNode root) {
			int sum = 0;
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			getLevel(root, 0, map);

			for (Entry<Integer, Integer> entry : map.entrySet()) {
				Integer key = entry.getKey();
				Integer val = entry.getValue();
				System.out.println(key + " -> " + val);
			}
			return sum;
		}

		public void getLevel(BinaryTreeNode root, int level, Map<Integer, Integer> map) {
			if (root.left != null) {
				getLevel(root.left, level - 1, map);
			}
			if (root.right != null) {
				getLevel(root.right, level + 1, map);
			}
			if (map.containsKey(level)) {
				int currentData = map.get(level);
				currentData += root.value;
				map.put(level, currentData);
			} else {
				map.put(level, root.value);
			}
		}
	}

}
