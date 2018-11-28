package com.km.leetcode;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class CBTInserter {
	int count=0;
	TreeNode root;
	int ans=0;
	public CBTInserter(TreeNode root) {
		this.root=root;
		count=nums(root);
	}

	public int nums(TreeNode node) {
		if(node==null)
			return 0;
		return 1+nums(node.left)+nums(node.right);
	}

	public int insert(int v) {
		count++;
		
		return 0;
	}

	public TreeNode get_root() {
		return root;
	}
}
