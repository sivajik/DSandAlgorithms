package com.gfg.ds.trie;

public class TrieDS {

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("apple");
		System.out.println(trie.search("apple") == true); // returns true
		System.out.println(trie.search("app") == false); // returns false
		System.out.println(trie.startsWith("app") == true); // returns true
		trie.insert("app");
		System.out.println(trie.search("app") == true); // returns true
	}

}

class TrieNode {
	TrieNode[] children;
	boolean isLeaf;

	TrieNode() {
		this.children = new TrieNode[26];
	}
}

class Trie {
	TrieNode root;

	Trie() {
		this.root = new TrieNode();
	}

	public void insert(String s) {
		TrieNode temp = root;
		for (char c : s.toCharArray()) {
			int index = c - 'a';
			if (temp.children[index] == null) {
				TrieNode x = new TrieNode();
				temp.children[index] = x;
				temp = x;
			} else {
				temp = temp.children[index];
			}
		}
		temp.isLeaf = true;
	}

	public boolean startsWith(String string) {
		TrieNode node = findfor(string);
		if (node == null) {
			return false;
		} else {
			return true;
		}

	}

	public boolean search(String string) {
		TrieNode node = findfor(string);
		if (node == null) {
			return false;
		} else {
			if (node.isLeaf) {
				return true;
			} else {
				return false;
			}
		}
	}

	private TrieNode findfor(String s) {
		TrieNode temp = root;
		for (char c : s.toCharArray()) {
			int index = c - 'a';
			if (temp.children[index] != null) {
				temp = temp.children[index];
			} else {
				return null;
			}
		}
		return temp == root ? null : temp;
	}
}