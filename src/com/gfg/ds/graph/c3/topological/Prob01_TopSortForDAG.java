package com.gfg.ds.graph.c3.topological;

import java.util.ArrayList;
import java.util.List;

/*
Time Complexity: O(V+E). 
The above algorithm is simply DFS with an extra stack. So time complexity is the same as DFS which is.

Auxiliary space: O(V). 
The extra space is needed for the stack.

Topological Sorting for a graph is "NOT POSSIBLE IF GRAPH IS NOT A DAG"

Note that a vertex is pushed to stack only when all of its adjacent vertices 
(and their adjacent vertices and so on) are already in the stack. Means the mother vertex is the one that comes last. 
 */
public class Prob01_TopSortForDAG {

	public static void main(String[] args) {
		// Create a graph given in the above diagram
		Graph g = new Graph(6);
		g.addEdge(5, 2);
		g.addEdge(5, 0);
		g.addEdge(4, 0);
		g.addEdge(4, 1);
		g.addEdge(2, 3);
		g.addEdge(3, 1);

		System.out.println("Following is a Topological " + "sort of the given graph");
		// Function Call
		g.topologicalSort();
	}

	static class Graph {
		private int V;

		private ArrayList<ArrayList<Integer>> adj;

		// Constructor
		Graph(int v) {
			V = v;
			adj = new ArrayList<ArrayList<Integer>>(v);
			for (int i = 0; i < v; ++i)
				adj.add(new ArrayList<Integer>());
		}

		// Function to add an edge into the graph
		void addEdge(int v, int w) {
			adj.get(v).add(w);
		}

		public void topologicalSort() {
			boolean[] visited = new boolean[V];
			List<Integer> l = new ArrayList<>();

			for (int i = 0; i < V; i++) {
				if (visited[i] == false) {
					dfs(i, l, visited);
				}
			}
			System.out.println(l);
		}

		private void dfs(int at, List<Integer> l, boolean[] visited) {
			visited[at] = true;
			for (Integer eachadj : adj.get(at)) {
				if (visited[eachadj] == false) {
					dfs(eachadj, l, visited);
				}
			}
			l.add(0, at);

		}
	}
}
