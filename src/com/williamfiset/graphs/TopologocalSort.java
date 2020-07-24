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

		// Finds all the shortest paths starting at node 0
		Integer[] dists = dagShortestPath(graph, 0, N);

		// Find the shortest path from 0 to 4 which is 8.0
		System.out.println(dists[4]);

		// Find the shortest path from 0 to 6 which
		// is null since 6 is not reachable!
		System.out.println(dists[6]);
	}

	private static Integer[] dagShortestPath(Map<Integer, List<Edge>> graph, int start, int n) {
		int[] topSort = topologicalSort(graph, n);

		Integer[] dist = new Integer[n];

		dist[start] = 0;

		for (int i = 0; i < n; i++) {
			int eachNodeInTopSortOrder = topSort[i];
			if (graph.get(eachNodeInTopSortOrder) != null) {
				for (Edge eachAdjEdge : graph.get(eachNodeInTopSortOrder)) {
					if (dist[eachNodeInTopSortOrder] == null) {
						int w =3;
						System.out.println(w);
					}
					int newDistance = eachAdjEdge.weight + dist[eachNodeInTopSortOrder];
					if (dist[eachAdjEdge.to] != null) {
						dist[eachAdjEdge.to] = Math.min(dist[eachAdjEdge.to], newDistance);
					} else {
						dist[eachAdjEdge.to] = newDistance;
					}
				}
			}
		}
		return dist;
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
			result[i] = l.get(i);
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
