package com.km.leetcode;

import java.util.*;

class TreNode{
	public int val;
	public int leftsum;
	public int equal;
	public TreNode left;
	public TreNode right;
	public TreNode(int num) {this.val=num;}
}
public class Count_of_Smaller_Numbers_After_Self {
	static List<Integer> ans=new LinkedList<>();
	public static List<Integer> countSmaller(int[] nums) {
		if(nums.length==0)
			return ans;
		TreNode root=null;
		for(int i=nums.length-1;i>=0;i--) {
			if(root==null)
				root=buildTree(nums[i],0,root);
			else {
				buildTree(nums[i],0,root);
			}
		}
		return ans;
	}
	public static TreNode buildTree(int num,int presum,TreNode root) {
		if(root==null) {
			root=new TreNode(num);
			root.leftsum=0;
			ans.add(0,presum);
		}
		else if(root.val==num) {
			root.equal++;
			ans.add(0,presum+root.leftsum);
		}
		else if(root.val<num) {
			root.right=buildTree(num,presum+root.leftsum+root.equal+1,root.right);
		}
		else {
			root.leftsum++;
			root.left=buildTree(num,presum,root.left);
		}
		return root;
	}
	public static void main(String[] args) {
		int[] n= {5,2,6,1};
		List<Integer> list=countSmaller(n);
		for(int i:list) {
			System.out.println(i);
		}
	}
}
