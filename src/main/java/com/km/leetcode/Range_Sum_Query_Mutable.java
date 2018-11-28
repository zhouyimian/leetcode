package com.km.leetcode;

public class Range_Sum_Query_Mutable {
	class Treenode{
		int start;
		int end;
		int sum;
		Treenode left;
		Treenode right;
		public Treenode(int start,int end) {
			this.start=start;
			this.end=end;
			this.sum=0;
		}
	}
	public Treenode root;
	
	public Range_Sum_Query_Mutable(int[] nums) {
		this.root=bulidTree(0,nums.length-1,nums);
	}

	public void update(int i, int val) {
		updateTree(root,i,val);
	}

	public int sumRange(int i, int j) {
		return sum(root,i,j);
	}
	public Treenode bulidTree(int start,int end,int[] nums) {
		if(start>end)
			return null;
		Treenode node=new Treenode(start,end);
		if(start==end) {
			node.sum=nums[start];
			return node;
		}
		int mid=(start+end)/2;
		node.left=bulidTree(start, mid, nums);
		node.right=bulidTree(mid+1, end, nums);
		node.sum=node.left.sum+node.right.sum;
		return node;
	}
	public void updateTree(Treenode node,int i,int val) {
		if(node.start==node.end&&node.start==i) {
			node.sum=val;
			return;
		}
		if(node.start>i||node.end<i)
			return;
		int mid=(node.start+node.end)/2;
		if(i<=mid)
			updateTree(node.left, i, val);
		else
			updateTree(node.right, i, val);
		node.sum=node.left.sum+node.right.sum;
	}
	public int sum(Treenode node,int start,int end) {
		if(node.start==start&&node.end==end)
			return node.sum;
		int mid=(node.start+node.end)/2;
		if(end<=mid)
			return sum(node.left,start,end);
		else if(start>mid) 
			return sum(node.right,start,end);
		else
			return sum(node.left,start,mid)+sum(node.right,mid+1,end);
	}
	public static void main(String[] args) {
		int[] nums= {9,-8};
		Range_Sum_Query_Mutable s=new Range_Sum_Query_Mutable(nums);
		s.update(0, 3);
		System.out.println(s.sumRange(1, 1));
		System.out.println(s.sumRange(0, 1));
		s.update(1, -3);
		System.out.println(s.sumRange(0, 1));
	}
}
