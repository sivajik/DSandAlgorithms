package com.gfg.ds.graph.connectivity;

import java.util.LinkedList;
import java.util.Queue;

public class Prob36_ConnectivityInKosarajuBFS {

	public static void main(String[] args) {
		Graph g1 = new Graph(5, "dir");
		g1.addEdge(0, 1);
		g1.addEdge(1, 2);
		g1.addEdge(2, 3);
		g1.addEdge(3, 0);
		g1.addEdge(2, 4);
		g1.addEdge(4, 2);

		System.out.println(g1.isStringlyConnected());
		System.out.println();

		Graph g2 = new Graph(4, "dir");
		g2.addEdge(0, 1);
		g2.addEdge(1, 2);
		g2.addEdge(2, 3);
		System.out.println(g2.isStringlyConnected());
	}

	static class Vertex {
		int id;

		Vertex(int label) {
			this.id = label;
		}
	}

	static class Graph {
		private String dirOrUndi;
		private int vertexCount = 0;
		LinkedList<Integer>[] adj;
		private Vertex[] vertexList;

		public Graph(int totalCount, String dirOrUndi) {
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

		}

		public void addEdge(int v, int w) {
			if ("dir".equalsIgnoreCase(dirOrUndi)) {
				adj[v].add(w);
			}
		}

		public boolean isStringlyConnected() {
			this.printBFS();
			boolean[] visited = new boolean[vertexCount];
			this.performBFS(0, visited);

			for (boolean val : visited) {
				if (!val) {
					return false;
				}
			}

			// transpose
			Graph newGraph = transpose(this);
			newGraph.printBFS();

			// recheck DFS
			visited = new boolean[vertexCount];
			newGraph.performBFS(0, visited);
			for (boolean val : visited) {
				if (!val) {
					return false;
				}
			}
			return true;
		}

		private void printBFS() {
			System.out.println("----- BFS -----");
			Queue<Integer> q = new LinkedList<>();
			q.add(0);
			boolean[] visited = new boolean[vertexCount];

			while (!q.isEmpty()) {
				Integer i = q.poll();
				visited[i] = true;
				System.out.print(i + " -> ");
				for (int adjVert : this.adj[i]) {
					if (visited[adjVert] == false) {
						q.add(adjVert);
					}
				}
			}
			System.out.println();
			System.out.println("----- *** -----");

		}

		private void performBFS(int u, boolean[] visited) {
			Queue<Integer> q = new LinkedList<>();
			visited[u] = true;
			q.add(u);

			while (!q.isEmpty()) {
				Integer i = q.poll();
				for (int eachAdjOfI : this.adj[i]) {
					if (visited[eachAdjOfI] == false) {
						q.add(eachAdjOfI);
						visited[eachAdjOfI] = true;
					}
				}
			}
		}

		private Graph transpose(Graph givenGraph) {
			Graph g = new Graph(givenGraph.vertexCount, "dir");
			g.adj = new LinkedList[givenGraph.vertexCount];
			for (int i = 0; i < givenGraph.vertexCount; ++i) {
				g.adj[i] = new LinkedList<>();
			}
			for (int i = 0; i < givenGraph.vertexCount; i++) {
				for (int eachAdjVer : givenGraph.adj[i]) {
					g.addEdge(eachAdjVer, i);
				}
			}

			return g;
		}
	}

}
