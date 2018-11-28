package com.km.leetcode;

public class Trim_a_Binary_Search_Tree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode trimBST(TreeNode root, int L, int R) {
		if (root == null) {
			return null;
		} else if (root.val >= L && root.val <= R) {
			root.left = trimBST(root.left, L, R);
			root.right = trimBST(root.right, L, R);
			return root;
		} else if (root.val > R) {
			root = trimBST(root.left, L, R);
			return root;
		} else {
			root = trimBST(root.right, L, R);
			return root;
		}
	}

	public static void main(String[] args) {

	}

}
