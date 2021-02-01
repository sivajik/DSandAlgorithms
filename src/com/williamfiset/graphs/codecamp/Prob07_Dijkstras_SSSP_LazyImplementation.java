package com.williamfiset.graphs.codecamp;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

/*
 * better impl could be O(E * log(v)) to O( (E+V) * log(v))
 */
public class Prob07_Dijkstras_SSSP_LazyImplementation {

	public static void main(String[] args) {
		Prob07_Dijkstras_SSSP_LazyImplementation p = new Prob07_Dijkstras_SSSP_LazyImplementation();
		p.createGraph(5);

		p.addEdge(0, 1, 4);
		p.addEdge(0, 2, 1);
		p.addEdge(2, 1, 2);
		p.addEdge(1, 3, 1);
		p.addEdge(2, 3, 5);
		p.addEdge(3, 4, 3);

		p.dijkstras(0);

	}

	private void dijkstras(int at) {
		int[] dist = new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);

		final double EPS = 1e-6;
		PriorityQueue<Node> q = new PriorityQueue<>(new Comparator<Node>() {

			@Override
			public int compare(Node node1, Node node2) {
				if (Math.abs(node1.value - node2.value) < EPS)
					return 0;
				return (node1.value - node2.value) > 0 ? +1 : -1;
			}

		});
		q.add(new Node(at, 0));
		dist[at] = 0;
		boolean[] visited = new boolean[n];

		while (!q.isEmpty()) {
			Node node = q.poll();
			visited[node.id] = true;

			if (dist[node.id] < node.value) {
				continue;
			}

			List<Edge> edges = adjList.get(node.id);

			for (int i = 0; i < edges.size(); i++) {
				Edge e = edges.get(i);

				if (visited[e.v]) {
					continue;
				}
				int newCost = dist[e.u] + e.w;

				if (newCost < dist[e.v]) {
					dist[e.v] = newCost;
					q.add(new Node(e.v, newCost));
				}
			}
		}

		System.out.println(Arrays.toString(dist));
	}

	// List<List<Integer>> adjList = new ArrayList<>();
	Map<Integer, List<Edge>> adjList = new HashMap<>();
	int n;

	public void createGraph(int n) {
		this.n = n;
		this.adjList = new HashMap<>();
		for (int i = 0; i < n; i++) {
			adjList.put(i, new ArrayList<>());
		}
	}

	public void addEdge(int u, int v, int w) {
		List<Edge> l = adjList.get(u);
		l.add(new Edge(u, v, w));
		this.adjList.put(u, l);
	}

	static class Edge {
		int u, v, w;

		Edge(int u, int v, int w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}

		public String toString() {
			return u + " -> " + v + " = " + w;
		}
	}

	static class Node {
		int id, value;

		Node(int id, int val) {
			this.id = id;
			this.value = val;
		}

		public String toString() {
			return "[" + id + "," + value + "]";
		}
	}
}
