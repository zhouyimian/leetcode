package com.km.leetcode;

import java.util.*;

public class Binary_Tree_Right_Side_View {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	int DEEP=1;
	int[] ans;
	int[] pos;
	List<Integer> list=new ArrayList<Integer>();
	public List<Integer> rightSideView(TreeNode root) {
		if(root==null)
			return list;
		else {
			Search_deep(root,1);
			ans=new int[DEEP+1];
			pos=new int[DEEP+1];
			pos[1]=1;
			ans[1]=root.val;
			Search(root.left,2,2);
			Search(root.right,2,3);
			for(int i=1;i<=DEEP;i++) {
				list.add(ans[i]);
			}
			return list;
		}
    }
	void Search_deep(TreeNode root,int deep) {
		if(root==null)
			return;
		if(deep>DEEP)
			DEEP=deep;
		Search_deep(root.left,deep+1);
		Search_deep(root.right,deep+1);
	}
	void Search(TreeNode root,int deep,int index) {
		if(root==null)
			return;
		if(pos[deep]==0) {
			pos[deep]=index;
			ans[deep]=root.val;
		}
		else if(pos[deep]<index) {
			pos[deep]=index;
			ans[deep]=root.val;
		}
		Search(root.left,deep+1,index*2);
		Search(root.right,deep+1,index*2+1);
	}
}
