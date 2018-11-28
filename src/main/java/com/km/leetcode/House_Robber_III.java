package com.km.leetcode;

public class House_Robber_III {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	public int rob(TreeNode root) {
		if(root==null)
			return 0;
		int max1=root.val+findmax(root.left,true)+findmax(root.right,true);
		int max2=findmax(root.left,false)+findmax(root.right,false);
		return max1>max2?max1:max2;
	}
	int findmax(TreeNode root, boolean take) {
		if (root == null)
			return 0;
		if (take == true) {
			return findmax(root.left, false)+findmax(root.right, false);
		} else {
			int max1=root.val+findmax(root.left,true)+findmax(root.right,true);
			int max2=findmax(root.left,false)+findmax(root.right,false);
			return max1>max2?max1:max2;
		}
	}
}
