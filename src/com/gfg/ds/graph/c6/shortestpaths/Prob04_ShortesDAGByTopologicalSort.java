package com.gfg.ds.graph.c6.shortestpaths;

import java.util.LinkedList;
import java.util.Stack;

public class Prob04_ShortesDAGByTopologicalSort {
	public static void main(String args[]) {
		// Graph t = new Graph();
		Graph g = new Graph(6);// .newGraph(6);
		g.addEdge(0, 1, 5);
		g.addEdge(0, 2, 3);
		g.addEdge(1, 3, 6);
		g.addEdge(1, 2, 2);
		g.addEdge(2, 4, 4);
		g.addEdge(2, 5, 2);
		g.addEdge(2, 3, 7);
		g.addEdge(3, 4, -1);
		g.addEdge(4, 5, -2);

		int s = 1;
		System.out.println("Following are shortest distances " + "from source " + s);
		g.shortestPath(s);
	}

	static final int INF = Integer.MAX_VALUE;

	static class AdjListNode {
		private int v;
		private int weight;

		AdjListNode(int _v, int _w) {
			v = _v;
			weight = _w;
		}

		int getV() {
			return v;
		}

		int getWeight() {
			return weight;
		}
	}

	static class Graph {
		private int V;
		private LinkedList<AdjListNode> adj[];

		Graph newGraph(int number) {
			return new Graph(number);
		}

		Graph(int v) {
			V = v;
			adj = new LinkedList[V];
			for (int i = 0; i < v; ++i)
				adj[i] = new LinkedList<AdjListNode>();
		}

		void addEdge(int u, int v, int weight) {
			AdjListNode node = new AdjListNode(v, weight);
			adj[u].add(node);
		}

		void shortestPath(int s) {
			Stack<Integer> stack = new Stack<>();
			int[] dist = new int[V];
			Boolean[] visited = new Boolean[V];

			for (int i = 0; i < V; i++) {
				visited[i] = false;
			}
			
			for (int i = 0; i < V; i++) {
				topologicalSortUtil(i, visited, stack);
				dist[i] = INF;
			}

			dist[s] = 0;

			while (!stack.isEmpty()) {
				int u = stack.pop();

				if (dist[u] != INF) {
					for (AdjListNode eachAdjNode : adj[u]) {
						if (dist[u] + eachAdjNode.getWeight() < dist[eachAdjNode.getV()]) {
							dist[eachAdjNode.getV()] = dist[u] + eachAdjNode.getWeight();
						}
					}
				}
			}

			for (int i = 0; i < V; i++) {
				if (dist[i] == INF)
					System.out.print("INF ");
				else
					System.out.print(dist[i] + " ");
			}
		}

		void topologicalSortUtil(int v, Boolean visited[], Stack<Integer> stack) {
			visited[v] = true;
			for (AdjListNode eachAdjVert : adj[v]) {
				if (visited[eachAdjVert.getV()] == false) {
					topologicalSortUtil(eachAdjVert.getV(), visited, stack);
				}
			}
			stack.push(v);

		}
	}
}
