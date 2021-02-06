package com.williamfiset.graphs.codecamp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * Time Complexity: O(E)
 */
public class Prob13_EularianPathCycle {

	public static void main(String[] args) {
		int n = 7;
		List<List<Integer>> graph = initializeEmptyGraph(n);

		addDirectedEdge(graph, 1, 2);
		addDirectedEdge(graph, 1, 3);
		addDirectedEdge(graph, 2, 2);
		addDirectedEdge(graph, 2, 4);
		addDirectedEdge(graph, 2, 4);
		addDirectedEdge(graph, 3, 1);
		addDirectedEdge(graph, 3, 2);
		addDirectedEdge(graph, 3, 5);
		addDirectedEdge(graph, 4, 3);
		addDirectedEdge(graph, 4, 6);
		addDirectedEdge(graph, 5, 6);
		addDirectedEdge(graph, 6, 3);

		Prob13_EularianPathCycle solver = new Prob13_EularianPathCycle(graph, n);

		// Outputs path: [1, 3, 5, 6, 3, 2, 4, 3, 1, 2, 2, 4, 6]
		System.out.println(solver.getEulerianPath());
	}

	private List<Integer> getEulerianPath() {
		setup();

		if (!graphHasEulerianPath())
			return null;

		dfs(findStartNode());

		if (path.size() != edgeCount + 1)
			return null;

		return path;
	}

	private void dfs(int at) {
		while (out[at] != 0) {
			int next = graph.get(at).get(--out[at]);
			dfs(next);
		}
		path.addFirst(at);
	}

	LinkedList<Integer> path = new LinkedList<>();
	int edgeCount = 0;

	private int findStartNode() {
		int start = 0;
		for (int i = 0; i < n; i++) {
			if (out[i] - in[i] == 1) {
				return i;
			}

			if (out[i] > 0) {
				start = i;
			}
		}

		return start;
	}

	private boolean graphHasEulerianPath() {
		int startNodes = 0, endNodes = 0;
		for (int i = 0; i < n; i++) {
			if (in[i] - out[i] > 1 || out[i] - in[i] > 1) {
				return false;
			} else if (in[i] - out[i] == 1) {
				endNodes++;
			} else if (out[i] - in[i] == 1) {
				startNodes++;
			}
		}
		return (startNodes == 0 && endNodes == 0) || (startNodes == 1 && endNodes == 1);
	}

	int[] in;
	int[] out;
	List<List<Integer>> graph;
	int n;
	
	private void setup() {
		this.in = new int[n];
		this.out = new int[n];

		for (int at = 0; at < n; at++) {
			for (int eachAdjVert : graph.get(at)) {
				out[at]++;
				in[eachAdjVert]++;
				edgeCount++;
			}
		}
	}

	Prob13_EularianPathCycle(List<List<Integer>> graph, int n) {
		this.graph = graph;
		this.n = n;
	}

	private static void addDirectedEdge(List<List<Integer>> g, int i, int j) {
		g.get(i).add(j);
	}

	private static List<List<Integer>> initializeEmptyGraph(int n) {
		List<List<Integer>> g = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			g.add(i, new ArrayList<>());
		}
		return g;
	}

}
