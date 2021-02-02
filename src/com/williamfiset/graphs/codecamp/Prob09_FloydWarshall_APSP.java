package com.williamfiset.graphs.codecamp;

import java.util.Arrays;

/*
 * not good unless you got just few hundred of vertices as complexity os O(V3) with space 
 * complexity of O(V2), hence not so widely used due to v cube comp. however this is app pair
 * shortest path and also deals negative cycles too.
 * 
 * moreover it works best for adjMatrices only.
 */
public class Prob09_FloydWarshall_APSP {

	public static void main(String[] args) {
		Prob09_FloydWarshall_APSP p = new Prob09_FloydWarshall_APSP();
		p.createGraph(5);

		p.addEdge(0, 1, 4);
		p.addEdge(0, 2, 1);
		p.addEdge(2, 1, 2);
		p.addEdge(1, 3, 1);
		p.addEdge(2, 3, 5);
		p.addEdge(3, 4, 3);

		p.floydWarshall();

	}

	private void floydWarshall() {
		int[][] dist = new int[n][n];

		// initialise the array. could have been done in createGrpah
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				dist[i][j] = adjList[i][j];
			}
		}
		// i->k plus k -> j is less than direct path of i->j then use it
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (dist[i][k] + dist[k][j] < dist[i][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
		}
		printSolution(dist);
	}

	private static final int INF = 99999;

	void printSolution(int dist[][]) {
		System.out.println("The following matrix shows the shortest " + "distances between every pair of vertices");
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				if (dist[i][j] == INF)
					System.out.print("INF ");
				else
					System.out.print(dist[i][j] + "   ");
			}
			System.out.println();
		}
	}

	// Map<Integer, List<Edge>> adjList = new HashMap<>();
	int n;
	int[][] adjList;

	public void createGraph(int n) {
		this.n = n;
		this.adjList = new int[n][];
		for (int i = 0; i < n; i++) {
			adjList[i] = new int[n];
			Arrays.fill(adjList[i], INF);
			adjList[i][i] = 0;
		}
	}

	public void addEdge(int u, int v, int w) {
		adjList[u][v] = w;
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
}
