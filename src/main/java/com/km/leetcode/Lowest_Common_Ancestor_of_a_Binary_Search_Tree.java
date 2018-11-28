package com.km.leetcode;

public class Lowest_Common_Ancestor_of_a_Binary_Search_Tree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root==null)
			return null;
		else {
			if((root.val>p.val&&root.val<q.val)||(root.val<p.val&&root.val>q.val))
				return root;
			if(root.val==q.val||root.val==p.val)
				return root.val==q.val?q:p;
			else if(root.val<p.val)
				return lowestCommonAncestor(root.right,p,q);
			else
				return lowestCommonAncestor(root.left,p,q);
		}
	}
}
