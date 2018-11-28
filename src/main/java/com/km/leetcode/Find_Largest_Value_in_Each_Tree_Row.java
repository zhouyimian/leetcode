package com.km.leetcode;

import java.util.*;

public class Find_Largest_Value_in_Each_Tree_Row {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	List<Integer> list=new ArrayList<Integer>();
	public List<Integer> largestValues(TreeNode root) {
		if(root==null)
			return list;
		else {
			Ans(root,0);
			return list;
		}
	}
	public void Ans(TreeNode root, int deep) {
		if(root==null)
			return;
		else if(list.size()<=deep) {
			list.add(deep,root.val);
		}
		else {
			if(root.val>list.get(deep)) {
				list.set(deep, root.val);
			}
		}
		Ans(root.left,deep+1);
		Ans(root.right,deep+1);
	}
}
