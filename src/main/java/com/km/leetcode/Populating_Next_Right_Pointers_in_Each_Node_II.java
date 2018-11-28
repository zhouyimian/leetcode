package com.km.leetcode;

import java.util.ArrayList;
import java.util.List;

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(int x) {
		val = x;
	}
}

public class Populating_Next_Right_Pointers_in_Each_Node_II {
	public static void connect(TreeLinkNode root) {
		List<TreeLinkNode> list=new ArrayList<>();
		if(root==null)
			return;
		root.next=null;
		list.add(root);
		while(!list.isEmpty()) {
			List<TreeLinkNode> temp=new ArrayList<>();
			for(int i=0;i<list.size();i++) {
				TreeLinkNode node=list.get(i);
				if(node.left!=null) temp.add(node.left);
				if(node.right!=null) temp.add(node.right);
				if(i!=list.size()-1)
                    list.get(i).next=list.get(i+1);
                else
					list.get(i).next=null;
			}
			list.clear();
			list.addAll(temp);
            temp.clear();
		}
	}
	public static void main(String[] args) {
		TreeLinkNode root=new TreeLinkNode(1);
		root.left=new TreeLinkNode(2);
		root.right=new TreeLinkNode(3);
		connect(root);
	}
}
