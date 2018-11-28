package com.km.leetcode;

public class Maximum_Binary_Tree {
	public static TreeNode constructMaximumBinaryTree(int[] nums) {
		if(nums.length==0)
			return null;
		else
			return Build(nums,0,nums.length-1);
	}
	static TreeNode Build(int[] nums,int start,int end) {
		TreeNode root=null;
		if(start>end) {
			return null;
		}
		else {
			int max=nums[start];
			int max_index = start;
			for(int i=start;i<=end;i++) {
				if(nums[i]>max) {
					max=nums[i];
					max_index=i;
				}
			}
			root=new TreeNode(max);
			root.left=Build(nums,start,max_index-1);
			root.right=Build(nums,max_index+1,end);
		}
		return root;
	}
	public static void main(String args[]){
		int[] nums= {3,2,1,6,0,5};
		TreeNode root=constructMaximumBinaryTree(nums);
	}
}
