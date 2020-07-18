package com.williamfiset.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CentreOfTree {

	public static void main(String[] args) {
		System.out.println(findCenters(4, new int[][] { { 1, 0 }, { 1, 2 }, { 1, 3 } }));
		System.out.println(findCenters(6, new int[][] { { 0, 3 }, { 1, 3 }, { 2, 3 }, { 4, 3 }, { 5, 4 } }));
		System.out.println(findCenters(6, new int[][] {  {0,1},{0,2},{0,3},{3,4},{4,5} }));
	}

	static public List<Integer> findCenters(int n, int[][] edges) {
		List<List<Integer>> adjList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adjList.add(new ArrayList<>());
		}

		for (int[] eachEdge : edges) {
			adjList.get(eachEdge[0]).add(eachEdge[1]);
			adjList.get(eachEdge[1]).add(eachEdge[0]);
		}

		int[] degrees = new int[n];
		int c = 0;
		List<Integer> leavesList = new ArrayList<>();

		for (int nodeNumber = 0; nodeNumber < n; nodeNumber++) {
			List<Integer> eachNodesAdj = adjList.get(nodeNumber);

			if (eachNodesAdj.size() == 1 || eachNodesAdj.size() == 0) {
				degrees[c++] = 0;
				leavesList.add(nodeNumber);
			} else {
				degrees[c++] = eachNodesAdj.size();
			}
		}

		int leavesCount = leavesList.size();
		while (leavesCount < n) {
			// List<Integer> newLeafs = new ArrayList<>();
			Set<Integer> newLeafs = new HashSet<>();
			for (int eachLeaf : leavesList) {
				for (int adjNodeOfLeaf : adjList.get(eachLeaf)) {
					degrees[adjNodeOfLeaf]--;
					if (degrees[adjNodeOfLeaf] == 1) {
						newLeafs.add(adjNodeOfLeaf);
					}
				}
				degrees[eachLeaf] = 0;
			}
			leavesCount += newLeafs.size();
			leavesList = new ArrayList(newLeafs);
		}
		return leavesList;
	}
}
