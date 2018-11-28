package com.km.leetcode;

public class Balanced_Binary_Tree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isBalanced(TreeNode root) {
		if(root==null)
			return true;
		return Balance(root.left,root.right);
	}
	boolean Balance(TreeNode left,TreeNode right) {
		int Deep1=getDeep(left);
		int Deep2=getDeep(right);
		if(Math.abs(Deep1-Deep2)>1) {
			return false;
		}
		else {
			if(left==null&&right==null)
				return true;
			if(left==null)
				return Balance(right.left,right.right);
			if(right==null)
				return Balance(left.left,left.right);
			return Balance(right.left,right.right)&&Balance(left.left,left.right);
		}
	}
	int getDeep(TreeNode root) {
		if(root==null)
			return 0;
		int leftDeep=getDeep(root.left);
		int rightDeep=getDeep(root.right);
		return leftDeep>rightDeep?(leftDeep+1):(rightDeep+1);
	}
}
