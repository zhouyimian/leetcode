package com.km.leetcode;

import java.util.*;

public class Binary_Watch {
	static int[] nums= {60,120,240,480,1,2,4,8,16,32};
	static int[] vis=new int[10];
	static Set<String> temp=new TreeSet<>();
	public static List<String> readBinaryWatch(int num) {
		dfs(0,num);
		List<String> ans=new ArrayList<>();
		ans.addAll(temp);
		return ans;
	}
	static void dfs(int time,int num) {
		if(num==0) {
			if((vis[9]==1&&vis[8]==1&&vis[7]==1&&vis[6]==1)||time/60>=12)
				return;
			StringBuilder sb=new StringBuilder();
			sb.append(time/60+":");
			if(time%60<10)
				sb.append("0"+time%60);
			else
				sb.append(time%60);
			temp.add(new String(sb));
		}
		else {
			for(int i=0;i<10;i++) {
				if(vis[i]==0) {
					vis[i]=1;
					dfs(time+nums[i],num-1);
					vis[i]=0;
				}
			}
		}
	}
	public static void main(String[] args) {
		List<String> list=readBinaryWatch(2);
		for(String s:list) {
			System.out.println(s);
		}
	}
}
