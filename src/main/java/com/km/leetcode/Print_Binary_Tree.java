package com.km.leetcode;

import java.util.*;

public class Print_Binary_Tree {
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	int Deep=0;
	String[][] ans;
	public List<List<String>> printTree(TreeNode root) {
		if(root==null)
			return null;
		else {
			List<List<String>> list=new ArrayList<List<String>>();
			heigh(root,1);
			ans=new String[Deep+1][(int) Math.pow(2, Deep)-1];
			for(int i=1;i<=Deep;i++) {
				for(int j=0;j<(int) Math.pow(2, Deep)-1;j++) {
					ans[i][j]="";
				}
			}
			set(root,1,0,'l');
			for(int i=1;i<=Deep;i++) {
				List<String> temp=new ArrayList<String>();
				for(int j=0;j<(int) Math.pow(2, Deep)-1;j++) {
					temp.add(ans[i][j]);
				}
				list.add(temp);
			}
			return list;
		}
	}
	void heigh(TreeNode root,int deep) {
		if(root==null)
			return;
		else {
			if(deep>Deep) {
				Deep=deep;
			}
			heigh(root.left,deep+1);
			heigh(root.right,deep+1);
		}
	}
	void set(TreeNode root,int deep,int pos,char l_r) {
		if(root==null)
			return;
		if(deep==1) {
			ans[deep][((int) Math.pow(2, Deep)-1)/2]=root.val+"";
			set(root.left,deep+1,((int) Math.pow(2, Deep)-1)/2,'l');
			set(root.right,deep+1,((int) Math.pow(2, Deep)-1)/2,'r');
		}
		else if(deep==Deep) {
			int left=pos-1;
			int right=pos+1;
			if(l_r=='l') {
				ans[deep][left]=root.val+"";
			}
			else {
				ans[deep][right]=root.val+"";
			}
		}
		else {
			int left=pos-((int) Math.pow(2, Deep)-1)/(int) Math.pow(2, deep)-1;
			int right=pos+((int) Math.pow(2, Deep)-1)/(int) Math.pow(2, deep)+1;
			if(l_r=='l') {
				ans[deep][left]=root.val+"";
				set(root.left,deep+1,left,'l');
				set(root.right,deep+1,left,'r');
			}
			else {
				ans[deep][right]=root.val+"";
				set(root.left,deep+1,right,'l');
				set(root.right,deep+1,right,'r');
			}
		}
	}
}
