package com.williamfiset.graphs.codecamp;

import static java.lang.Math.min;

import java.util.ArrayList;
import java.util.List;

public class Prob11_ArticulationPoints {

	public static void main(String[] args) {
		int n = 9;
		List<List<Integer>> graph = createGraph(n);

		addEdge(graph, 0, 1);
		addEdge(graph, 0, 2);
		addEdge(graph, 1, 2);
		addEdge(graph, 2, 3);
		addEdge(graph, 3, 4);
		addEdge(graph, 2, 5);
		addEdge(graph, 5, 6);
		addEdge(graph, 6, 7);
		addEdge(graph, 7, 8);
		addEdge(graph, 8, 5);

		Prob11_ArticulationPoints solver = new Prob11_ArticulationPoints(graph, n);
		boolean[] art = solver.findArticulationPoints();

		// Prints:
		// Node 2 is an articulation
		// Node 3 is an articulation
		// Node 5 is an articulation
		for (int i = 0; i < n; i++)
			if (art[i])
				System.out.printf("Node %d is an articulation\n", i);
	}

	List<List<Integer>> graph;
	int n;

	public Prob11_ArticulationPoints(List<List<Integer>> graph2, int n2) {
		this.graph = graph2;
		this.n = n2;
	}

	int[] ids;
	int[] low;
	int id = 0;
	boolean[] visited;
	int outComeEdgeCount = 0;
	boolean[] isArt;

	private boolean[] findArticulationPoints() {
		ids = new int[n];
		low = new int[n];

		isArt = new boolean[n];

		visited = new boolean[n];

		for (int i = 0; i < n; i++) {
			if (visited[i] == false) {
				outComeEdgeCount = 0;
				dfs(i, i, -1);
				// we are setting in dfs but ensure yo check here as well.
				isArt[i] = outComeEdgeCount > 1;
			}
		}

		return isArt;
	}

	private void dfs(int root, int at, int parent) {
		if (parent == root) {
			outComeEdgeCount++;
		}

		visited[at] = true;
		low[at] = id;
		ids[at] = id;
		id++;

		for (int eachAdjVert : graph.get(at)) {
			if (eachAdjVert == parent) {
				continue;
			}
			if (visited[eachAdjVert] == false) {
				dfs(root, eachAdjVert, at);
				low[at] = min(low[at], low[eachAdjVert]);
				if (ids[at] <= low[eachAdjVert]) {
					isArt[at] = true;
				}
			} else {
				low[at] = min(low[at], ids[eachAdjVert]);
			}
		}
	}

	private static void addEdge(List<List<Integer>> g, int i, int j) {
		g.get(i).add(j);
		g.get(j).add(i);
	}

	private static List<List<Integer>> createGraph(int n) {
		List<List<Integer>> g = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			g.add(i, new ArrayList<>());
		}
		return g;
	}

}
