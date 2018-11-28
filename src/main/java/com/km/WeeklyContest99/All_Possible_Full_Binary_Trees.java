package com.km.WeeklyContest99;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class All_Possible_Full_Binary_Trees {
	public static List<TreeNode> allPossibleFBT(int N) {
		List<TreeNode> list=new ArrayList<>();
		if(N%2==0)
			return new ArrayList<>();
		if(N==1) {
			TreeNode root=new TreeNode(0);
			list.add(root);
			return list;
		}
		for(int i=1;i<N;i+=2) {
			List<TreeNode> lefts=allPossibleFBT(i);
			List<TreeNode> rights=allPossibleFBT(N-i-1);
			for(TreeNode left:lefts) {
				for(TreeNode right:rights) {
					TreeNode root=new TreeNode(0);
					root.left=left;
					root.right=right;
					list.add(root);
				}
			}
		}
		return list;
	}
	public static void main(String[] args) {
		System.out.println(allPossibleFBT(7).size());
	}
}
