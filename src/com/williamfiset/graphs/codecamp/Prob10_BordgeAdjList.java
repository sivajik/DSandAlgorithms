package com.williamfiset.graphs.codecamp;

import java.util.ArrayList;
import java.util.List;
import static java.lang.Math.min;

public class Prob10_BordgeAdjList {

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

		Prob10_BordgeAdjList solver = new Prob10_BordgeAdjList(graph, n);
		List<Integer> bridges = solver.findBridges();

		for (int i = 0; i < bridges.size(); i += 2) {
			int node1 = bridges.get(i);
			int node2 = bridges.get(i + 1);
			System.out.printf("Bridge between nodes: %d and %d\n", node1, node2);
		}
	}

	List<List<Integer>> graph;
	int n;

	public Prob10_BordgeAdjList(List<List<Integer>> graph2, int n2) {
		this.graph = graph2;
		this.n = n2;
	}

	int[] ids;
	int[] low;
	int id = 0;
	boolean[] visited;

	private List<Integer> findBridges() {
		ids = new int[n];
		low = new int[n];

		List<Integer> bridges = new ArrayList<>();

		visited = new boolean[n];

		for (int i = 0; i < n; i++) {
			if (visited[i] == false) {
				dfs(i, -1, bridges);
			}
		}

		return bridges;
	}

	private void dfs(int at, int parent, List<Integer> bridges) {
		visited[at] = true;
		low[at] = id;
		ids[at] = id;
		id++;

		for (int eachAdjVert : graph.get(at)) {
			if (eachAdjVert == parent) {
				continue;
			}
			if (visited[eachAdjVert] == false) {
				dfs(eachAdjVert, at, bridges);
				low[at] = min(low[at], low[eachAdjVert]);
				if (ids[at] < low[eachAdjVert]) {
					bridges.add(at);
					bridges.add(eachAdjVert);
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
