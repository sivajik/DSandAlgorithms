package com.williamfiset.graphs;

import java.util.*;

public class EulerianPathDirectedEdges {
	public static void main(String[] args) {
		exampleFromSlides();

	}

	private final int n;
	private int edgeCount;
	private int[] in, out;
	private LinkedList<Integer> path;
	private List<List<Integer>> graph;

	public EulerianPathDirectedEdges(List<List<Integer>> graph) {
		this.graph = graph;
		this.n = graph.size();
		path = new LinkedList<>();
	}

	private static void exampleFromSlides() {
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

		EulerianPathDirectedEdges solver;
		solver = new EulerianPathDirectedEdges(graph);

		// Outputs path: [1, 3, 5, 6, 3, 2, 4, 3, 1, 2, 2, 4, 6]
		System.out.println(Arrays.toString(solver.getEulerianPath()));
	}

	private int[] getEulerianPath() {
		setup();

		if (!graphHasEulerianPath()) {
			return null;
		}

		dfs(findStartNode());

		if (path.size() != edgeCount + 1) {
			return null;
		}

		int[] soln = new int[edgeCount + 1];
		for (int i = 0; !path.isEmpty(); i++)
			soln[i] = path.removeFirst();

		return soln;
	}

	private void dfs(int at) {
		while (out[at] != 0) {
			int next = this.graph.get(at).get(--out[at]);
			dfs(next);
		}
		this.path.addFirst(at);
	}

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
		if (edgeCount == 0)
			return false;
		int startNodes = 0, endNodes = 0;

		for (int i = 0; i < n; i++) {
			if (out[i] - in[i] > 1 || in[i] - out[i] > 1) {
				return false;
			} else if (out[i] - in[i] == 1) {
				startNodes++;
			} else if (in[i] - out[i] == 1) {
				endNodes++;
			}
		}

		return (startNodes == 0 && endNodes == 0) || (startNodes == 1 && endNodes == 1);
	}

	private void setup() {
		in = new int[n];
		out = new int[n];
		edgeCount = 0;
		for (int from = 0; from < n; from++) {
			for (Integer to : this.graph.get(from)) {
				in[to]++;
				out[from]++;
				edgeCount++;
			}
		}

	}

	private static void addDirectedEdge(List<List<Integer>> graph, int i, int j) {
		graph.get(i).add(j);
	}

	private static List<List<Integer>> initializeEmptyGraph(int n) {
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}
		return graph;
	}

	private static void smallExample() {
		int n = 5;
		List<List<Integer>> graph = initializeEmptyGraph(n);

		addDirectedEdge(graph, 0, 1);
		addDirectedEdge(graph, 1, 2);
		addDirectedEdge(graph, 1, 4);
		addDirectedEdge(graph, 1, 3);
		addDirectedEdge(graph, 2, 1);
		addDirectedEdge(graph, 4, 1);

		EulerianPathDirectedEdges solver;
		solver = new EulerianPathDirectedEdges(graph);

		// Outputs path: [0, 1, 2, 1, 4, 1, 3]
		System.out.println(Arrays.toString(solver.getEulerianPath()));
	}
}
