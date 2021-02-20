package com.gfg.ds.graph.c3.topological;

import java.util.LinkedList;
import java.util.List;

public class Prob03_DFSTraversal2 {

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
		g.dfs(0);

		boolean cycleExists = g.doesCycleExists();

		if (cycleExists) {
			System.out.println("no way jose!!! Cycle existts so no cant do topological sort");
		} else {
			System.out.println("Topology Sort");
			g.topologicalSort();
		}
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

		void dfs(int start) {
			boolean visited[] = new boolean[vertexCount];
			dfsUtil(start, visited);
		}

		private void dfsUtil(int start, boolean[] visited) {
			visited[start] = true;
			System.out.println("Visiting: " + start);
			for (Integer adjVert : adj[start]) {
				if (visited[adjVert] == false) {
					dfsUtil(adjVert, visited);
				}
			}
		}

		void topologicalSort() {
			boolean[] visited = new boolean[vertexCount];
			LinkedList<Integer> result = new LinkedList<>();

			for (int i = 0; i < vertexCount; i++) {
				if (visited[i] == false) { //Imp: Must do this.
					topologyUtil(i, visited, result);
				}
			}
			for (Integer i : result) {
				System.out.print(i + " -> ");
			}
		}

		private void topologyUtil(int start, boolean[] visited, LinkedList<Integer> result) {
			visited[start] = true;
			for (int adjVert : adj[start]) {
				if (visited[adjVert] == false) {
					topologyUtil(adjVert, visited, result);
				}
			}
			// Adding at first is key here...
			result.addFirst(start);
		}

		private boolean doesCycleExists() {
			int[] parents = new int[vertexCount];
			int[] ranks = new int[vertexCount];

			for (int i = 0; i < parents.length; i++) {
				parents[i] = i;
				ranks[i] = 0;
			}

			for (int i = 0; i < adj.length; i++) {
				List<Integer> l = adj[i];
				for (int j : l) {
					System.out.println("Processing Edge: " + i + " -> " + j);

					int iRep = find(parents, i);
					int jRep = find(parents, j);

					if (iRep == jRep) {
						System.out.println("cycle there for : " + i + "," + j + " [" + iRep + " - " + jRep + "]");
						return true;
					} else {
						union(iRep, jRep, parents, ranks);
					}
				}
			}
			return false;
		}

		private void union(int x, int y, int[] parents, int[] ranks) {
			int xRoot = find(parents, x);
			int yRoot = find(parents, y);

			if (ranks[xRoot] > ranks[yRoot]) {
				parents[yRoot] = xRoot;
			} else if (ranks[xRoot] < ranks[yRoot]) {
				parents[xRoot] = yRoot;
			} else {
				parents[xRoot] = yRoot;
				ranks[yRoot]++;
			}
		}

		private int find(int[] parents, int i) {
			if (parents[i] == i) {
				return i;
			} else {
				parents[i] = find(parents, parents[i]);
				return parents[i];
			}
		}
	}
}