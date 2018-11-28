package com.km.WeeklyContest86;

import java.util.ArrayList;
import java.util.List;

public class Keys_and_Rooms {
	List<Integer> v;
	int[] vis;
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		v=new ArrayList<>();
		vis=new int[rooms.size()];
		List<Integer> zero=rooms.get(0);
		vis[0]=1;
		v.add(0);
		for(int i=0;i<zero.size();i++) {
			if(vis[zero.get(i)]==1)
				continue;
			vis[zero.get(i)]=1;
			v.add(zero.get(i));
			dfs(zero.get(i),rooms);
			if(v.size()==rooms.size())
				return true;
		}
		if(v.size()==rooms.size())
			return true;
		return false;
	}
	public void dfs(int now,List<List<Integer>> rooms) {
		List<Integer> list=rooms.get(now);
		for(int i=0;i<list.size();i++) {
			if(vis[list.get(i)]==1)
				continue;
			vis[list.get(i)]=1;
			v.add(list.get(i));
			dfs(list.get(i),rooms);
		}
	}
}
