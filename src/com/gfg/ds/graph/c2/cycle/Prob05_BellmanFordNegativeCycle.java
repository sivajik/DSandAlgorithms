package com.gfg.ds.graph.c2.cycle;

import java.util.LinkedList;

public class Prob05_BellmanFordNegativeCycle {

	public static void main(String[] args) {
		Graph graph = new Graph(5, 9, "dir");
		graph.addEdge(0, 1, -1);
		graph.addEdge(0, 2, 4);
		graph.addEdge(1, 2, 3);
		graph.addEdge(1, 3, 2);
		graph.addEdge(1, 4, 2);

		graph.addEdge(3, 2, 5);
		graph.addEdge(3, 1, 1);
		graph.addEdge(4, 3, -3);

		graph.addEdge(4, 0, -8);

		graph.bellmanFord(0);

	}

	static class Vertex {
		int id;

		Vertex(int label) {
			this.id = label;
		}
	}

	static class Edge {
		int src, dest, weight;

		public Edge(int src, int dest, int weight) {
			super();
			this.src = src;
			this.dest = dest;
			this.weight = weight;
		}

		Edge() {
			src = dest = weight = 0;
		}
	};

	static class Graph {
		private String dirOrUndi;
		private int vertexCount = 0;
		private int edgeCount = 0;

		LinkedList<Integer>[] adj;
		private Vertex[] vertexList;

		Edge edges[];

		public Graph(int totalCount, int edgeCount, String dirOrUndi) {
			this.vertexList = new Vertex[totalCount];
			this.vertexCount = totalCount;
			for (int i = 0; i < totalCount; i++) {
				vertexList[i] = new Vertex(i);
			}
			this.adj = new LinkedList[totalCount];
			for (int i = 0; i < totalCount; ++i) {
				adj[i] = new LinkedList<>();
			}
			this.dirOrUndi = dirOrUndi;
			this.edges = new Edge[edgeCount];
			this.edgeCount = edgeCount;
		}

		public void bellmanFord(int start) {
			int[] dist = new int[vertexCount];

			for (int i = 0; i < vertexCount; i++) {
				dist[i] = Integer.MAX_VALUE;
			}
			dist[start] = 0;

			for (int i = 1; i < vertexCount; i++) {
				for (int j = 0; j < edgeCount; j++) {
					int u = edges[j].src;
					int v = edges[j].dest;
					int w = edges[j].weight;

					if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
						dist[v] = dist[u] + w;
					}
				}
			}

			for (int j = 0; j < edgeCount; j++) {
				int u = edges[j].src;
				int v = edges[j].dest;
				int w = edges[j].weight;

				if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
					System.out.println(u + " -> " +v);
					System.out.println("Graph contains negative weight cycle");
					return;
				}
			}

			printArr(dist, vertexCount);
		}

		// A utility function used to print the solution
		void printArr(int dist[], int V) {
			System.out.println("Vertex Distance from Source");
			for (int i = 0; i < V; ++i)
				System.out.println(i + "\t\t" + dist[i]);
		}

		static int c = 0;

		public void addEdge(int v, int w, int weight) {
			Edge e = new Edge(v, w, weight);
			edges[c++] = e;
		}

	}
}
