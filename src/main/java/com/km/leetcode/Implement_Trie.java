package com.km.leetcode;

public class Implement_Trie {
	class Node{
		char c;
		boolean isword;
		Node[] children;
		public Node(char c) {
			this.c=c;
			this.isword=false;
			this.children=new Node[26];
		}
	}
	Node root;
    public Implement_Trie() {
        root=new Node(' ');
    }

	public void insert(String word) {
		Node temp=root;
		for(char c:word.toCharArray()) {
			if(temp.children[c-'a']==null)
				temp.children[c-'a']=new Node(c);
			temp=temp.children[c-'a'];
		}
		temp.isword=true;
	}

	public boolean search(String word) {
		Node temp=root;
		for(char c:word.toCharArray()) {
			if(temp.children[c-'a']==null)
				return false;
			temp=temp.children[c-'a'];
		}
		return temp.isword;
	}
	
	public boolean startsWith(String prefix) {
		Node temp=root;
		for(char c:prefix.toCharArray()) {
			if(temp.children[c-'a']==null)
				return false;
			temp=temp.children[c-'a'];
		}
		return true;

	}
}
