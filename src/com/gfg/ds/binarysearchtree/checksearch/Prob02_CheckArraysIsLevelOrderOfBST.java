package com.gfg.ds.binarysearchtree.checksearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Prob02_CheckArraysIsLevelOrderOfBST {
	public static void main(String[] args) {
		int[] arr = new int[] { 7, 4, 12, 3, 6, 8, 1, 5, 10 };
// 		System.out.println(isArrayaBSTBruteForce(arr));
		System.out.println(isArrayaBSTApproach2(arr));

		int[] arr1 = new int[] { 11, 6, 13, 5, 12, 10 };
		System.out.println(isArrayaBSTApproach2(arr1));
//		  System.out.println(isArrayaBSTBruteForce(arr1));
	}

	static class Pair {
		int val;
		int min;
		int max;

		public Pair(int val, int min, int max) {
			super();
			this.val = val;
			this.min = min;
			this.max = max;
		}

	}

	private static boolean isArrayaBSTApproach2(int[] arr) {
		Queue<Pair> q = new LinkedList<>();

		int i = 0;
		q.add(new Pair(arr[i++], Integer.MIN_VALUE, Integer.MAX_VALUE));

		while (q.size() > 0) {
			Pair p = q.poll();

			if (i < arr.length && arr[i] < p.val && arr[i] > p.min) {
				// eligible as left child.
				Pair newPar = new Pair(arr[i], p.min, p.val);
				q.add(newPar);
				i++;
			}

			if (i < arr.length && arr[i] > p.val && arr[i] < p.max) {
				// eligible as right child
				Pair newPar = new Pair(arr[i], p.val, p.max);
				q.add(newPar);
				i++;
			}
		}

		System.out.println(i + " , " + arr.length);

		return i == arr.length;
	}

	private static boolean isArrayaBSTBruteForce(int[] arr) {
		TreeNode root = makeBST(arr);
		int[] levelOrderArr = getLevelOrder(root);
		System.out.println("Original " + Arrays.toString(arr));
		System.out.println("Tree     " + Arrays.toString(levelOrderArr));
		return Arrays.equals(arr, levelOrderArr);
	}

	private static int[] getLevelOrder(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		List<Integer> l = new ArrayList<>();
		while (!q.isEmpty()) {
			TreeNode temp = q.poll();
			l.add(temp.val);

			if (temp.left != null) {
				q.add(temp.left);
			}
			if (temp.right != null) {
				q.add(temp.right);
			}
		}
		int[] res = new int[l.size()];
		int c = 0;
		for (Integer i : l) {
			res[c++] = i;
		}
		return res;
	}

	private static TreeNode makeBST(int[] arr) {
		TreeNode root = null;
		for (int a : arr) {
			root = insert(root, a);
		}
		return root;
	}

	private static TreeNode insert(TreeNode root, int a) {
		if (root == null) {
			root = new TreeNode(a);
			return root;
		} else {
			if (a < root.val) {
				root.left = insert(root.left, a);
			} else {
				root.right = insert(root.right, a);
			}
		}
		return root;
	}

	// --------
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
