package com.km.leetcode;

import java.util.*;

public class Binary_Search_Tree_Iterator {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	public class BSTIterator {
		
		List<Integer> list=new ArrayList<>();
	    public BSTIterator(TreeNode root) {
	    	insert(root);
	    }

	    /** @return whether we have a next smallest number */
	    public boolean hasNext() {
	    	return !list.isEmpty();
	    }

	    /** @return the next smallest number */
	    public int next() {
	        int ans=list.get(0);
	        list.remove(0);
	        return ans;
	    }
	    public void insert(TreeNode root) {
	    	if(root==null)
	    		return;
	    	insert(root.left);
	    	list.add(root.val);
	    	insert(root.right);
	    	
	    }
	}

}
