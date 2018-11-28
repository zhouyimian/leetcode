package com.km.leetcode;

import java.util.*;

public class Convert_BST_to_Greater_Tree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	List<Integer> list = new ArrayList<>();
	int count=0;
	public TreeNode convertBST(TreeNode root) {
		if (root == null)
			return null;
		add(root);
		for(int i=list.size()-2;i>=0;i--) {
			list.set(i, list.get(i)+list.get(i+1));
		}
		set(root);
		return root;
		
	}
	void add(TreeNode root) {
		if(root==null)
			return;
		add(root.left);
		list.add(root.val);
		add(root.right);
	}
	void set(TreeNode root) {
		if(root==null)
			return;
		set(root.left);
		root.val=list.get(count++);
		set(root.right);
	}
	/*int sum=0;
	public int sumOfLeftLeaves(TreeNode root) {
		if(root==null)
			return 0;
		find(root.left,'l');
		find(root.right,'r');
		return sum;
    }
	void find(TreeNode root,char pos) {
		if(root==null)
			return;
		else {
			if(pos=='l'&&root.left==null&&root.right==null) {
				sum+=root.val;
			}
			find(root.left,'l');
			find(root.right,'r');
		}
	}*/
	
}
