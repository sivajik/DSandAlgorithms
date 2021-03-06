package com.williamfiset.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LCAOfTree {
	private int n;

	private int tourIndex = 0;

	private long[] nodeDepth;
	private TreeNode[] nodeOrder;
	private int[] last;

	private MinSparseTable sparseTable;

	public LCAOfTree(TreeNode root) {
		this.n = root.n;
		setup(root);
	}

	private void setup(TreeNode root) {
		int eulerTourSize = (2 * n) - 1;
		this.nodeOrder = new TreeNode[eulerTourSize];
		this.nodeDepth = new long[eulerTourSize];
		this.last = new int[n];

		dfs(root, /* depth = */0);
		sparseTable = new MinSparseTable(nodeDepth);
	}

	private void dfs(TreeNode root, int depth) {
		if (root == null) {
			return;
		}
		visit(root, depth);
		for (TreeNode eachChild : root.children) {
			dfs(eachChild, depth + 1);
			visit(root, depth);
		}
	}

	private void visit(TreeNode root, int depth) {
		this.nodeDepth[tourIndex] = depth;
		this.nodeOrder[tourIndex] = root;
		this.last[root.index] = tourIndex;
		tourIndex++;
	}

	public static void main(String[] args) {
		TreeNode root = createFirstTreeFromSlides();
		LCAOfTree solver = new LCAOfTree(root);

		// LCA of 13 and 14 = 2
		TreeNode lca = solver.lca(13, 14);
		System.out.printf("LCA of 13 and 14 = %s\n", lca);
		if (lca.index != 2) {
			System.out.println("Error, expected lca to be 2");
		}

		// LCA of 9 and 11 = 0
		lca = solver.lca(9, 11);
		System.out.printf("LCA of 9 and 11 = %s\n", lca);
		if (lca.index != 0) {
			System.out.println("Error, expected lca to be 0");
		}

		// LCA of 12 and 12 = 12
		lca = solver.lca(12, 12);
		System.out.printf("LCA of 12 and 12 = %s\n", lca);
		if (lca.index != 12) {
			System.out.println("Error, expected lca to be 12");
		}
	}

	private TreeNode lca(int index1, int index2) {
		int l = Math.min(this.last[index1], this.last[index2]);
		int r = Math.max(this.last[index1], this.last[index2]);
		int index = this.sparseTable.queryIndex(l, r);
		// TODO Auto-generated method stub
		return this.nodeOrder[index];
	}

	private static TreeNode createFirstTreeFromSlides() {
		int n = 17;
		List<List<Integer>> tree = createEmptyGraph(n);

		addUndirectedEdge(tree, 0, 1);
		addUndirectedEdge(tree, 0, 2);
		addUndirectedEdge(tree, 1, 3);
		addUndirectedEdge(tree, 1, 4);
		addUndirectedEdge(tree, 2, 5);
		addUndirectedEdge(tree, 2, 6);
		addUndirectedEdge(tree, 2, 7);
		addUndirectedEdge(tree, 3, 8);
		addUndirectedEdge(tree, 3, 9);
		addUndirectedEdge(tree, 5, 10);
		addUndirectedEdge(tree, 5, 11);
		addUndirectedEdge(tree, 7, 12);
		addUndirectedEdge(tree, 7, 13);
		addUndirectedEdge(tree, 11, 14);
		addUndirectedEdge(tree, 11, 15);
		addUndirectedEdge(tree, 11, 16);

		return TreeNode.rootTree(tree, 0);
	}

	public static List<List<Integer>> createEmptyGraph(int n) {
		List<List<Integer>> graph = new ArrayList<>(n);
		for (int i = 0; i < n; i++)
			graph.add(new LinkedList<>());
		return graph;
	}

	public static void addUndirectedEdge(List<List<Integer>> graph, int from, int to) {
		graph.get(from).add(to);
		graph.get(to).add(from);
	}

	public static class TreeNode {
		// Number of nodes in the subtree. Computed when tree is built.
		private int n;

		private int index;
		private TreeNode parent;
		private List<TreeNode> children;

		TreeNode(int i) {
			this.index = i;
			this.children = new ArrayList<>();
			this.parent = null;
			this.n = 0;
		}

		public static TreeNode rootTree(List<List<Integer>> tree, int i) {
			TreeNode root = new TreeNode(i);
			TreeNode rootedTree = buildTree(tree, root);
			return rootedTree;
		}

		private static TreeNode buildTree(List<List<Integer>> graph, TreeNode root) {
			int subtreeNodeCount = 1;
			for (Integer adjNodeOfRoot : graph.get(root.index)) {
				if (root.parent != null && root.parent.index == adjNodeOfRoot) {
					continue;
				}
				TreeNode newChildNode = new TreeNode(adjNodeOfRoot);
				newChildNode.parent = root;
				root.children.add(newChildNode);
				buildTree(graph, newChildNode);
				subtreeNodeCount += newChildNode.n;
			}
			root.n = subtreeNodeCount;
			return root;
		}

		@Override
		public String toString() {
			return "TreeNode [index=" + index + "]";
		}

	}

	// Sparse table for efficient minimum range queries in O(1) with O(nlogn) space
	private static class MinSparseTable {

		// The number of elements in the original input array.
		private int n;

		// The maximum power of 2 needed. This value is floor(log2(n))
		private int P;

		// Fast log base 2 logarithm lookup table, 1 <= i <= n
		private int[] log2;

		// The sparse table values.
		private long[][] dp;

		// Index Table (IT) associated with the values in the sparse table.
		private int[][] it;

		public MinSparseTable(long[] values) {
			init(values);
		}

		private void init(long[] v) {
			n = v.length;
			P = (int) (Math.log(n) / Math.log(2));
			dp = new long[P + 1][n];
			it = new int[P + 1][n];

			for (int i = 0; i < n; i++) {
				dp[0][i] = v[i];
				it[0][i] = i;
			}

			log2 = new int[n + 1];
			for (int i = 2; i <= n; i++) {
				log2[i] = log2[i / 2] + 1;
			}

			// Build sparse table combining the values of the previous intervals.
			for (int p = 1; p <= P; p++) {
				for (int i = 0; i + (1 << p) <= n; i++) {
					long leftInterval = dp[p - 1][i];
					long rightInterval = dp[p - 1][i + (1 << (p - 1))];
					dp[p][i] = Math.min(leftInterval, rightInterval);

					// Propagate the index of the best value
					if (leftInterval <= rightInterval) {
						it[p][i] = it[p - 1][i];
					} else {
						it[p][i] = it[p - 1][i + (1 << (p - 1))];
					}
				}
			}
		}

		// Returns the index of the minimum element in the range [l, r].
		public int queryIndex(int l, int r) {
			int len = r - l + 1;
			int p = log2[r - l + 1];
			long leftInterval = dp[p][l];
			long rightInterval = dp[p][r - (1 << p) + 1];
			if (leftInterval <= rightInterval) {
				return it[p][l];
			} else {
				return it[p][r - (1 << p) + 1];
			}
		}
	}
}
