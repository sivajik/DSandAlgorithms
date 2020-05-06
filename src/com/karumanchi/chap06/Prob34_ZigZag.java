package com.karumanchi.chap06;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Prob34_ZigZag {

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

		n1.printZigZag(n1);

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

		public void printZigZag(BinaryTreeNode root) {
			Queue<BinaryTreeNode> q = new LinkedList<>();

			q.add(root);
			q.add(null);
			List<BinaryTreeNode> localList = new ArrayList<>();

			boolean leftToRight = true;

			while (!q.isEmpty()) {
				BinaryTreeNode tmp = q.poll();

				if (tmp != null) {
					localList.add(tmp);
					if (tmp.left != null) {
						q.add(tmp.left);
					}
					if (tmp.right != null) {
						q.add(tmp.right);
					}

				} else {
					if (leftToRight) {
						for (BinaryTreeNode t : localList) {
							System.out.print(t.value + " ");
						}
						System.out.println();
						localList.clear();
					} else {
						for (int i = localList.size() - 1; i >= 0; i--) {
							System.out.print(localList.get(i).value + " ");
						}
						System.out.println();
						localList.clear();
					}

					leftToRight = !leftToRight;

					if (!q.isEmpty()) {
						q.add(null);
					}
				}

			}

		}
	}

}
