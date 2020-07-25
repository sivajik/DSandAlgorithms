package com.williamfiset.graphs;

import java.util.*;

public class DijkstrasShortestPath {
	public static void main(String[] args) throws Exception {
		DijkstrasShortestPath d = new DijkstrasShortestPath(5);
		d.addEdge(0, 1, 4);
		d.addEdge(0, 2, 1);
		d.addEdge(2, 1, 2);
		d.addEdge(1, 3, 1);
		d.addEdge(2, 3, 5);
		d.addEdge(3, 4, 3);

		System.out.println(Arrays.toString(d.dijkstra(0)));
	}

	public double[] dijkstra(int start) {
		double[] dist = new double[n];
		int[] prev = new int[n];
		Arrays.fill(dist, Double.POSITIVE_INFINITY);

		boolean[] visited = new boolean[n];
		dist[start] = 0;
		visited[start] = true;

		final double EPS = 1e-6;

		PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>() {
			public int compare(Node node1, Node node2) {
				if (Math.abs(node1.value - node2.value) < EPS)
					return 0;
				return (node1.value - node2.value) > 0 ? +1 : -1;
			}
		});

		pq.add(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node currNode = pq.poll();
			
			if (dist[currNode.id] < currNode.value) {
				continue;
			}
			
			// get all adj nodes and ensure they are not visited

			visited[currNode.id] = true;
			List<Edge> adjEdgesFromCurrNode = this.graph.get(currNode.id);
			for (int i = 0; i < adjEdgesFromCurrNode.size(); i++) {
				Edge currEdge = adjEdgesFromCurrNode.get(i);

				if (visited[currEdge.to]) {
					continue; // already visited so dont touch again.
				}

				double newCost = currEdge.cost + dist[currEdge.from];
				if (newCost < dist[currEdge.to]) {
					prev[currEdge.to] = currEdge.from;
					dist[currEdge.to] = newCost;
					pq.add(new Node(currEdge.to, newCost));
				}
			}
		}

		printPaths(prev);
		return dist;
	}

	private void printPaths(int[] prev) {
		for (int i = 0; i < prev.length; i++) {
			List<Integer> path = new ArrayList<Integer>();
			int curr = prev[i];
			while (curr != 0) {
				path.add(curr);
				curr = prev[curr];
			}
			path.add(curr);
			Collections.reverse(path);
			System.out.println(i + " -> " + path);

		}
	}

	List<List<Edge>> graph;
	int n;

	public DijkstrasShortestPath(int n) {
		this.n = n;
		createEmptyGraph(n);
	}

	public void createEmptyGraph(int n) {
		this.graph = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}
	}

	public void addEdge(int from, int to, double cost) {
		Edge edge = new Edge(from, to, cost);
		this.graph.get(from).add(edge);
	}

	public static class Edge {
		double cost;
		int from, to;

		public Edge(int from, int to, double cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}

	public static class Node {
		int id;
		double value;

		public Node(int id, double value) {
			this.id = id;
			this.value = value;
		}
	}
}