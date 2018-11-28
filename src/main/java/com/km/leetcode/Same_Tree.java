package com.km.leetcode;

public class Same_Tree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p==null&&q==null) {
			return true;
		}
		if((p==null&&q!=null)||(p!=null&&q==null)) {
			return false;
		}
		if(p.val==q.val&&same(p.left,q.left)&&same(p.right,q.right))
			return true;
		else
			return false;
	}
	boolean same(TreeNode p, TreeNode q){
		if(p==null&&q==null) {
			return true;
		}
		if((p==null&&q!=null)||(p!=null&&q==null)) {
			return false;
		}
		if(p.val==q.val&&same(p.left,q.left)&&same(p.right,q.right))
			return true;
		else
			return false;
	}

}
