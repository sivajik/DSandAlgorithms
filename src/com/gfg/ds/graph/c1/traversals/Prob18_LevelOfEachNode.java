package com.gfg.ds.graph.c1.traversals;

import java.util.LinkedList;
import java.util.Queue;

public class Prob18_LevelOfEachNode {

	public static void main(String[] args) {
		Graph g = new Graph(8, "dir");
		g.addEdge(0, 1);
		g.addEdge(1, 3);
		g.addEdge(1, 4);
		g.addEdge(1, 5);

		g.addEdge(0, 2);
		g.addEdge(2, 6);
		g.addEdge(6, 7);

		g.calcLevels();
	}

	static class Vertex {
		int id;
		boolean visited;
		int level;

		Vertex(int label) {
			this.id = label;
			this.visited = false;
			this.level = 0;
		}
	}

	static class Graph {
		private String dirOrUndi;
		private int vertexCount = 0;
		LinkedList<Integer> adj[];
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

		void calcLevels() {
			Queue<Vertex> q = new LinkedList<>();

			Vertex s = vertexList[0];
			s.visited = true;
			s.level = 0;
			q.add(s);

			while (!q.isEmpty()) {
				Vertex v = q.poll();

				for (Integer adjVer : adj[v.id]) {
					Vertex vv = vertexList[adjVer];
					if (vv.visited == false) {
						vv.visited = true;
						vv.level = 1 + v.level;
						q.add(vv);
					}
				}
			}

			for (Vertex vert : vertexList) {
				System.out.println(vert.id + " -> " + vert.level);
			}
		}

	}
}
