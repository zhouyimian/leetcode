package com.km.leetcode;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Insert_into_a_Binary_Search_Tree {
	public TreeNode insertIntoBST(TreeNode root, int val) {
		if(root==null)
			return null;
		if(val<root.val) {
			if(root.left==null)
				root.left=new TreeNode(val);
			else
				root.left=insertIntoBST(root.left,val);
		}
		else {
			if(root.right==null)
				root.right=new TreeNode(val);
			else
				root.right=insertIntoBST(root.right,val);
		}
		return root;
	}
}
