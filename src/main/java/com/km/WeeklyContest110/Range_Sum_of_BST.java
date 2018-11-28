package com.km.WeeklyContest110;

class TreeNode {
	int val;
	com.km.WeeklyContest110.TreeNode left;
	com.km.WeeklyContest110.TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Range_Sum_of_BST {
	public int rangeSumBST(com.km.WeeklyContest110.TreeNode root, int L, int R) {
		if(root==null)
			return 0;
		if(root.left==null&&root.right==null) {
			if(root.val>=L&&root.val<=R)
				return root.val;
			else
				return 0;
		}
		if(root.val<L)
			return rangeSumBST(root.right,L,R);
		else if(root.val>R)
			return rangeSumBST(root.left,L,R);
		else
			return root.val+rangeSumBST(root.right,L,R)+rangeSumBST(root.left,L,R);
	}
}
