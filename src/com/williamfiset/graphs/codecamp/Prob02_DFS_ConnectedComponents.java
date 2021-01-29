package com.williamfiset.graphs.codecamp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prob02_DFS_ConnectedComponents {

	public static void main(String[] args) {
		Prob02_DFS_ConnectedComponents p = new Prob02_DFS_ConnectedComponents();
		p.createGraph(18);

		p.addEdge(6, 7);
		p.addEdge(6, 11);
		p.addEdge(7, 11);

		p.addEdge(12, 12);

		p.addEdge(1, 5);
		p.addEdge(17, 5);
		p.addEdge(5, 16);

		p.addEdge(3, 9);
		p.addEdge(9, 15);
		p.addEdge(9, 2);
		p.addEdge(2, 15);
		p.addEdge(15, 10);

		p.addEdge(8, 4);
		p.addEdge(8, 0);
		p.addEdge(0, 4);
		p.addEdge(8, 14);
		p.addEdge(0, 14);
		p.addEdge(13, 14);
		p.addEdge(0, 13);

		p.connectedComponents();

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

	void connectedComponents() {
		boolean[] visited = new boolean[n];
		int color = 1;

		Map<Integer, List<Integer>> map = new HashMap<>();

		for (int i = 0; i < n; i++) {
			if (visited[i] == false) {
				dfs(i, visited, color++, map);
			}
		}

		System.out.println(map);
	}

	private void dfs(int at, boolean[] visited, int color, Map<Integer, List<Integer>> map) {
		visited[at] = true;

		if (map.get(color) == null) {
			List<Integer> l = new ArrayList<>();
			l.add(at);
			map.put(color, l);
		} else {
			List<Integer> l = map.get(color);
			l.add(at);
			map.put(color, l);
		}

		for (int adjVert : adjList.get(at)) {
			if (visited[adjVert] == false) {
				dfs(adjVert, visited, color, map);
			}
		}
	}

}
