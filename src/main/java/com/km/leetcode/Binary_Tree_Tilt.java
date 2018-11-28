package com.km.leetcode;

public class Binary_Tree_Tilt {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	int sum=0;
	public int findTilt(TreeNode root) {
		abs(root);
		return sum;
	}
	int abs(TreeNode root) {
		if(root==null)
			return 0;
		int left=abs(root.left);
		int mid=root.val;
		int right=abs(root.right);
		sum+=Math.abs(left-right);
		return left+right+mid;
	}
}
