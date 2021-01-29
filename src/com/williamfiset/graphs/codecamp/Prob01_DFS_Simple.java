package com.williamfiset.graphs.codecamp;

import java.util.ArrayList;
import java.util.List;

public class Prob01_DFS_Simple {

	public static void main(String[] args) {
		Prob01_DFS_Simple p = new Prob01_DFS_Simple();
		p.createGraph(13);
		p.addEdge(0, 1);
		p.addEdge(0, 9);
		p.addEdge(1, 8);
		p.addEdge(1, 9);

		p.addEdge(8, 7);
		p.addEdge(7, 10);
		p.addEdge(7, 11);
		p.addEdge(10, 11);
		p.addEdge(7, 3);
		p.addEdge(7, 6);
		p.addEdge(3, 5);
		p.addEdge(5, 6);
		p.addEdge(3, 2);
		p.addEdge(3, 4);

		p.DFSIterator(0);

	}

	List<List<Integer>> adjList = new ArrayList<>();
	int n;

	public void createGraph(int n) {
		this.n = n;
		this.adjList = new ArrayList<List<Integer>>();
		for (int i = 0; i < n; i++) {
			adjList.add(i, new ArrayList<>());
		}
	}

	public void addEdge(int u, int v) {
		this.adjList.get(u).add(v);
		this.adjList.get(v).add(u);
	}

	void DFSIterator(int at) {
		boolean[] visited = new boolean[n];
		dfs(at, visited);
	}

	private void dfs(int at, boolean[] visited) {
		visited[at] = true;
		System.out.print(at + " -> ");
		for (int adjVert : adjList.get(at)) {
			if (visited[adjVert] == false) {
				dfs(adjVert, visited);
			}
		}
	}

}
