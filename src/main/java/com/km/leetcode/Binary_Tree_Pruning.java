package com.km.leetcode;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Binary_Tree_Pruning {
	public TreeNode pruneTree(TreeNode root) {
		if(root==null||(root.val==0&&root.left==null&&root.right==null))
			return null;
		root.left=pruneTree(root.left);
		root.right=pruneTree(root.right);
		if(root.val==0&&root.left==null&&root.right==null)
			return null;
		return root;
	}
}
