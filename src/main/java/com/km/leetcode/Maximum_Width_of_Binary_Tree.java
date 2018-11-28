package com.km.leetcode;

import leetcode.Binary_Tree_Right_Side_View.TreeNode;

public class Maximum_Width_of_Binary_Tree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	int[][] ans;
	public int widthOfBinaryTree(TreeNode root) {
		if(root==null)
			return 0;
		int deep=Search_deep(root);
		ans=new int[deep][2];
		ans[0][0]=1;
		ans[0][1]=1;
		EachWidth(root.left,1,2);
		EachWidth(root.right,1,3);
		int maxWidth=0;
		for(int i=0;i<deep;i++) {
			if((ans[i][1]-ans[i][0])>maxWidth) {
				maxWidth=ans[i][1]-ans[i][0];
			}
		}
		return maxWidth+1;
	}
	int Search_deep(TreeNode root) {
		if(root==null)
			return 0;
		int deep1=Search_deep(root.left);
		int deep2=Search_deep(root.right);
		return deep1>deep2?(deep1+1):(deep2+1);
	}
	void EachWidth(TreeNode root,int deep,int number) {
		if(root==null)
			return;
		if(ans[deep][0]==0)
			ans[deep][0]=number;
		if(ans[deep][1]==0)
			ans[deep][1]=number;
		if(number<ans[deep][0])
			ans[deep][0]=number;
		if(number>ans[deep][1])
			ans[deep][1]=number;
		EachWidth(root.left,deep+1,number*2);
		EachWidth(root.right,deep+1,number*2+1);
	}
}
