package com.km.leetcode;

import java.util.*;

public class Path_Sum_II {
	static List<List<Integer>> ans=new ArrayList<>();
	static List<Integer> temp=new ArrayList<Integer>();
	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		if (root == null)
			return new ArrayList<List<Integer>>();
		getSum(root, 0, sum, true);
		return ans;
	}

	public static void getSum(TreeNode root, int value, int sum, boolean take) {
		if (root == null)
			return;
		if (take == true) {
			if (value + root.val == sum&&root.left==null&&root.right==null) {
				List<Integer> s=new ArrayList<Integer>();
				s.addAll(temp);
				s.add(root.val);
				ans.add(s);
			}
		}
		if (take == false) {
			if (value != 0)
				return;
			getSum(root.left, 0, sum, true);
			getSum(root.left, 0, sum, false);
			getSum(root.right, 0, sum, true);
			getSum(root.right, 0, sum, false);
		} else {
			temp.add(root.val);
			getSum(root.left, root.val + value, sum, true);
			getSum(root.right, root.val + value, sum, true);
			temp.remove(temp.size()-1);
		}
	}
	public static void main(String[] args) {
		TreeNode root=new TreeNode(3);
		root.right=new TreeNode(-3);
		root.right.right=new TreeNode(3);
		List<List<Integer>> a=pathSum(root,3);
		System.out.println(a.size());
	}
}
