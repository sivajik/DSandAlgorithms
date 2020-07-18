package com.williamfiset.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IsomorphicGraphs {

	public static void main(String[] args) {

		List<List<Integer>> tree1 = createEmptyGraph(5);
		addUndirectedEdge(tree1, 2, 0);
		addUndirectedEdge(tree1, 3, 4);
		addUndirectedEdge(tree1, 2, 1);
		addUndirectedEdge(tree1, 2, 3);

		List<List<Integer>> tree2 = createEmptyGraph(5);
		addUndirectedEdge(tree2, 1, 0);
		addUndirectedEdge(tree2, 2, 4);
		addUndirectedEdge(tree2, 1, 3);
		addUndirectedEdge(tree2, 1, 2);

		if (!treesAreIsomorphic(tree1, tree2)) {
			System.out.println("Oops, these tree should be isomorphic!");
		} else {
			System.out.println("they are isomorphic!");
		}

		System.out.println("Encode test");
		List<List<Integer>> tree = createEmptyGraph(10);
		addUndirectedEdge(tree, 0, 2);
		addUndirectedEdge(tree, 0, 1);
		addUndirectedEdge(tree, 0, 3);
		addUndirectedEdge(tree, 2, 6);
		addUndirectedEdge(tree, 2, 7);
		addUndirectedEdge(tree, 1, 4);
		addUndirectedEdge(tree, 1, 5);
		addUndirectedEdge(tree, 5, 9);
		addUndirectedEdge(tree, 3, 8);

		TreeNode root0 = rootTree(tree, 0);
		System.out.println(encode(root0).equalsIgnoreCase("(((())())(()())(()))"));
	}

	private static List<Integer> findTreeCenters(List<List<Integer>> tree) {
		int n = tree.size();
		int[] degrees = new int[n];

		List<Integer> leaves = new ArrayList<>();
		int counter = 0;
		for (List<Integer> eachNodesAdj : tree) {
			if (eachNodesAdj.size() <= 1) {
				leaves.add(counter);
				degrees[counter++] = 0;
			} else {
				degrees[counter++] = eachNodesAdj.size();
			}
		}

		int processedLeavesCount = leaves.size();

		while (processedLeavesCount < n) {
			Set<Integer> newLeaves = new HashSet<>();
			for (Integer eachLeaf : leaves) {
				for (Integer eachLeafAdjNode : tree.get(eachLeaf)) {
					degrees[eachLeafAdjNode] = degrees[eachLeafAdjNode] - 1;
					if (degrees[eachLeafAdjNode] == 1) {
						newLeaves.add(eachLeafAdjNode);
					}
				}
				degrees[eachLeaf] = 0;
				processedLeavesCount += newLeaves.size();
				leaves = new  ArrayList(newLeaves);
			}
		}
		return leaves;
	}

	private static boolean treesAreIsomorphic(List<List<Integer>> tree1, List<List<Integer>> tree2) {
		if (tree1 == null || tree2 == null) {
			return false;
		}

		List<Integer> tree1Centered = findTreeCenters(tree1);
		TreeNode tree1Root = rootTree(tree1, tree1Centered.get(0));
		String encodedTree1Str = encode(tree1Root);

		List<Integer> tree2Centered = findTreeCenters(tree2);
		for (Integer eachCenter : tree2Centered) {
			TreeNode tree2Root = rootTree(tree2, eachCenter);
			String encodedTree2Str = encode(tree2Root);
			if (encodedTree1Str.equalsIgnoreCase(encodedTree2Str)) {
				return true;
			}
		}
		return false;
	}

	public static String encode(TreeNode node) {
		if (node == null) {
			return "";
		}
		List<String> labels = new ArrayList<>();

		for (TreeNode eachAdjNode : node.children) {
			labels.add(encode(eachAdjNode));
		}
		Collections.sort(labels);

		StringBuilder sbr = new StringBuilder();
		for (String label : labels) {
			sbr.append(label);
		}
		return "(" + sbr.toString() + ")";
	}

	private static TreeNode rootTree(List<List<Integer>> graph, int rootId) {
		TreeNode root = new TreeNode(rootId);
		root = buildTree(graph, root);
		return root;
	}

	private static TreeNode buildTree(List<List<Integer>> graph, TreeNode node) {
		for (Integer eachAdjNode : graph.get(node.id)) {
			if (node.parent != null && node.parent.id == eachAdjNode) {
				continue;
			}

			TreeNode dummy = new TreeNode(eachAdjNode);
			dummy.parent = node;
			node.children.add(dummy);
			buildTree(graph, dummy);
		}
		return node;
	}

	private static void addUndirectedEdge(List<List<Integer>> tree1, int i, int j) {
		tree1.get(i).add(j);
		tree1.get(j).add(i);
	}

	private static List<List<Integer>> createEmptyGraph(int n) {
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}
		return graph;
	}

	public static class TreeNode {
		public int id;
		public TreeNode parent;
		public List<TreeNode> children;

		TreeNode(int x) {
			this.id = x;
			this.children = new ArrayList<>();
		}
	}
}
