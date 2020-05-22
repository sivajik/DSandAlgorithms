package com.gfg.dsbinarysearchtree.basic;

public class Prob02_DeleteinBST {

	public static void main(String[] args) {
		TreeNode root = prepareTree(new int[] { 8, 3, 10, 1, 6, -999, 14, -999, -999, 4, 7 });
		inOrder(root);
		System.out.println();
// 1 3 4 6 7 8 10 14 
/*
		deleteNode(root, 1);
		inOrder(root);
		System.out.println();

		deleteNode(root, 3);
		inOrder(root);
		System.out.println();

		deleteNode(root, 4);
		inOrder(root);
		System.out.println();

		deleteNode(root, 6);
		inOrder(root);
		System.out.println();

		deleteNode(root, 7);
		inOrder(root);
		System.out.println();
*/
		deleteNode(root, 8);
		inOrder(root);
		System.out.println();

		/*
		deleteNode(root, 10);
		inOrder(root);
		System.out.println();

		deleteNode(root, 14);
		inOrder(root);
		System.out.println();
*/
	}

	private static void deleteNode(TreeNode root, int i) {
		root = delete(root, i);
	}

	private static TreeNode delete(TreeNode root, int i) {
		if (root == null) {
			return null;
		}

		if (root.val == i) {
			if (root.left == null && root.right == null) {
				return null;
			} else if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			} else {
				root.val = inOrderSuccess(root.right);
				root.right = delete(root.right, root.val);
			}
		} else if (i < root.val) {
			root.left = delete(root.left, i);
		} else {
			root.right = delete(root.right, i);
		}
		return root;
	}

	private static int inOrderSuccess(TreeNode r) {
		while (r.left != null) {
			r = r.left;
		}
		return r.val;
	}

	public static TreeNode insert(TreeNode root, int key) {
		if (root == null) {
			root = new TreeNode(key);
			return root;
		}

		if (key < root.val) {
			root.left = insert(root.left, key);
		} else {
			root.right = insert(root.right, key);
		}
		return root;
	}

	public static TreeNode search(TreeNode root, int key) {
		if (root == null) {
			return null;
		}
		if (root.val == key) {
			return root;
		} else if (key < root.val) {
			return search(root.left, key);
		} else {
			return search(root.right, key);
		}
	}

	// ===
	public static TreeNode prepareTree(int[] values) {
		TreeNode[] treeArray = new TreeNode[values.length];
		for (int i = 0; i < values.length; i++) {
			if (values[i] == -999) {
				treeArray[i] = null;
			} else {
				treeArray[i] = new TreeNode(values[i]);
			}
		}

		for (int i = 0; i < values.length; i++) {
			TreeNode node = treeArray[i];
			if (((2 * i) + 1 < values.length) && ((2 * i) + 2 < values.length)) {
				node.left = treeArray[(2 * i) + 1];
				node.right = treeArray[(2 * i) + 2];
			}
		}
		return treeArray[0];
	}

	public static void inOrder(TreeNode root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.val + " ");
			inOrder(root.right);
		}
	}

	static class TreeNode {
		TreeNode left;
		TreeNode right;
		int val;

		public TreeNode(int val) {
			super();
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}
}
