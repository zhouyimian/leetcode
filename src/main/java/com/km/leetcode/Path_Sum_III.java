package com.km.leetcode;


public class Path_Sum_III {

	static int ans = 0;

	public static int pathSum(TreeNode root, int sum) {
		if (root == null)
			return 0;
		getSum(root, 0, sum, true);
		getSum(root, 0, sum, false);
		return ans;
	}
	public static void getSum(TreeNode root, int value, int sum, boolean take) {
		if (root == null)
			return;
		if (take == true) {
			if (value + root.val == sum)
				ans++;
		}
		if (take == false) {
			if(value!=0)
				return;
			getSum(root.left, 0, sum, true);
			getSum(root.left, 0, sum, false);
			getSum(root.right, 0, sum, true);
			getSum(root.right, 0, sum, false);
		} else {
			getSum(root.left, root.val + value, sum, true);
			getSum(root.right, root.val + value, sum, true);
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.right = new TreeNode(3);
		root.right.right.right = new TreeNode(4);
		root.right.right.right.right = new TreeNode(5);
		System.out.println(pathSum(root, 3));
	}
}
