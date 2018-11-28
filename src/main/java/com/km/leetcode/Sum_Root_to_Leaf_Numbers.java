package com.km.leetcode;

public class Sum_Root_to_Leaf_Numbers {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	int sum=0;
	public int sumNumbers(TreeNode root) {
		if(root==null)
			return 0;
		SearchSum(root,new StringBuffer());
		return sum;
	}
	void SearchSum(TreeNode root,StringBuffer sb) {
		sb.append(root.val);
		if(root.left==null&&root.right==null) {
			sum+=Integer.parseInt(new String(sb));
		}
		else if(root.left==null) {
			SearchSum(root.right,sb);
		}
		else if(root.right==null) {
			SearchSum(root.left,sb);
		}
		else {
			SearchSum(root.left,sb);
			SearchSum(root.right,sb);
		}
		sb.deleteCharAt(sb.length()-1);
	}
}
