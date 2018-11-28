package com.km.leetcode;

public class Subtree_of_Another_Tree {
	public boolean isSubtree(TreeNode s, TreeNode t) {
		int deep1=SearchDeep(s);
		int deep2=SearchDeep(t);
		if(deep1<deep2)
			return false;
		else if(deep1==0&&deep2==0)
			return true;
		else
			return isSub(s, t,deep1,deep2);
	}
	int SearchDeep(TreeNode root) {
		if(root==null)
			return 0;
		else {
			int deep1=SearchDeep(root.left);
			int deep2=SearchDeep(root.right);
			return deep1>deep2?(deep1+1):(deep2+1);
		}
	}
	boolean isSub(TreeNode s, TreeNode t, int deep1,int deep2) {
		if(s==null&&t==null)
			return true;
		if(s==null||t==null)
			return false;
		if(deep1==deep2) {
			return isSame(s,t);
		}
		else if(deep1<deep2)
			return false;
		else {
			int deep1_left = SearchDeep(s.left);
			int deep1_right = SearchDeep(s.right);
			return isSub(s.left,t,deep1_left,deep2)||isSub(s.right,t,deep1_right,deep2);
		}
	}
	boolean isSame(TreeNode s,TreeNode t) {
		if(s==null&&t==null)
			return true;
		else if(s==null||t==null)
			return false;
		else {
			if(s.val!=t.val)
				return false;
			else {
				return isSame(s.left,t.left)&&isSame(s.right,t.right);
			}
		}
	}
}
