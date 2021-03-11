package com.gfg.ds.heap;

import java.util.LinkedList;
import java.util.Queue;

public class P14_CheckBinaryTreeaHeap {

	public static void main(String[] args) {
		Node root = null;
		root = newNode(10);
		root.left = newNode(9);
		root.right = newNode(8);
		root.left.left = newNode(7);
		root.left.right = newNode(6);
		root.right.left = newNode(5);
		root.right.right = newNode(4);
		root.left.left.left = newNode(3);
		root.left.left.right = newNode(2);
		root.left.right.left = newNode(1);

		// Function call
		if (isHeap(root))
			System.out.print("Given binary tree is a Heap\n");
		else
			System.out.print("Given binary tree is not a Heap\n");

	}

	static boolean isHeap(Node root) {
		Queue<Node> q = new LinkedList<>();
		q.add(root);

		boolean nullChild = false;
		while (!q.isEmpty()) {
			Node t = q.poll();
			
			if (t.left != null) {
				if (nullChild || t.left.data >= t.data) {
					return false;
				}
				q.add(t.left);
			} else {
				nullChild = true;
			}
			
			if (t.right != null) {
				if (nullChild || t.right.data >= t.data) {
					return false;
				}
				q.add(t.right);
			} else {
				nullChild = true;
			}
		}
		return true;
	}

	// Tree node structure
	static class Node {
		int data;
		Node left;
		Node right;
	};

	static Node newNode(int k) {
		Node node = new Node();
		node.data = k;
		node.right = node.left = null;
		return node;
	}
}
