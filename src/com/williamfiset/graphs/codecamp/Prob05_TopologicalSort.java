package com.williamfiset.graphs.codecamp;

import java.util.ArrayList;
import java.util.List;

public class Prob05_TopologicalSort {

	public static void main(String[] args) {
		Prob05_TopologicalSort p = new Prob05_TopologicalSort();
		p.createGraph(13);

		p.addEdge('A', 'D');

		p.addEdge('B', 'D');

		p.addEdge('C', 'A');
		p.addEdge('C', 'B');

		p.addEdge('D', 'G');
		p.addEdge('D', 'H');

		p.addEdge('E', 'A');
		p.addEdge('E', 'D');
		p.addEdge('E', 'F');

		p.addEdge('F', 'K');
		p.addEdge('F', 'J');

		p.addEdge('G', 'I');

		p.addEdge('H', 'J');
		p.addEdge('H', 'I');

		p.addEdge('I', 'L');

		p.addEdge('J', 'M');
		p.addEdge('J', 'L');

		p.addEdge('K', 'J');

		p.topologicalSort();

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

	public void addEdge(char u, char v) {
		this.adjList.get(u - 'A').add(v - 'A');
	}

	void topologicalSort() {
		boolean[] visited = new boolean[n];
		List<Character> l = new ArrayList<Character>();
		for (int at = 0; at < n; at++) {
			if (visited[at] == false) {
				dfs(at, visited, l);
			}
		}
		System.out.println(l);
	}

	private void dfs(int at, boolean[] visited, List<Character> l) {
		visited[at] = true;
		for (int adjVert : adjList.get(at)) {
			if (visited[adjVert] == false) {
				dfs(adjVert, visited, l);
			}
		}
		l.add(0, (char) (at + 'A'));
	}

}
