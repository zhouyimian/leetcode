package com.km.leetcode;

public class Two_Sum_IV_Input_is_a_BST {
	public class TreeNode
	{
		int val;
		TreeNode left;
		TreeNode right;
	}
	boolean flag=false;
	public boolean findTarget(TreeNode root,int k) {
		if(root==null||(root.left==null&&root.right==null)) {
			return false;
		}
		else{
			search(root,root,k);
			return flag;
		}
	}
	void search(TreeNode root,TreeNode node,int k) {
		if(flag==true||node==null)
			return;
		if(node.val>k/2) {
			search_other(root,node,k-node.val);
		}
		else{
			search_other(root,node,k-node.val);
		}
		search(root,node.left,k);
		search(root,node.right,k);
	}
	void search_other(TreeNode root,TreeNode node,int value) {
		if(root==null||flag==true||root==node)
			return;
		if(root.val==value) {
			flag=true;
			return;
		}
		else if(root.val>value) {
			search_other(root.left,node,value);
		}
		else {
			search_other(root.right,node,value);
		}
		
	}
}
