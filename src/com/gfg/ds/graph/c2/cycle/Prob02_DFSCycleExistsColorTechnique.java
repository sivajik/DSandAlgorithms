package com.gfg.ds.graph.c2.cycle;

import java.util.LinkedList;

public class Prob02_DFSCycleExistsColorTechnique {

	public static void main(String[] args) {
		Graph graph = new Graph(4, "dir");
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);

		if (graph.isCyclic())
			System.out.println("Graph contains cycle");
		else
			System.out.println("Graph doesn't " + "contain cycle");

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

		static int white = 0;
		static int gray = 1;
		static int black = 2;

		public boolean isCyclic() {
			int[] colors = new int[vertexCount];
			for (int i = 0; i < vertexCount; i++) {
				colors[i] = white;
			}

			for (int i = 0; i < vertexCount; i++) {
				if (colors[i] == white) {
					boolean cycleExists = cyclicUtil(i, colors);
					if (cycleExists) {
						return true;
					}
				}
			}
			return false;
		}

		private boolean cyclicUtil(int i, int[] colors) {
			colors[i] = gray;

			for (int eachAdjVer : adj[i]) {
				if (colors[eachAdjVer] == gray) {
					System.out.println("cycle: " + i + " -> " + eachAdjVer);
					return true;
				}

				if (colors[eachAdjVer] == white && cyclicUtil(eachAdjVer, colors)) {
					return true;
				}
			}
			colors[i] = black;
			return false;
		}

		public void addEdge(int v, int w) {
			if ("dir".equalsIgnoreCase(dirOrUndi)) {
				adj[v].add(w);
			}
		}

	}
}
