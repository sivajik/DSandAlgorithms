package com.williamfiset.graphs;

import java.util.*;

public class TopologocalSort {
	static class Edge {
		int from, to, weight;

		public Edge(int f, int t, int w) {
			from = f;
			to = t;
			weight = w;
		}
	}

	// Example usage of topological sort
	public static void main(String[] args) {
		final int N = 7;
		Map<Integer, List<Edge>> graph = new HashMap<>();
		for (int i = 0; i < N; i++)
			graph.put(i, new ArrayList<>());

		graph.get(0).add(new Edge(0, 1, 3));
		graph.get(0).add(new Edge(0, 2, 2));
		graph.get(0).add(new Edge(0, 5, 3));
		graph.get(1).add(new Edge(1, 3, 1));
		graph.get(1).add(new Edge(1, 2, 6));
		graph.get(2).add(new Edge(2, 3, 1));
		graph.get(2).add(new Edge(2, 4, 10));
		graph.get(3).add(new Edge(3, 4, 5));
		graph.get(5).add(new Edge(5, 4, 7));

		int[] ordering = topologicalSort(graph, N);

		// // Prints: [6, 0, 5, 1, 2, 3, 4]
		System.out.println(java.util.Arrays.toString(ordering));

	}

	private static int[] topologicalSort(Map<Integer, List<Edge>> graph, int n) {
		boolean[] visited = new boolean[n];
		List<Integer> l = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			if (visited[i] == false) {
				DFS(i, visited, graph, l);
			}
		}
		int[] result = new int[l.size()];
		for (int i = 0; i < l.size(); i++) {
			result[i]  =l.get(i);
		}

		return result;
	}

	private static void DFS(int node, boolean[] visited, Map<Integer, List<Edge>> graph, List<Integer> l) {
		visited[node] = true;
		for (Edge adjEdgeOfNode : graph.get(node)) {
			if (visited[adjEdgeOfNode.to] == false) {
				DFS(adjEdgeOfNode.to, visited, graph, l);
			}
		}
		l.add(0, node);
	}
}
