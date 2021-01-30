package com.williamfiset.graphs.codecamp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prob06_SSSP_TopologicalSort {

	public static void main(String[] args) {
		final int N = 7;
		Map<Integer, List<Edge>> graph = new HashMap<>();
		for (int i = 0; i < N; i++) {
			graph.put(i, new ArrayList<>());
		}
		graph.get(0).add(new Edge(0, 1, 3));
		graph.get(0).add(new Edge(0, 2, 2));
		graph.get(0).add(new Edge(0, 5, 3));
		graph.get(1).add(new Edge(1, 3, 1));
		graph.get(1).add(new Edge(1, 2, 6));
		graph.get(2).add(new Edge(2, 3, 1));
		graph.get(2).add(new Edge(2, 4, 10));
		graph.get(3).add(new Edge(3, 4, 5));
		graph.get(5).add(new Edge(5, 4, 7));

		List<Integer> ordering = topologicalSort(graph, N);

		int[] dists = dagShortestPath(graph, 0, N);

		System.out.println(Arrays.toString(dists));

		// Find the shortest path from 0 to 4 which is 8.0
		System.out.println(dists[4]);

		// Find the shortest path from 0 to 6 which
		// is null since 6 is not reachable!
		System.out.println(dists[6]);
	}

	private static int[] dagShortestPath(Map<Integer, List<Edge>> graph, int start, int n) {
		int[] dist = new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);

		dist[start] = 0;
		List<Integer> ordering = topologicalSort(graph, n);

		// 6 0 5 1 2 3 4
		for (int i = 0; i < n; i++) {
			int currVertex = ordering.get(i);// 6 0 5 1 2 3 4

			if (dist[currVertex] != Integer.MAX_VALUE) {
				List<Edge> adjElems = graph.get(currVertex);
				if (adjElems != null) {
					for (Edge e : adjElems) {
						int newCost = e.cost + dist[currVertex];
						if (dist[e.v] == Integer.MAX_VALUE) {
							dist[e.v] = newCost;
						} else if (newCost < dist[e.v]) {
							dist[e.v] = newCost;
						}
					}
				}
			}
		}

		return dist;
	}

	private static List<Integer> topologicalSort(Map<Integer, List<Edge>> graph, int n) {
		List<Integer> l = new ArrayList<>();
		boolean[] visited = new boolean[n];

		for (int i = 0; i < n; i++) {
			if (visited[i] == false) {
				dfs(i, graph, l, visited);
			}
		}
		System.out.println(l);
		return l;
	}

	private static void dfs(int at, Map<Integer, List<Edge>> graph, List<Integer> l, boolean[] visited) {
		visited[at] = true;

		for (Edge eachAdjEdge : graph.get(at)) {
			if (visited[eachAdjEdge.v] == false) {
				dfs(eachAdjEdge.v, graph, l, visited);
			}
		}
		l.add(0, at);
	}

	static class Edge {
		int u;
		int v;
		int cost;

		Edge(int a, int b, int c) {
			this.u = a;
			this.v = b;
			this.cost = c;
		}
	}
}
