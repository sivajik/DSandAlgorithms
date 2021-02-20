package com.gfg.ds.graph.c3.topological;

import java.util.ArrayList;
import java.util.List;

/*
Topological Sorting for a graph is "NOT POSSIBLE IF GRAPH IS NOT A DAG"

Initialize all vertices as unvisited.
Now choose vertex which is unvisited and has zero indegree 
	and decrease indegree of all those vertices by 1 (corresponding to removing edges) 
	now add this vertex to result and call the recursive function again and backtrack.

After returning from function reset values of visited, result and indegree for enumeration of other possibilities.

 */
public class Prob02_PrintAllPossibleTopSortForDAG {

	public static void main(String[] args) {
		// Create a graph given in the above diagram
		Graph graph = new Graph(6);
		graph.addEdge(5, 2);
		graph.addEdge(5, 0);
		graph.addEdge(4, 0);
		graph.addEdge(4, 1);
		graph.addEdge(2, 3);
		graph.addEdge(3, 1);

		System.out.println("All Topological sorts");
		graph.allTopologicalSorts();
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

		public void allTopologicalSorts() {
			int[] indegrees = new int[V];
			for (int i = 0; i < V; i++) {
				for (int eachEdge : adj.get(i)) {
					indegrees[eachEdge]++;
				}
			}
			boolean[] visited = new boolean[V];
			List<Integer> l = new ArrayList<>();
			topSort(visited, indegrees, l);
		}

		private void topSort(boolean[] visited, int[] indegrees, List<Integer> l) {
			boolean done = false;
			for (int at = 0; at < V; at++) {
				// start at vertex where indegree is ZERO.
				if (visited[at] == false && indegrees[at] == 0) {
					visited[at] = true;
					l.add(at);
					for (int eachAdjVert : adj.get(at)) {
						indegrees[eachAdjVert]--;
					}

					// recursive call with updated indegrees.
					topSort(visited, indegrees, l);

					visited[at] = false;
					l.remove(l.size() - 1);
					for (int eachAdjVert : adj.get(at)) {
						indegrees[eachAdjVert]++;
					}
					done = true;
				}
			}
			if (!done) {
				System.out.println("List: " + l);
			}
		}
	}
}
