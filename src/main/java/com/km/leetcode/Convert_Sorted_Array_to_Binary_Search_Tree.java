package com.km.leetcode;

public class Convert_Sorted_Array_to_Binary_Search_Tree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode sortedArrayToBST(int[] nums) {
		if(nums.length==0)
			return null;
		else if(nums.length==1)
			return new TreeNode(nums[0]);
		else {
			TreeNode root=new TreeNode(nums[nums.length/2]);
			root.left=buildTree(nums,0,nums.length/2-1);
			root.right=buildTree(nums,nums.length/2+1,nums.length-1);
			return root;
		}
	}
	TreeNode buildTree(int[] nums,int start,int end) {
		if(start>end)
			return null;
		TreeNode root=new TreeNode(nums[(start+end)/2]);
		root.left=buildTree(nums,start,(start+end)/2-1);
		root.right=buildTree(nums,(start+end)/2+1,end);
		return root;
	}
}
