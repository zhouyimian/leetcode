package com.km.leetcode;

import java.util.*;

public class Find_Duplicate_Subtrees {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		List<TreeNode> list=new ArrayList<>();
		if(root==null)
			return list;
		else {
			Map<String,List<TreeNode>> map=new HashMap<>();
			
			Save(root,map);
			
			for(List<TreeNode> l:map.values()) {
				if(l.size()>1)
					list.add(l.get(0));
			}
			return list;
		}
	}
	String Save(TreeNode root,Map<String,List<TreeNode>> map) {
		if(root==null)
			return "";
		else {
			String s="<"+Save(root.left,map)+root.val+Save(root.right,map)+">";
			if(!map.containsKey(s))
				map.put(s, new ArrayList<TreeNode>());
			map.get(s).add(root);
			return s;
		}
	}
}
