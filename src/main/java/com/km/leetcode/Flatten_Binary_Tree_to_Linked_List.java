package com.km.leetcode;

public class Flatten_Binary_Tree_to_Linked_List {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	int[] value;
	int num=0;
	public void flatten(TreeNode root) {
		if(root==null)
			return;
		else {
			num++;
			Count(root.left);
			Count(root.right);
			value=new int[num];
			num=0;
			Search(root.left);
			Search(root.right);
			root.left=null;
			for(int i=0;i<num;i++) {
				root.right=new TreeNode(value[i]);
				root=root.right;
			}
		}
	}
	void Count(TreeNode root) {
		if(root==null)
			return;
		else {
			num++;
			Count(root.left);
			Count(root.right);
		}
	}
	void Search(TreeNode root) {
		if(root==null)
			return;
		else {
			value[num++]=root.val;
			Search(root.left);
			Search(root.right);
			root=null;
		}
	}
}
