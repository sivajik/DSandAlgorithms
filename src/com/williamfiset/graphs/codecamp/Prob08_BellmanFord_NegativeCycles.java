package com.williamfiset.graphs.codecamp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * better impl could be O(EV) which is worst than D's  O( (E+V) * log(v))
 * though this is less performant, it helps to deal with negative edge weights 
 * and negative cycles.
 * 
 * Logic is for EACH edge relax v-1 times.
 */
public class Prob08_BellmanFord_NegativeCycles {

	public static void main(String[] args) {
		Prob08_BellmanFord_NegativeCycles p = new Prob08_BellmanFord_NegativeCycles();
		p.createGraph(5);

		p.addEdge(0, 1, 4);
		p.addEdge(0, 2, 1);
		p.addEdge(2, 1, 2);
		p.addEdge(1, 3, 1);
		p.addEdge(2, 3, 5);
		p.addEdge(3, 4, 3);

		p.bellmanFord(0);

	}

	private void bellmanFord(int at) {
		int[] dist = new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);

		dist[at] = 0;

		for (int i = 0; i < n - 1; i++) {
			for (List<Edge> edges : adjList.values()) {
				for (Edge eachEdge : edges) {
					if (dist[eachEdge.u] + eachEdge.w < dist[eachEdge.v]) {
						dist[eachEdge.v] = dist[eachEdge.u] + eachEdge.w;
					}
				}
			}
		}

		for (int i = 0; i < n - 1; i++) {
			for (List<Edge> edges : adjList.values()) {
				for (Edge eachEdge : edges) {
					if (dist[eachEdge.u] + eachEdge.w < dist[eachEdge.v]) {
						dist[eachEdge.v] = Integer.MIN_VALUE;
					}
				}
			}
		}

		System.out.println(Arrays.toString(dist));
	}

	Map<Integer, List<Edge>> adjList = new HashMap<>();
	int n;

	public void createGraph(int n) {
		this.n = n;
		this.adjList = new HashMap<>();
		for (int i = 0; i < n; i++) {
			adjList.put(i, new ArrayList<>());
		}
	}

	public void addEdge(int u, int v, int w) {
		List<Edge> l = adjList.get(u);
		l.add(new Edge(u, v, w));
		this.adjList.put(u, l);
	}

	static class Edge {
		int u, v, w;

		Edge(int u, int v, int w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}

		public String toString() {
			return u + " -> " + v + " = " + w;
		}
	}
}
