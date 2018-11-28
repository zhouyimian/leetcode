package com.km.leetcode;

public class MapSum {
	class Node{
		int value;
		Node[] next;
		public Node() {this.next=new Node[26];this.value=0;};
		public Node(int value) {this.next=new Node[26];this.value=value;}
	}
	public Node root=null;
	public MapSum() {
		root=new Node();
	}

	public void insert(String key, int val) {
		Node temp=root;
		for(int i=0;i<key.length();i++) {
			if(temp.next[key.charAt(i)-'a']==null) {
				temp.next[key.charAt(i)-'a']=new Node();
			}
			temp=temp.next[key.charAt(i)-'a'];
		}
		temp.value+=val;
	}

	public int sum(String prefix) {
		Node temp=root;
		int ans=0;
		for(int i=0;i<prefix.length();i++) {
			if(temp.next[prefix.charAt(i)-'a']==null) {
				return 0;
			}
			temp=temp.next[prefix.charAt(i)-'a'];
		}
		ans+=temp.value;
		for(int i=0;i<26;i++) {
			if(temp.next[i]!=null)
				ans+=search(temp.next[i]);
		}
		return ans;
	}
	int search(Node node) {
		if(node==null)
			return 0;
		else {
			int val=0;
			Node temp=node;
			val+=node.value;
			for(int i=0;i<26;i++) {
				if(temp.next[i]!=null)
					val+=search(temp.next[i]);
			}
			return val;
		}
	}
}
