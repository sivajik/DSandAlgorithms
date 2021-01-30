package com.williamfiset.graphs.codecamp;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Prob03_BFS_Simple {

	public static void main(String[] args) {
		Prob03_BFS_Simple p = new Prob03_BFS_Simple();
		int totalVertices = 13;
		p.createGraph(totalVertices);

		p.addEdge(10, 1);
		p.addEdge(1, 8);
		p.addEdge(8, 9);
		p.addEdge(10, 9);

		p.addEdge(8, 12);
		p.addEdge(12, 2);
		p.addEdge(2, 3);
		p.addEdge(3, 4);
		p.addEdge(3, 7);
		p.addEdge(7, 0);
		p.addEdge(0, 9);
		p.addEdge(0, 11);
		p.addEdge(7, 11);
		p.addEdge(7, 6);
		p.addEdge(6, 5);

		for (int i = 0; i < totalVertices; i++) {
			p.bfs(0, i);
		}

	}

	void bfs(int u, int v) {
		boolean[] visited = new boolean[n];
		int[] prev = new int[n];
		Arrays.fill(prev, -1);

		Queue<Integer> q = new ArrayDeque<>();
		q.add(u);
		visited[u] = true;

		while (!q.isEmpty()) {
			int currVert = q.poll();

			for (int adjVert : adjList.get(currVert)) {
				if (visited[adjVert] == false) {
					q.add(adjVert);
					visited[adjVert] = true;
					prev[adjVert] = currVert;
				}
			}
		}
		System.out.println("Path from : " + u + " -> " + v);
		if (prev[v] == u) {
			System.out.println("Immediate edges.");
		} else {
			while (prev[v] != u && prev[v] != -1) {
				System.out.print(prev[v] + " -> ");
				v = prev[v];
			}
		}
		System.out.println();
		System.out.println("==============================");
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
}
