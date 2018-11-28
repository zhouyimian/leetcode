package com.km.leetcode;

class Node {
	public boolean isword;
	public Node[] children;
	public char c;
	public Node(char c) {
		this.c=c;
		this.isword = false;
		this.children = new Node[26];
	}
}
public class WordDictionary {
	public static void main(String[] args) {
		WordDictionary word=new WordDictionary();
		word.addWord("at");
		word.addWord("and");
		word.addWord("an");
		word.addWord("add");
		//System.out.println(word.search("a"));
		//System.out.println(word.search(".at"));
		word.addWord("bat");
		System.out.println(word.search("b."));
		/*System.out.println(word.search("an."));
		System.out.println(word.search("a.d."));
		System.out.println(word.search("b."));
		System.out.println(word.search("a.d"));
		System.out.println(word.search("."));*/
	}
	static Node root;
	public WordDictionary() {
		root=new Node(' ');
	}
	public static void addWord(String word) {
		Node temp=root;
		for(char c:word.toCharArray()) {
			if(temp.children[c-'a']==null)
				temp.children[c-'a']=new Node(c);
			temp=temp.children[c-'a'];
		}
		temp.isword=true;
	}

	public static boolean search(String word) {
		Node temp=root;
		int num=1;
		for(char c:word.toCharArray()) {
			if(c=='.') {
				return search(temp,word.substring(num));
			}
			else if(temp.children[c-'a']==null)
				return false;
			temp=temp.children[c-'a'];
			num++;
		}
		return temp.isword;
	}
	public static boolean search(Node node,String word) {
		if(word.length()==0) {
			for(int i=0;i<26;i++) {
				if(node.children[i]!=null&&node.children[i].isword==true)
					return true;
			}
			return false;
		}
		Node temp = null;
		for(int i=0;i<26;i++) {
			boolean flag=true;
			int num=1;
			temp=node;
			if(temp.children[i]==null)
				continue;
			temp=temp.children[i];
			for(char c:word.toCharArray()) {
				if(c=='.') {
					flag=search(temp,word.substring(num));
					if(flag)
						return true;
					break;
				}
				else if(temp.children[c-'a']==null) {
					flag=false;
					break;
				}
				temp=temp.children[c-'a'];
				num++;
			}
			if(flag==true&&temp.isword==true)
				return true;
		}
		return false;
	}
}
