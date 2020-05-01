package com.karumanchi.chap06;

public class Prob23_PrintAllPaths {

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

		n1.printAllPaths(n1);
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

		public void printAllPaths(BinaryTreeNode root) {
			int[] paths = new int[1000];
			print(root, paths, 0);
		}

		public void print(BinaryTreeNode root, int[] paths, int i) {
			if (root == null) {
				return;
			}
			paths[i] = root.value;
			i++;
			if (root.left == null && root.right == null) {
				printArray(paths, i);
			} else {
				print(root.left, paths, i);
				print(root.right, paths, i);
			}
		}

		private void printArray(int[] paths, int in) {
			for (int i = 0; i < in; i++) {
				System.out.print(paths[i] + " ");
			}
			System.out.println();
		}
	}

}
