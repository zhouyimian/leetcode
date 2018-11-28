package com.km.leetcode;

public class Find_Bottom_Left_Tree_Value {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	int DEEP = 1;
	int left;

	public int findBottomLeftValue(TreeNode root) {
		left=root.val;
		find_left(root.left, 2);
		find_left(root.right, 2);
		return left;
	}

	void find_left(TreeNode root, int deep) {
		if (root == null)
			return;
		if (deep > DEEP) {
			DEEP = deep;
			left = root.val;
			find_left(root.left, deep + 1);
			find_left(root.right, deep + 1);
		} else {
			find_left(root.left, deep + 1);
			find_left(root.right, deep + 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
