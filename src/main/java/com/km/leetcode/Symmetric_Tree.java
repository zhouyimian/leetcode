package com.km.leetcode;

public class Symmetric_Tree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public boolean isSymmetric(TreeNode root) {
		if(root==null)
			return true;
		TreeNode tempNode=new TreeNode(root.val);
		tempNode.left=buildTree(root.left);
		tempNode.right=buildTree(root.right);
		Reserve(tempNode);
		return isSame(root,tempNode);
	}
	TreeNode buildTree(TreeNode root) {
		if(root==null)
			return null;
		TreeNode node=new TreeNode(root.val);
		node.left=buildTree(root.left);
		node.right=buildTree(root.right);
		return node;
	}
	void Reserve(TreeNode root) {
		if(root==null)
			return;
		TreeNode temp=root.left;
		root.left=root.right;
		root.right=temp;
		Reserve(root.left);
		Reserve(root.right);
	}
	boolean isSame(TreeNode root1,TreeNode root2) {
		if(root1==null&&root2==null)
			return true;
		if(root1==null||root2==null)
			return false;
		if(root1.val==root2.val) {
			return isSame(root1.left,root2.left)&&isSame(root1.right,root2.right);
		}
		else
			return false;
	}
}
