package com.km.leetcode;

public class Invert_Binary_Tree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode invertTree(TreeNode root) {
		if(root==null)
			return null;
		else {
			TreeNode temp=root.right;
			root.right=root.left;
			root.left=temp;
			invert(root.left);
			invert(root.right);
		}
		return root;
	}
	void invert(TreeNode root) {
		if(root==null)
			return;
		else {
			TreeNode temp=root.right;
			root.right=root.left;
			root.left=temp;
			invert(root.left);
			invert(root.right);
		}
	}
}
