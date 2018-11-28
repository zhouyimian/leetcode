package com.km.leetcode;

public class Diameter_of_Binary_Tree {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int x) {
			val = x;
		}
	}
	
	int max=0;
	public int diameterOfBinaryTree(TreeNode root) {
		if (root == null)
			return 0;
		point(root);
		return max;
	}
	void point(TreeNode root) {
		if (root == null)
			return;
		int length_left = length(root.left);
		int length_right = length(root.right);
		if (length_left + length_right> max)
			max = length_left + length_right;
		point(root.left);
		point(root.right);
	}
	int length(TreeNode root) {
		if (root == null)
			return 0;
		else {
			int length_left = length(root.left);
			int length_right = length(root.right);
			return ((length_left> length_right ? length_left: length_right) + 1);
		}
	}
}
