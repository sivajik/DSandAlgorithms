package com.gfg.ds.graph.mst;

import java.util.Arrays;

public class Prob04_KruskalsMST {

	public static void main(String[] args) {
		int V = 4; // Number of vertices in graph
		int E = 5; // Number of edges in graph
		Graph graph = new Graph(V, E);

		graph.addEdge(0, 1, 10);
		graph.addEdge(0, 2, 6);
		graph.addEdge(0, 3, 5);
		graph.addEdge(1, 3, 15);
		graph.addEdge(2, 3, 4);
		
		graph.kruskalMST();
	}

}

class Graph {

	public void kruskalMST() {
		Edge[] result = new Edge[V];
		int totalEdgesPicked = 0;
		for (int i = 0; i < V; i++) {
			result[i] = new Edge();
		}

		// sort the edge
		Arrays.sort(edges);

		// Initialise sub sets.
		Subset subsets[] = new Subset[V];
		for (int i = 0; i < V; i++) {
			subsets[i] = new Subset();
			subsets[i].rank = 0;
			subsets[i].parent = i;
		}

		// process.
		int i = 0;
		while (totalEdgesPicked < V - 1) {
			Edge nextEdge = edges[i++];

			int x = find(subsets, nextEdge.src);
			int y = find(subsets, nextEdge.dest);

			if (x == y) {
				// falls under same set, hence cycle. so ignore this
				continue;
			} else {
				// pick this edge safely.
				result[totalEdgesPicked++] = nextEdge;
				Union(subsets, x, y);
			}
		}

		// print the MST.
		for (i = 0; i < totalEdgesPicked; i++) {
			System.out.println(result[i].src + " -> " + result[i].dest + " : " + result[i].weight);
		}
	}

	public void addEdge(int i, int j, int k) {
		Edge edge = new Edge(i, j, k);
		this.edges[edgeCount++] = edge;
	}

	class Edge implements Comparable<Edge> {
		int src;
		int dest;
		int weight;

		public Edge() {
			
		}
		public Edge(int src, int dest, int weight) {
			super();
			this.src = src;
			this.dest = dest;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}

	}

	class Subset {
		int parent, rank;
	}

	int V;
	int E;
	Edge[] edges;
	int edgeCount;

	public Graph(int v, int e) {
		this.V = v;
		this.E = e;
		edges = new Edge[e];
		for (int i = 0; i < e; i++) {
			edges[i] = new Edge();
		}
		this.edgeCount = 0;
	}

	int find(Subset subsets[], int i) {
		if (subsets[i].parent == i) {
			return subsets[i].parent;
		}
		subsets[i].parent = find(subsets, subsets[i].parent);
		return subsets[i].parent;
	}

	void Union(Subset subsets[], int x, int y) {
		int xRoot = find(subsets, x);
		int yRoot = find(subsets, y);

		if (subsets[xRoot].rank < subsets[yRoot].rank) {
			subsets[xRoot].parent = yRoot;
		} else if (subsets[xRoot].rank > subsets[yRoot].rank) {
			subsets[yRoot].parent = xRoot;
		} else {
			subsets[yRoot].parent = xRoot;
			subsets[xRoot].rank++;
		}
	}
}