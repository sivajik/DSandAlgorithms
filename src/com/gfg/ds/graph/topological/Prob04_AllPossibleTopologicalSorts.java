package com.gfg.ds.graph.topological;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Prob04_AllPossibleTopologicalSorts {

	public static void main(String[] args) {
		Graph g = new Graph(6, "dir");
		g.addEdge(5, 2);
		g.addEdge(5, 0);
		g.addEdge(4, 0);
		g.addEdge(4, 1);
		g.addEdge(2, 3);
		g.addEdge(3, 1);
		System.out.println("Following is a Topological Sort");
		g.allTopologicalSorts();

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

		void allTopologicalSorts() {
			int[] inbounds = new int[vertexCount];
			boolean[] visited = new boolean[vertexCount];
			
			// create an array if inbounds.
			for (int i = 0; i < vertexCount; i++) {
				for (Integer adjVert : adj[i]) {
					inbounds[adjVert]++;
				}
			}
			System.out.println("Inbounds::");
			System.out.println(Arrays.toString(inbounds) + "\n");

			List<Integer> result = new ArrayList<Integer>();
			allTopologicalSortsUtil(visited, inbounds, result);
		}
		
		void allTopologicalSortsUtil(boolean[] visited, int[] inbounds, List<Integer> result) {
			boolean flag = false;
			
			for (int i = 0; i < vertexCount; i++) {
				if (visited[i] == false && inbounds[i] == 0) {
					visited[i] = true;
					
					// add to result.
					result.add(i);
					
					for (Integer adjVert : adj[i]) {
						inbounds[adjVert]--;
					}
					allTopologicalSortsUtil(visited, inbounds, result);
					
					
					visited[i] = false;
					result.remove(result.size() - 1);
					for (Integer adjVert : adj[i]) {
						inbounds[adjVert]++;
					}
					flag = true;
				}
			}
			
			if (!flag) {
				System.out.println(result.toString());
				System.out.println();
			}
		}
	}
}