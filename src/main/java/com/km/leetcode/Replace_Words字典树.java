package com.km.leetcode;

import java.util.*;

public class Replace_Words字典树 {
	class Node{
		public int isword;
		public char c;
		public Node[] children;
		public Node(char c) {
			this.c=c;
			children=new Node[26];
			this.isword=0;
		}
	}
	public String replaceWords(List<String> dict, String sentence) {
		Node root=new Node(' ');
		buildTree(dict,root);
		StringBuilder sb=new StringBuilder();
		String[] temp=sentence.split(" ");
		for(int i=0;i<temp.length;i++) {
			if(i!=temp.length-1)
				sb.append(replace(root,temp[i])+" ");
			else
				sb.append(replace(root,temp[i]));
		}
		return new String(sb);
	}
	void buildTree(List<String> dict,Node root) {
		Node temp;
		for(String s:dict) {
			temp=root;
			for(char c:s.toCharArray()) {
				if(temp.children[c-'a']==null)
					temp.children[c-'a']=new Node(c);
				temp=temp.children[c-'a'];
			}
			temp.isword=1;
		}
	}
	String replace(Node root,String s) {
		StringBuilder sb=new StringBuilder();
		for(char c:s.toCharArray()) {
			sb.append(c);
			if(root.children[c-'a']==null)
				return s;
			else {
				root=root.children[c-'a'];
				if(root.isword==1)
					return new String(sb);
			}
		}
		return new String(sb);
	}
}
