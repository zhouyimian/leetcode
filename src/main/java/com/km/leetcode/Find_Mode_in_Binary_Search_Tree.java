package com.km.leetcode;

import java.util.*;

public class Find_Mode_in_Binary_Search_Tree {
	static int max=0;
	static Map<Integer,Integer> map=new LinkedHashMap<>();
	public static int[] findMode(TreeNode root) {
		int[] ans;
		if(root==null)
			return new int[0];
		else {
			Search_Element(root);
			int maxcount=0;
			Set set=map.keySet();
			Iterator it=set.iterator();
			while(it.hasNext()) {
				int value=map.get(it.next());
				if(value==max)
					maxcount++;
			}
			it=set.iterator();
			int count=0;
			ans=new int[maxcount];
			while(it.hasNext()) {
				int key=(int) it.next();
				int value=map.get(key);
				if(value==max)
					ans[count++]=key;
			}
		}
		return ans;
	}
	static void Search_Element(TreeNode root) {
		if(root==null)
			return ;
		else {
			if(!map.containsKey(root.val)) {
				map.put(root.val, 1);
				if(max==0)
					max=1;
			}
			else {
				map.put(root.val, map.get(root.val)+1);
				if(map.get(root.val)>max)
					max=map.get(root.val);
			}
			Search_Element(root.left);
			Search_Element(root.right);
		}
	}
	public static void main(String[] args) {
		TreeNode root=new TreeNode(1);
		root.right=new TreeNode(2);
		root.right.left=new TreeNode(2);
		findMode(root);
	}
	
}
