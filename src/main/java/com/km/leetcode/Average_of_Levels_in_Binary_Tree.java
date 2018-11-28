package com.km.leetcode;

import java.util.*;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int x) {
		val = x;
	}
}
public class Average_of_Levels_in_Binary_Tree {
	static int Deep=-1;
	static List<Double> list=new ArrayList<Double>();
	static List<Integer> count=new ArrayList<Integer>();
	public static List<Double> averageOfLevels(TreeNode root) {
		getSum(root,0);
		for(int i=0;i<list.size();i++) {
			list.set(i, list.get(i)/count.get(i));
		}
		return list;
	}
	static void getSum(TreeNode root,int deep) {
		if(root==null)
			return;
		if(deep>Deep) {
			list.add(deep, (double) root.val);
			count.add(deep, 1);
			Deep=deep;
		}
		else {
			list.set(deep, list.get(deep) + root.val);
			count.set(deep, count.get(deep) + 1);
		}
		getSum(root.left, deep + 1);
		getSum(root.right,deep+1);
		
	}
	public static void main(String[] args) {
		TreeNode root=new TreeNode(3);
		root.left=new TreeNode(9);
		root.right=new TreeNode(20);
		root.right.left=new TreeNode(15);
		root.right.right=new TreeNode(7);
		List<Double> list=averageOfLevels(root);
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}
}
