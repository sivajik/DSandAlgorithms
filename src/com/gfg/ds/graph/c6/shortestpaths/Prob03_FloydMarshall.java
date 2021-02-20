package com.gfg.ds.graph.c6.shortestpaths;

public class Prob03_FloydMarshall {
	private static final int INF = 99999;

	public static void main(String[] args) {
		int graph[][] = { { 0, 5, INF, 10 }, { INF, 0, 3, INF }, { INF, INF, 0, 1 }, { INF, INF, INF, 0 } };
		Prob03_FloydMarshall a = new Prob03_FloydMarshall();

		// Print the solution
		a.floydWarshall(graph);
	}

	final static int V = 4;

	void floydWarshall(int graph[][]) {
		int[][] dist = new int[V][V];
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				dist[i][j] = graph[i][j];
			}
		}
		for (int k = 0; k < V; k++) {
			for (int i = 0; i < V; i++) {
				for (int j = 0; j < V; j++) {
					if (dist[i][k] + dist[k][j] < dist[i][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
		}
		printSolution(dist);
	}

	void printSolution(int dist[][]) {
		System.out.println("The following matrix shows the shortest " + "distances between every pair of vertices");
		for (int i = 0; i < V; ++i) {
			for (int j = 0; j < V; ++j) {
				if (dist[i][j] == INF)
					System.out.print("INF ");
				else
					System.out.print(dist[i][j] + "   ");
			}
			System.out.println();
		}
	}
}
