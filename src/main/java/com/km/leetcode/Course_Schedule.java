package com.km.leetcode;

import java.util.*;

public class Course_Schedule {
	/*List<List<Integer>> list;
	int[] vis;
	boolean flag=true;
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		list=new ArrayList<>();
		for(int i=0;i<numCourses;i++) {
			List<Integer> temp=new ArrayList<>();
			list.add(temp);
		}
		vis=new int[numCourses];
		for(int i=0;i<numCourses;i++)
			vis[i]=-1;
		for(int i=0;i<prerequisites.length;i++) {
			list.get(prerequisites[i][0]).add(prerequisites[i][1]);
		}
		for (int i = 0; i < numCourses; i++) {
			dfs(i);
			if(!flag)
				return false;
			for(int j=0;j<numCourses;j++)
				vis[j]=-1;
		}
		return flag;
	}
	void dfs(int start) {
		if(flag==false)
			return;
		vis[start]=0;
		Iterator it = list.get(start).iterator();
		while (it.hasNext()) {
			int num = (int) it.next();
			if (vis[num]==0) {
				flag=false;
			}
			else if(vis[num]==-1){
				dfs(num);
			}
		}
		vis[start]=1;
		new StringBuffer("sdsd").reverse()
	}*/
	public int[] intersection(int[] nums1, int[] nums2) {
		List<Integer> list = new ArrayList<>();
		if (nums1.length < nums2.length) {
			for (int i = 0; i < nums1.length; i++) {
				for (int j = 0; j < nums2.length; j++) {
					if (nums1[i] == nums2[j]) {
						list.add(nums1[i]);
						break;
					}
				}
			}
			int[] ans = new int[list.size()];
			int count = 0;
			Iterator it = list.iterator();
			while (it.hasNext()) {
				ans[count++] = (int) it.next();
			}
			return ans;
		}
		else {
			for (int i = 0; i < nums2.length; i++) {
				for (int j = 0; j < nums1.length; j++) {
					if (nums2[i] == nums1[j]) {
						list.add(nums1[j]);
						break;
					}
				}
			}
			int[] ans = new int[list.size()];
			int count = 0;
			Iterator it = list.iterator();
			while (it.hasNext()) {
				ans[count++] = (int) it.next();
			}
			return ans;
		}
        
    }
}
