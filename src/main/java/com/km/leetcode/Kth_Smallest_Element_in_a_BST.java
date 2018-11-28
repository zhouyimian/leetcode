package com.km.leetcode;

public class Kth_Smallest_Element_in_a_BST {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int kthSmallest(TreeNode root, int k) {
		return search(root,k);
	}
	int search(TreeNode root,int k) {
		int left_num=num(root.left);
		if(left_num==k-1)
			return root.val;
		else if(left_num>k-1) {
			return search(root.left,k);
		}
		else {
			return search(root.right,k-left_num-1);
		}
	}
	int num(TreeNode root) {
		if(root==null)
			return 0;
		else {
			return 1+num(root.left)+num(root.right);
		}
	}
}
