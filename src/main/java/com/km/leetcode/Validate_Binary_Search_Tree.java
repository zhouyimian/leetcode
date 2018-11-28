package com.km.leetcode;

import java.util.*;

public class Validate_Binary_Search_Tree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	List<Integer> list=new ArrayList<>();
	public boolean isValidBST(TreeNode root) {
		if(root==null)
			return true;
		mid(root.left);
		list.add(root.val);
		mid(root.right);
		for(int i=0;i<list.size()-1;i++) {
			if(list.get(i)>=list.get(i+1))
				return false;
		}
		return true;
	}
	void mid(TreeNode root) {
		if(root==null)
			return ;
		mid(root.left);
		list.add(root.val);
		mid(root.right);
	}
}
