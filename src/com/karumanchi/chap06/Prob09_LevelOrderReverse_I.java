package com.karumanchi.chap06;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Prob09_LevelOrderReverse_I {
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

		n1.levelOrderReverse(n1);
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

		public void levelOrderReverse(BinaryTreeNode root) {

			Queue<BinaryTreeNode> q = new LinkedList<>();
			q.add(root);

			Stack<List<BinaryTreeNode>> stack = new Stack<>();
			while (!q.isEmpty()) {
				int size = q.size();

				List<BinaryTreeNode> list = new ArrayList<>();

				for (int i = 0; i < size; i++) {
					BinaryTreeNode tmp = q.poll();
					list.add(tmp);

					if (tmp.left != null) {
						q.add(tmp.left);
					}
					if (tmp.right != null) {
						q.add(tmp.right);
					}
				}
				stack.push(list);
			}

			while (!stack.isEmpty()) {
				List<BinaryTreeNode> list = stack.pop();
				for (BinaryTreeNode node : list) {
					System.out.print(node.value + " ");
				}
				System.out.println();

			}
		}
	}
}
