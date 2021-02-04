package com.williamfiset.graphs.codecamp;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * SCCS =  Strongly Connected Components
 */
public class Prob12_Targan_SCCS {

	public static void main(String[] args) {
		int n = 8;
		List<List<Integer>> graph = createGraph(n);

		addEdge(graph, 6, 0);
		addEdge(graph, 6, 2);
		addEdge(graph, 3, 4);
		addEdge(graph, 6, 4);
		addEdge(graph, 2, 0);
		addEdge(graph, 0, 1);
		addEdge(graph, 4, 5);
		addEdge(graph, 5, 6);
		addEdge(graph, 3, 7);
		addEdge(graph, 7, 5);
		addEdge(graph, 1, 2);
		addEdge(graph, 7, 3);
		addEdge(graph, 5, 0);

		Prob12_Targan_SCCS solver = new Prob12_Targan_SCCS(graph, n);
		solver.getSccs();

	}

	int[] ids;
	int[] lows;
	int[] sccs;
	boolean[] visited;
	private Deque<Integer> stack;
	int id = 0;
	int sccCount = 0;

	private int[] getSccs() {
		ids = new int[n];
		lows = new int[n];
		sccs = new int[n];
		visited = new boolean[n];
		stack = new ArrayDeque<>();

		Arrays.fill(ids, -1);

		for (int i = 0; i < n; i++) {
			if (ids[i] == -1) {
				dfs(i);
			}
		}

		Map<Integer, List<Integer>> m = new HashMap<>();
		for (int i = 0; i < n; i++) {
			if (!m.containsKey(sccs[i])) {
				m.put(sccs[i], new ArrayList<>());
			}
			m.get(sccs[i]).add(i);
		}
		System.out.println(m.values());
		return null;
	}

	private void dfs(int at) {
		visited[at] = true;
		ids[at] = lows[at] = id++;
		stack.push(at);

		for (int to : this.graph.get(at)) {
			if (ids[to] == -1) {
				dfs(to);
			}
			// 0 -> 1 -> 2 -> 0, seen a visisted node called 0.
			if (visited[to] == true) {
				lows[at] = Math.min(lows[at], lows[to]);
			}
		}

		// On recursive callback, if we're at the root node (start of SCC)
		// empty the seen stack until back to root.
		// started at 0, came back from 2->1->0
		if (ids[at] == lows[at]) {
			for (int node = stack.pop();; node = stack.pop()) {
				visited[node] = false;
				sccs[node] = sccCount;
				if (node == at) {
					break;
				}
			}
			sccCount++;
		}
	}

	List<List<Integer>> graph;
	int n;

	public Prob12_Targan_SCCS(List<List<Integer>> graph2, int n2) {
		this.graph = graph2;
		this.n = n2;
	}

	private static void addEdge(List<List<Integer>> g, int i, int j) {
		g.get(i).add(j);
		// g.get(j).add(i);
	}

	private static List<List<Integer>> createGraph(int n) {
		List<List<Integer>> g = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			g.add(i, new ArrayList<>());
		}
		return g;
	}

}
