package com.km.WeeklyContest91;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class All_Nodes_Distance_K_in_Binary_Tree {
	static List<List<Integer>> graph = new ArrayList<>();
	static int[] vis = new int[510];

	public static List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
		Set<Integer> ans=new HashSet<>();
		for(int i=0;i<=510;i++)
			graph.add(new ArrayList<>());
		buildGraph(root);
		List<Integer> list=new ArrayList<>();
		list.add(target.val);
		vis[target.val]=1;
		if(K==0) {
			List<Integer> l=new ArrayList<>();
			l.add(target.val);
			return l;
		}
		else if(K==1) {
			return graph.get(target.val);
		}
		while(list.size()!=0&&K!=0) {
			List<Integer> news=new ArrayList<>();
			for(int i=0;i<list.size();i++) {
				for(int j=0;j<graph.get(list.get(i)).size();j++) {
					if(vis[graph.get(list.get(i)).get(j)]==0) {
						news.add(graph.get(list.get(i)).get(j));
						vis[graph.get(list.get(i)).get(j)]=1;
					}
				}
			}
			list.clear();
			list.addAll(news);
			K--;
			if(K==0)
				ans.addAll(news);
		}
		return new ArrayList<>(ans);
	}

	public static void buildGraph(TreeNode root) {
		if (root == null || (root.left == null && root.right == null))
			return;
		TreeNode left = root.left;
		TreeNode right = root.right;
		if (left != null) {
			graph.get(root.val).add(left.val);
			graph.get(left.val).add(root.val);
			buildGraph(left);
		}
		if (right != null) {
			graph.get(root.val).add(right.val);
			graph.get(right.val).add(root.val);
			buildGraph(right);
		}
	}
	public static void main(String[] args) {
		TreeNode root=new TreeNode(0);
		root.right=new TreeNode(1);
		root.right.right=new TreeNode(2);
		root.right.right.right=new TreeNode(3);
		System.out.println(distanceK(root,root.right,2).size());
	}
}
