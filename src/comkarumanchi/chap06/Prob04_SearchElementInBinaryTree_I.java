package comkarumanchi.chap06;

import java.util.LinkedList;
import java.util.Queue;

public class Prob04_SearchElementInBinaryTree_I {

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

		System.out.println(n1.searchElement(n1, 4));
		System.out.println(n1.searchElement(n1, 44));
		System.out.println(n1.searchElement(n1, 7));
		System.out.println(n1.searchElement(n1, 77));
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

		public boolean searchElement(BinaryTreeNode root, int lookFor) {
			Queue<BinaryTreeNode> q = new LinkedList<>();
			q.add(root);

			while (!q.isEmpty()) {
				BinaryTreeNode tmp = q.poll();
				if (tmp.value == lookFor) {
					return true;
				}

				if (tmp.left != null) {
					q.add(tmp.left);
				}
				if (tmp.right != null) {
					q.add(tmp.right);
				}
			}
			return false;
		}
	}
}
