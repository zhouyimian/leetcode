package com.km.leetcode;

import com.km.Interiew.binary_Search;

import java.util.HashSet;
import java.util.Set;

public class Friend_Circles {

	/**
	 * 这个并查集解法
	 */
//	int[] parent;
//	Map<Integer,ArrayList<Integer>> friends = new HashMap<>();
//	public int findCircleNum(int[][] M) {
//		parent = new int[M.length];
//		for(int i = 0;i<parent.length;i++)
//			parent[i] = i;
//		for(int i = 0;i<M.length;i++){
//			ArrayList<Integer> list = new ArrayList<>();
//			for(int j = 0;j<M[i].length;j++){
//				if(M[i][j]==1&&i!=j){
//					list.add(j);
//				}
//			}
//			friends.put(i,list);
//		}
//		for(int i = 0;i<M.length;i++){
//			ArrayList<Integer> list = friends.get(i);
//			for(int j = 0;j<list.size();j++){
//				int parentA = findparent(i);
//				int parentB = findparent(list.get(j));
//				if(parentA!=parentB){
//					parent[parentA] = parentB;
//				}
//			}
//		}
//		Set<Integer> ans = new HashSet<>();
//		for(int num:parent){
//			ans.add(findparent(num));
//		}
//
//		return ans.size();
//	}
//	public int findparent(int num){
//		if(num!=parent[num]){
//			parent[num] = findparent(parent[num]);
//		}
//		return parent[num];
//	}
	/**
	 * 这是DFS解法
	 */
	int[] parent;
	public int findCircleNum(int[][] M) {
		parent = new int[M.length];
		for(int i = 0;i<parent.length;i++)
			parent[i] = i;
		for(int i = 0;i<M.length;i++){
			for(int j = 0;j<M[i].length;j++){
				if(i!=j&&M[i][j]==1){
					parent[j] = i;
					dfs(j,i,M);
				}
			}
		}
		Set<Integer> set = new HashSet<>();
		for(int num:parent)
			set.add(num);
		return set.size();
	}

	private void dfs(int now, int father,int[][] M) {
		for(int i = 0;i<M[now].length;i++){
			if(M[now][i]==1&&parent[i]!=father){
				parent[i] = father;
				dfs(i,father,M);
			}
		}
	}
	public static void main(String[] args) {
		int[][] nums = {
				{1,0,0,0,1,0,1,0,0,0},
				{0,1,0,1,0,1,0,0,0,0},
				{0,0,1,0,0,1,0,0,0,0},
				{0,1,0,1,0,0,0,0,0,0},
				{1,0,0,0,1,0,0,0,1,0},
				{0,1,1,0,0,1,1,0,0,0},
				{1,0,0,0,0,1,1,0,1,0},
				{0,0,0,0,0,0,0,1,0,0},
				{0,0,0,0,1,0,1,0,1,0},
				{0,0,0,0,0,0,0,0,0,1}};
		binary_Search test = new binary_Search();
		System.out.println(test.findCircleNum(nums));
	}
}
