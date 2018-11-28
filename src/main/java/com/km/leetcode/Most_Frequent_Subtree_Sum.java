package com.km.leetcode;

import java.util.*;

public class Most_Frequent_Subtree_Sum {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	Map<Integer,Integer> map=new HashMap<Integer,Integer>();
	public int[] findFrequentTreeSum(TreeNode root) {
		int[] a;
		if (root == null) {
			a = new int[0];
			return a;
		}
		else {
			Sum(root);
			int max=0,time = 0;
			Set set=map.keySet();
			Iterator it=set.iterator();
			while(it.hasNext()) {
				int value=map.get(it.next());
				if(value==max) {
					time++;
				}
				else if(value>max) {
					max=value;
					time=1;
				}
					
			}
			int count=0;
			a=new int[time];
			it=set.iterator();
			while(it.hasNext()) {
				int key=(int) it.next();
				int value=map.get(key);
				if(value==max)
					a[count++]=key;
			}
		}
		return a;
	}
	private int Sum(TreeNode root) {
		if(root==null)
			return 0;
		else {
			int sum=root.val+Sum(root.left)+Sum(root.right);
			if(!map.containsKey(sum)) {
				map.put(sum, 1);
			}
			else {
				map.put(sum,map.get(sum)+1);
			}
			return sum;
		}
	}
}
