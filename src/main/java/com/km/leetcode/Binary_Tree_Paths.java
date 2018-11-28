package com.km.leetcode;

import java.util.*;

/*class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int x) {
		val = x;
	}
}*/
public class Binary_Tree_Paths {
	static List<String> ans=new ArrayList<>();
	public static List<String> binaryTreePaths(TreeNode root) {
		StringBuilder sb = new StringBuilder("");
		if(root==null)
			return ans;
		if(root.left==null&&root.right==null) {
			sb.append(root.val);
			ans.add(new String(sb));
			return ans;
		}
		SearchPath(root,sb);
		return ans;
	}
	static void SearchPath(TreeNode root,StringBuilder sb) {
		if(root==null)
			return;
		if(root.left==null&&root.right==null) {
			sb.append(root.val);
			ans.add(new String(sb));
		}
		else {
			sb.append(root.val+"->");
			StringBuilder temp = new StringBuilder(sb);
			if(root.left!=null)
				SearchPath(root.left,temp);
			temp = new StringBuilder(sb);
			if(root.right!=null)
				SearchPath(root.right,temp);
		}
	}
	public static void main(String[] args) {
		TreeNode root=new TreeNode(5);
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);
		root.left.right=new TreeNode(5);
		List<String> li=binaryTreePaths(root);
		for(String s:li)
			System.out.println(s);
	}
}
