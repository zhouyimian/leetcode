package com.km.leetcode;

import java.util.*;

public class Binary_Tree_Zigzag_Level_Order_Traversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}


	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();
		if (root != null) {
			List temp = new ArrayList<TreeNode>();
			List value = new ArrayList<Integer>();
			temp.add(root);
			while (!temp.isEmpty()) {
				value.clear();
				List tempSecond=new ArrayList<TreeNode>();
				List valueSecond = new ArrayList<Integer>();
				for(int i=0;i<temp.size();i++) {
					TreeNode treenode = (TreeNode) temp.get(i);
					value.add(treenode.val);
					if (treenode.left != null)
						tempSecond.add(treenode.left);
					if (treenode.right != null)
						tempSecond.add(treenode.right);
				}
				temp.clear();
				valueSecond.clear();
				temp.addAll(tempSecond);
				valueSecond.addAll(value);
				list.add(valueSecond);
			}
			for(int i=0;i<list.size();i++) {
				if(i%2==1)
					reserve(list.get(i));
			}
		}
		return list;
	}
	void reserve(List<Integer> list) {
		for(int i=0,j=list.size()-1;i<=j;i++,j--) {
			int temp1=list.get(i);
			int temp2=list.get(j);
			list.set(i, temp2);
			list.set(j, temp1);
		}
	}
	
}
