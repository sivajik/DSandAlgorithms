package com.gfg.ds.graph.c1.traversals;

import java.util.LinkedList;

public class Prob23_PrintAllPathsFromAtoB {

	public static void main(String[] args) {
		Graph g = new Graph(4, "dir");
		g.addEdge(0, 3);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 0);
		g.addEdge(2, 1);

		int s = 2, d = 3;
		g.printAllPaths(s, d);
	}

	static class Vertex {
		int id;
		boolean visited;

		Vertex(int label) {
			this.id = label;
			this.visited = false;
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
			} else {
				// this.adjMatrix[start][end] = 1;
				// this.adjMatrix[end][start] = 1;
			}
		}

		void printPath(int source, int dest, String path, boolean[] visited) {
			String newPath = path + "->" + source;
			visited[source] = true;

			LinkedList<Integer> list = adj[source];
			for (int i = 0; i < list.size(); i++) {
				Integer adjVert = list.get(i);

				if (adjVert != dest && visited[adjVert] == false) {
					printPath(adjVert, dest, newPath, visited);
				} else if (adjVert == dest) {
					System.out.println(newPath + "->" + dest);
				}
			}
			// remove from path
			visited[source] = false;
		}

		void printAllPaths(int s, int d) {
			boolean[] visited = new boolean[vertexCount];

			printPath(s, d, "", visited);
		}
	}
}
