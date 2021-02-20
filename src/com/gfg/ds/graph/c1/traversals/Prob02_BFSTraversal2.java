package com.gfg.ds.graph.c1.traversals;

import java.util.LinkedList;
import java.util.Queue;

public class Prob02_BFSTraversal2 {

	public static void main(String[] args) {
		Graph g = new Graph(8, "dir");
		g.addEdge(0, 1);
		g.addEdge(1, 3);
		g.addEdge(1, 4);
		g.addEdge(1, 5);
		g.addEdge(0, 2);
		g.addEdge(2, 6);
		g.addEdge(6, 7);
		g.addEdge(7, 0);
		g.bfs(0);

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

		void bfs(int start) {
			boolean[] visited = new boolean[vertexCount];

			Queue<Integer> q = new LinkedList<>();
			q.add(start);
			visited[start] = true;
			q.add(null);
			int cnt = 0;
			while (!q.isEmpty()) {
				Integer ver = q.poll();
				if (ver != null) {
					System.out.println("Visiting: " + ver);
					for (int eachAdj : adj[ver]) {
						if (visited[eachAdj] == false) {
							q.add(eachAdj);
						}
					}
				} else {
					if (!q.isEmpty()) {
						q.add(null);
						System.out.println("---- level " + (cnt++)  + " ----");
					}
				}
			}
		}

	}
}