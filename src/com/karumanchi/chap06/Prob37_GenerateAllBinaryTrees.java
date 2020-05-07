package com.karumanchi.chap06;

import java.util.ArrayList;

public class Prob37_GenerateAllBinaryTrees {

	public static void main(String[] args) {
		ArrayList<BinaryTreeNode> list = generateTrees(1, 3);
		System.out.println(list.size());
		for (BinaryTreeNode n : list) {
			print(n);
			System.out.println();
		}
	}

	static ArrayList<BinaryTreeNode> generateTrees(int start, int end) {
		ArrayList<BinaryTreeNode> subtrees = new ArrayList<BinaryTreeNode>();

		if (start > end) {
			subtrees.add(null);
			return subtrees;
		}
		for (int i = start; i <= end; i++) {
			for (BinaryTreeNode left : generateTrees(start, i - 1)) {
				for (BinaryTreeNode right : generateTrees(i + 1, end)) {
					BinaryTreeNode node = new BinaryTreeNode(i);
					node.left = left;
					node.right = right;
					subtrees.add(node);
				}
			}
		}
		return subtrees;
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
	}
}
