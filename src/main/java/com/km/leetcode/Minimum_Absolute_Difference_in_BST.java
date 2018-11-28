package com.km.leetcode;

import java.util.*;

public class Minimum_Absolute_Difference_in_BST {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	Set set=new TreeSet<>();
	public int getMinimumDifference(TreeNode root) {
		int min=Integer.MAX_VALUE;
		dfs(root);
		int[] nums=new int[set.size()];
		Iterator it=set.iterator();
		int i=0;
		while(it.hasNext()) {
			nums[i++]=(int)it.next();
		}
		for(i=nums.length-1;i>0;i--) {
			min=Math.min(min, nums[i]-nums[i-1]);
		}
		return min;
	}
	void dfs(TreeNode root) {
		if(root==null)
			return;
		else {
			dfs(root.left);
			set.add(root.val);
			dfs(root.right);
		}
	}
	
}
