package com.km.leetcode;

import java.util.*;

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;
	
	TreeLinkNode(int x) {
		val = x;
	}
}
public class Populating_Next_Right_Pointers_in_Each_Node {
	static List<List<TreeLinkNode>> list=new ArrayList<>();
	public static void connect(TreeLinkNode root) { 
		int deep=Deep(root);
		for(int i=0;i<deep;i++) {
			list.add(new ArrayList<>());
		}
		firstOrder(root,0);
		for(int i=0;i<deep;i++) {
			List<TreeLinkNode> temp=list.get(i);
			for(int j=0;j<temp.size()-1;j++) {
				temp.get(j).next=temp.get(j+1);
			}
			temp.get(temp.size()-1).next=null;
		}
	}
	static int Deep(TreeLinkNode root) {
		if(root==null)
			return 0;
		else {
			int leftdeep=Deep(root.left);
			int rightdeep=Deep(root.right);
			return leftdeep>rightdeep?(leftdeep+1):(rightdeep+1);
		}
	}
	static void firstOrder(TreeLinkNode root,int deep) {
		if(root==null)
			return;
		else {
			list.get(deep).add(root);
			firstOrder(root.left,deep+1);
			firstOrder(root.right,deep+1);
		}
	}
	public static void main(String[] args) {
		TreeLinkNode root=new TreeLinkNode(1);
		root.left=new TreeLinkNode(2);
		root.right=new TreeLinkNode(3);
		connect(root);
		System.out.println(list.get(1).get(0).right.val);
	}
}
