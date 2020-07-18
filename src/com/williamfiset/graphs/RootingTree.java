package com.williamfiset.graphs;

import java.util.ArrayList;
import java.util.List;

public class RootingTree {
	private static List<List<Integer>> createGraph(int n) {
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}
		return graph;
	}

	private static void addUndirectedEdge(List<List<Integer>> graph, int i, int j) {
		graph.get(i).add(j);
		graph.get(j).add(i);
	}

	public static class TreeNode {
		private int id;
		private TreeNode parent;
		private List<TreeNode> children;

		TreeNode(int id) {
			this.id = id;
			this.parent = null;
			this.children = new ArrayList<>();
		}
		public String toString() {
			return id + "[" + (parent != null ? parent.id : -1) + "]";
		}

	}

	private static TreeNode rootTree(List<List<Integer>> graph, int rootNode) {
		TreeNode root = new TreeNode(rootNode);
		root = buildTree(root, graph);
		return root;
	}

	private static TreeNode buildTree(TreeNode node, List<List<Integer>> graph) {
		for (int eachAdjVertex : graph.get(node.id)) {
			if (node.parent != null && node.parent.id == eachAdjVertex) {
				// System.out.println("Skipping loop causing stuff...");
				continue;
			}
			TreeNode newChild = new TreeNode(eachAdjVertex);
			node.children.add(newChild);
			newChild.parent = node;
			buildTree(newChild, graph);
		}
		return node;
	}

	public static void main(String[] args) {
		List<List<Integer>> graph = createGraph(9);
		addUndirectedEdge(graph, 0, 1);
		addUndirectedEdge(graph, 2, 1);
		addUndirectedEdge(graph, 2, 3);
		addUndirectedEdge(graph, 3, 4);
		addUndirectedEdge(graph, 5, 3);
		addUndirectedEdge(graph, 2, 6);
		addUndirectedEdge(graph, 6, 7);
		addUndirectedEdge(graph, 6, 8);

		// Rooted at 6 the tree should look like:
		// 6
		// 2 7 8
		// 1 3
		// 0 4 5

		TreeNode root = rootTree(graph, 6);

		// Layer 0: [6]
		System.out.println(root);

		// Layer 1: [2, 7, 8]
		System.out.println(root.children);

		// Layer 2: [1, 3]
		System.out.println(root.children.get(0).children);

		// Layer 3: [0], [4, 5]
		System.out.println(
				root.children.get(0).children.get(0).children + ", " + root.children.get(0).children.get(1).children);

		// Rooted at 3 the tree should look like:
		// 3
		// 2 4 5
		// 6 1
		// 7 8 0

		// Layer 0: [3]
		root = rootTree(graph, 3);
		System.out.println();
		System.out.println(root);

		// Layer 1: [2, 4, 5]
		System.out.println(root.children);

		// Layer 2: [1, 6]
		System.out.println(root.children.get(0).children);

		// Layer 3: [0], [7, 8]
		System.out.println(
				root.children.get(0).children.get(0).children + ", " + root.children.get(0).children.get(1).children);
	}

}
