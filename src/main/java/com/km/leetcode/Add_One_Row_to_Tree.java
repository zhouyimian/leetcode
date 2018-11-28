package com.km.leetcode;

import java.util.*;

public class Add_One_Row_to_Tree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode addOneRow(TreeNode root, int v, int d) {
		if(d==1) {
			TreeNode newNode=new TreeNode(v);
			newNode.left=root;
			return newNode;
		}
		else {
			addrow(root,1,v,d);
			return root;
		}
    }
	void addrow(TreeNode root,int deep,int value,int d) {
		if(root==null)
			return;
		if(deep==d-1) {
			TreeNode left=new TreeNode(value);
			TreeNode right=new TreeNode(value);
			left.left=root.left;
			right.right=root.right;
			root.left=left;
			root.right=right;
		}
		else {
			addrow(root.left,deep+1,value,d);
			addrow(root.right,deep+1,value,d);
		}
	}
}
