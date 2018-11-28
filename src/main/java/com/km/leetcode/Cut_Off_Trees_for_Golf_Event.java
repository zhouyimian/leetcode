package com.km.leetcode;

import java.util.*;

class point{
	int x;
	int y;
	int value;
	public point(int x,int y,int value) {this.x=x;this.y=y;this.value=value;}
}
public class Cut_Off_Trees_for_Golf_Event {
	static int[][] map;
	static int[][] vis;
	public static int cutOffTree(List<List<Integer>> forest) {
		if(forest.size()==0||forest.get(0).size()==0)
			return 0;
		int ans=0;
		int count=0;
		map=new int[forest.size()][forest.get(0).size()];
		vis=new int[forest.size()][forest.get(0).size()];
		for(int i=0;i<forest.size();i++) {
			for(int j=0;j<forest.get(i).size();j++) {
				map[i][j]=forest.get(i).get(j);
				if(map[i][j]<map[0][0]&&i!=0&&j!=0&&map[i][j]!=0)
					return -1;
			}
		}
		if(map[0][0]==0)
            return -1;
		point now=new point(0,0,map[0][0]);
		List<point> list=new ArrayList<>();
		vis[0][0]=1;
		map[0][0]=1;
		int x=1,y=0;
		
		x=0;y=1;
		while(!list.isEmpty()) {
			int temp_index=-1;
			for(int i=0;i<list.size();i++) {
				if(list.get(i).value>=now.value&&temp_index==-1) {
					temp_index=i;
				}
				else if(temp_index!=-1&&list.get(i).value<list.get(temp_index).value&&list.get(i).value>now.value) {
					temp_index=i;
				}
			}
			if(temp_index==-1) {
				break;
			}
			else {
				count++;
				ans+=BFS(list.get(temp_index),now);
				now=list.get(temp_index);
				map[now.x][now.y]=1;
				list.remove(temp_index);
				add_point(now,list);
			}	
		}
		int t=0;
		for(int i=0;i<forest.size();i++) {
			for(int j=0;j<forest.get(i).size();j++) {
				if(forest.get(i).get(j)!=0)
					t++;	
			}
		}
		return count==t?ans:-1;
	} 
	static void add_point(point index,List<point>list) {
		int[][] dire= {{-1,0},{0,-1},{0,1},{1,0}};
		for(int i=0;i<4;i++) {
			int x=index.x+dire[i][0];
			int y=index.y+dire[i][1];
			if(x<0||y<0||x>=map.length||y>=map[0].length||vis[x][y]==1||map[x][y]==0)
				continue;
			else {
				vis[x][y]=1;
				list.add(new point(x,y,map[x][y]));
			}
		}
	}
	static int BFS(point temp,point now) {
		if(temp.x==now.x&&temp.y==now.y)
			return 0;
		int num=1;
		Queue<point> queue=new ArrayDeque<>();
		queue.add(now);
		while (!queue.isEmpty()) {
			for (int i = 0; i < queue.size(); i++) {
				point p = queue.poll();
				int[][] dire = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };
				for (int j = 0; j < 4; j++) {
					int x = p.x + dire[j][0];
					int y = p.y + dire[j][1];
					if(x==temp.x&&y==temp.y)
						return num;
					else if (x < 0 || y < 0 || x >= map.length || y >= map[0].length || map[x][y] != 1)
						continue;
					else {
						queue.add(new point(x, y, map[x][y]));
					}
				}
			}
			num++;
		}
		return num;
	}
	public static void main(String[] args) {
		List<List<Integer>> list = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			list.add(new ArrayList<Integer>());
		}
		list.get(0).add(1);
		list.get(0).add(2);
		list.get(0).add(3);
		list.get(1).add(4);
		list.get(1).add(5);
		list.get(1).add(6);
		list.get(2).add(7);
		list.get(2).add(8);
		list.get(2).add(9);
		System.out.println(cutOffTree(list));
	}

}
