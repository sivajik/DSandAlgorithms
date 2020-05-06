package com.karumanchi.chap06;

public class Prob29_MakeTreeFromInorderPreOrder {

	public static void main(String[] args) {
		BinaryTreeNode root = makeTree(new char[] { 'A', 'B', 'D', 'E', 'C', 'F' },
				new char[] { 'D', 'B', 'E', 'A', 'F', 'C' });
		inOrder(root);
	}

	public static BinaryTreeNode makeTree(char[] preorder, char[] inorder) {
		BinaryTreeNode root = makeBinaryTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
		return root;
	}

	private static BinaryTreeNode makeBinaryTree(char[] preorder, int p_start, int p_end, char[] inorder, int i_start,
			int i_end) {

		if (i_start > i_end || p_start > p_end) {
			return null;
		}

		char rootNodeValue = preorder[p_start];
		BinaryTreeNode root = new BinaryTreeNode((int) rootNodeValue);

		int rootPosition = i_start;
		for (; rootPosition < i_end; rootPosition++) {
			if (inorder[rootPosition] == rootNodeValue) {
				break;
			}
		}

		root.left = makeBinaryTree(preorder, p_start + 1, p_start + rootPosition - i_start, inorder, i_start,
				rootPosition - 1);

		root.right = makeBinaryTree(preorder, p_start + rootPosition - i_start + 1, p_end, inorder, rootPosition + 1,
				i_end);
		return root;
	}

	private static void inOrder(BinaryTreeNode root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print((char) root.value + " ");
			inOrder(root.right);
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
