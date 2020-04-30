package comkarumanchi.chap06;

public class Prob01_MaxElementInBinaryTree_R {

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

		int max = n1.maxElement(n1);
		System.out.println(max);
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

		public int maxElement(BinaryTreeNode root) {
			int max = Integer.MIN_VALUE;

			if (root != null) {
				int left = maxElement(root.left);
				int right = maxElement(root.right);
				if (left > right) {
					max = left;
				} else {
					max = right;
				}
				max = Math.max(root.value, max);
			}
			return max;
		}
	}
}
