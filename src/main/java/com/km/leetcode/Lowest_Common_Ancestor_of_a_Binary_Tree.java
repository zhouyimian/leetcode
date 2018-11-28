package com.km.leetcode;

public class Lowest_Common_Ancestor_of_a_Binary_Tree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	TreeNode ans=null;
	boolean flag1=false;
	boolean flag2=false;
	boolean flag3=false;
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root==null)
			return null;
		if(root.val==p.val||root.val==q.val)
			return root;
		else {
			dfs(root.left,p,q);
			dfs(root.right,p,q);
			if(ans==null)
				return root;
		}
		return ans;
	}
	boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
		if(root.val==p.val||root.val==q.val) {
			if(flag1)
				flag2=true;
			else
				flag1=true;
		}
		flag2=dfs(root.left,p,q);
		flag3=dfs(root.right,p,q);
		if((flag1&&flag2)||(flag1&&flag3)||(flag2&&flag3)) {
			ans=root;
			return true;
		}
		return false;
	}
}
