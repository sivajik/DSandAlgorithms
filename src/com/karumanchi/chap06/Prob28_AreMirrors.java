package com.karumanchi.chap06;

public class Prob28_AreMirrors {

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

		print(n1);
		boolean result = n1.mirror(n1, n1);
		System.out.println(result);
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

		public boolean mirror(BinaryTreeNode root1, BinaryTreeNode root2) {
			if (root1 == null && root2 == null) {
				return true;
			}
			if (root1 == null || root2 == null) {
				return false;
			}
			if (root1.value != root2.value) {
				return false;
			}
			return mirror(root1.left, root2.right) && mirror(root1.right, root2.left);
		}
	}

}
