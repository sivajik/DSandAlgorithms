package com.gfg.ds.graph.cycle;

import java.util.LinkedList;

public class Prob01_DFSCycleExists {

	public static void main(String[] args) {
		Graph graph = new Graph(4, "dir");
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		// graph.addEdge(2, 0);
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

		public boolean isCyclic() {
			boolean[] visited = new boolean[vertexCount];

			for (int i = 0; i < vertexCount; i++) {
				if (visited[i] == false) {
					boolean cycleFormedSofar = cycleExistsFrom(i, visited);
					if (cycleFormedSofar) {
						return true;
					}
				}
			}
			return false;
		}

		private boolean cycleExistsFrom(int i, boolean[] visited) {
			visited[i] = true;
			for (int eachAdjVer : adj[i]) {
				if (i != eachAdjVer) {
					if (visited[eachAdjVer] == false) {
						return cycleExistsFrom(eachAdjVer, visited);
					} else {
						System.out.println("Cycle Exists here... " + i + " - " + eachAdjVer);
						return true;
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
