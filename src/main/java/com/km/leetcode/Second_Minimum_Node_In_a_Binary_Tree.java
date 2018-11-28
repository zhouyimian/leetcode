package com.km.leetcode;

public class Second_Minimum_Node_In_a_Binary_Tree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

	}
	int min,minsecond;
	public int findSecondMinimumValue(TreeNode root) {
		if(root.left==null&&root.right==null) {
			return -1;
		}
		else {
			min=root.val;
			minsecond=root.val;
			search(root.left);
			search(root.right);
			if(minsecond==root.val)
				return -1;
			else
				return minsecond;
		}
	}
	void search(TreeNode root) {
		if(root==null)
			return;
		if(min==minsecond&&root.val>min) {
			minsecond=root.val;
		}
		else if(min!=minsecond&&root.val<minsecond&&root.val!=min) {
			minsecond=root.val;
		}
		search(root.left);
		search(root.right);
	}
}
