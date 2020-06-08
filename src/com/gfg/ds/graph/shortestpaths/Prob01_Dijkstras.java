package com.gfg.ds.graph.shortestpaths;

public class Prob01_Dijkstras {

	public static void main(String[] args) {
		Prob01_Dijkstras t = new Prob01_Dijkstras();
		int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
				{ 0, 8, 0, 7, 0, 4, 0, 0, 2 }, { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
				{ 0, 0, 4, 14, 10, 0, 2, 0, 0 }, { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
				{ 0, 0, 2, 0, 0, 0, 6, 7, 0 } };

		t.dijkstra(graph, 0);
		t.dijkstraNew(graph, 0);

	}

	private void dijkstraNew(int[][] graph, int src) {
		System.out.println("======");
		int[] dist = new int[V];
		Boolean[] mstSet = new Boolean[V];
		
		for (int i = 0; i < V; i++) {
			dist[i] = Integer.MAX_VALUE;
			mstSet[i] = false;
		}
		
		dist[src] = 0;
		
		for (int i = 0; i < V-1; i++) {
			int u = minKey(dist, mstSet);
			
			mstSet[u] = true;
			
			for (int v = 0; v < V; v++) {
				if (mstSet[v] == false && // not part of MST yet
						graph[u][v] != 0 && // edge exists??
						dist[u] != Integer.MAX_VALUE && // dont pick a infinity edge
						dist[u] + graph[u][v] < dist[v] // after adding it should be less than infi
						) {
					dist[v] = dist[u] + graph[u][v];
				}
			}
		}
		printMST(dist);
	}

	private static final int V = 9;

	int minKey(int dist[], Boolean mstSet[]) {
		int min = Integer.MAX_VALUE, min_index = -1;

		for (int v = 0; v < V; v++)
			if (mstSet[v] == false && dist[v] <= min) {
				min = dist[v];
				min_index = v;
			}

		return min_index;
	}

	void printMST(int dist[]) {
		System.out.println("Edge \tWeight");
		for (int i = 1; i < V; i++)
			System.out.println(i + " - " + i + "\t" + dist[i]);
	}

	void dijkstra(int graph[][], int src) {
		int dist[] = new int[V];

		Boolean mstSet[] = new Boolean[V];

		for (int i = 0; i < V; i++) {
			dist[i] = Integer.MAX_VALUE;
			mstSet[i] = false;
		}

		dist[src] = 0; // Make key 0 so that this vertex is

		for (int count = 0; count < V - 1; count++) {
			int u = minKey(dist, mstSet);

			mstSet[u] = true;

			for (int v = 0; v < V; v++) {
				if (!mstSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
					dist[v] = dist[u] + graph[u][v];
				}
			}
		}

		printMST(dist);
	}
}
