package com.km.leetcode;

import java.util.*;

public class Top_K_Frequent_Elements {
	public static List<Integer> topKFrequent(int[] nums, int k) {
		Map<Integer,Integer> map=new HashMap<>();
		for(int i=0;i<nums.length;i++)
			map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
		Set set=map.keySet();
		Iterator it=set.iterator();
		int[][] val=new int[set.size()][2];
		int num=0;
		while(it.hasNext()) {
			int key=(int) it.next();
			int value=map.get(key);
			val[num][0]=value;
			val[num][1]=key;
			num++;
		}
		List<Integer> ans=new ArrayList<>();
		for(int i=0;i<num;i++) {
			for(int j=i+1;j<num;j++) {
				if(val[i][0]<val[j][0]) {
					int temp=val[i][0];val[i][0]=val[j][0];val[j][0]=temp;
					temp=val[i][1];val[i][1]=val[j][1];val[j][1]=temp;
				}
			}
		}
		int time=0;
		int now=0;
		while(true) {
			if(now>=num)
				break;
			if(now!=k) {
				time=val[now][0];
				ans.add(val[now][1]);
				now++;
			}
			else {
				if(val[now][0]==time) {
					ans.add(val[now][1]);
					now++;
				}
				else
					break;
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		int[] s= {1};
		List<Integer> list=topKFrequent(s,1);
		for(int i:list) {
			System.out.println(i);
		}
	}
}
