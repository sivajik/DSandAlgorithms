package com.gfg.ds.graph.connectivity;

import java.util.LinkedList;
import java.util.Queue;

public class Prob01_PathExistsBetween2Vertices {

	public static void main(String[] args) {
		Graph g = new Graph(8, "dir");
		g.addEdge(0, 1);
		g.addEdge(1, 3);
		g.addEdge(3, 4);
		g.addEdge(1, 5);
		g.addEdge(0, 2);
		g.addEdge(2, 6);
		g.addEdge(6, 7);
		g.addEdge(7, 0);

		System.out.println(g.pathExists(1, 4));
		System.out.println(g.pathExists(1, 9));
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

		public boolean pathExists(int i, int j) {
			boolean visited[] = new boolean[vertexCount];

			visited[i] = true;
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(i);

			while (!q.isEmpty()) {
				Integer temp = q.poll();

				for (int eachAdjVerr : adj[temp]) {
					if (eachAdjVerr == j) {
						System.out.println("Found....");
						return true;
					}
					if (visited[eachAdjVerr] == false) {
						q.add(eachAdjVerr);
						visited[eachAdjVerr] = true;
					}
				}
			}
			return false;
		}

		public void addEdge(int v, int w) {
			if ("dir".equalsIgnoreCase(dirOrUndi)) {
				adj[v].add(w);
			}
		}

	}

}
