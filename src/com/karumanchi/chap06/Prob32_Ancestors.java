package com.karumanchi.chap06;

public class Prob32_Ancestors {

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

		n1.ancestors(n1, 7);

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

		public boolean ancestors(BinaryTreeNode root, int val) {
			if (root == null) {
				return false;
			}

			if (root != null && root.value == val) {
				System.out.print(root.value + " ");
				return true;
			}

			if (root.left != null && root.left.value == val) {
				System.out.print(root.value + " ");
				return true;
			}

			if (root.right != null && root.right.value == val) {
				System.out.print(root.value + " ");
				return true;
			}
			if (ancestors(root.right, val) || ancestors(root.left, val)) {
				System.out.print(root.value + " ");
				return true;
			}

			return false;
		}
	}

}
