package com.km.WeeklyContest94;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
	int val;
	com.km.WeeklyContest94.TreeNode left;
	com.km.WeeklyContest94.TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Leaf_Similar_rees {
	public boolean leafSimilar(com.km.WeeklyContest94.TreeNode root1, com.km.WeeklyContest94.TreeNode root2) {
		List<Integer> tree1=new ArrayList<>();
		List<Integer> tree2=new ArrayList<>();
		first(root1,tree1);
		first(root2,tree2);
		if(tree1.size()!=tree2.size())
			return false;
		for(int i=0;i<tree1.size();i++) {
			if(tree1.get(i)!=tree2.get(i))
				return false;
		}
		return true;
	}

	public void first(com.km.WeeklyContest94.TreeNode root, List<Integer> tree) {
		if(root==null)
			return;
		else {
			if(root.left==null&&root.right==null) {
				tree.add(root.val);
			}
			else {
				first(root.left,tree);
				first(root.right,tree);
			}
		}
		
	}
}
