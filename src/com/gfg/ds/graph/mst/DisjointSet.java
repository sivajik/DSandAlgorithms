package com.gfg.ds.graph.mst;

public class DisjointSet {

	public static void main(String[] args) {
		DisjSet dus = new DisjSet(5);

		// 0 is a friend of 2
		dus.union(0, 2);

		// 4 is a friend of 2
		dus.union(4, 2);

		// 3 is a friend of 1
		dus.union(3, 1);
		
		// Check if 4 is a friend of 0 
        if (dus.find(4) == dus.find(0)) 
            System.out.println("Yes"); 
        else
            System.out.println("No"); 
  
        // Check if 1 is a friend of 0 
        if (dus.find(1) == dus.find(0)) 
            System.out.println("Yes"); 
        else
            System.out.println("No"); 
	}

}

class DisjSet {
	int n;
	int[] parent;
	int[] rank;

	public DisjSet(int n) {
		this.n = n;
		this.parent = new int[n];
		this.rank = new int[n];
		makeSet();
	}

	private void makeSet() {
		for (int i = 0; i < n; i++) {
			parent[i] = i;
			rank[i] = 0;
		}
	}

	public int find(int elem) {
		if (parent[elem] == elem) {
			return elem;
		}
		parent[elem] = find(parent[elem]);
		return parent[elem];
	}

	public void union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);

		if (rootX == rootY) {
			// do nothing as they are already in same set.
		} else {
			if (rank[rootX] < rank[rootY]) {
				parent[rootX] = rootY;
			} else if (rank[rootX] > rank[rootY]) {
				parent[rootY] = rootX;
			} else {
				parent[rootY] = rootX;
				rank[rootX] = rank[rootX] + 1;
			}
		}
	}
}