package com.gfg.ds.graph.topological;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Prob03_TopologicalSortKhans {

	public static void main(String[] args) {
		Graph g = new Graph(6, "dir");
		g.addEdge(5, 2);
		g.addEdge(5, 0);
		g.addEdge(4, 0);
		g.addEdge(4, 1);
		g.addEdge(2, 3);
		g.addEdge(3, 1);
		System.out.println("Following is a Topological Sort");
		g.topologicalSort();

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
			int[] inbounds = new int[vertexCount];
			// create an array if inbounds.
			for (int i = 0; i < vertexCount; i++) {
				for (Integer adjVert : adj[i]) {
					inbounds[adjVert]++;
				}
			}
			System.out.println("Inbounds::");
			System.out.println(Arrays.toString(inbounds) + "\n");

			// queue all vertices whose inbound = 0
			Queue<Integer> q = new LinkedList<>();
			for (int i = 0; i < inbounds.length; i++) {
				if (inbounds[i] == 0) {
					q.add(i);
				}
			}
			System.out.println("Vertices with inbound 0: " + q.toString() + "\n");
			
			List<Integer> topolSort = new ArrayList<>();
			int processedVertices = 0;
			while (!q.isEmpty()) {
				Integer ver = q.poll();
				
				topolSort.add(ver);
				for (int eachAdjVer : adj[ver]) {
					inbounds[eachAdjVer]--;
					if (inbounds[eachAdjVer] == 0) {
						q.add(eachAdjVer);
					}
				}
				processedVertices++;
			}
			if (processedVertices != vertexCount) {
				System.out.println("No way jose!!! Topolgical Sort Impossible");
			} else {
				for (Integer i : topolSort) {
					System.out.print(i + " -> ");
				}
			}
		}
	}
}