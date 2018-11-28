package com.km.WeeklyContest94;

import java.util.*;

public class Walking_Robot_Simulation {
	static int Cur_line = 0;
	static int Cur_row = 0;
	static int Cur_dire = 1; // 目前朝向 1 2 3 4 分别为上右下左，开始为上
	static Map<Integer, Set<Integer>> map_line = new HashMap<>();
	static Map<Integer, Set<Integer>> map_row = new HashMap<>();

	public static int robotSim(int[] commands, int[][] obstacles) {
		for (int i = 0; i < obstacles.length; i++) {
			Set<Integer> set1;
			Set<Integer> set2;
			if (map_line.get(obstacles[i][1]) == null) {
				set1 = new TreeSet<>();
				set1.add(obstacles[i][0]);
				map_line.put(obstacles[i][1], set1);
			} else {
				set1 = map_line.get(obstacles[i][1]);
				set1.add(obstacles[i][0]);
				map_line.remove(obstacles[i][1]);
				map_line.put(obstacles[i][1], set1);
			}
			if (map_row.get(obstacles[i][0]) == null) {
				set2 = new TreeSet<>();
				set2.add(obstacles[i][1]);
				map_row.put(obstacles[i][0], set2);
			} else {
				set2 = map_row.get(obstacles[i][0]);
				set2.add(obstacles[i][1]);
				map_row.remove(obstacles[i][0]);
				map_row.put(obstacles[i][0], set2);
			}
		}
		for (int i = 0; i < commands.length; i++) {
			if (commands[i] == -1)
				Cur_dire = (Cur_dire + 1) % 4 == 0 ? 4 : (Cur_dire + 1) % 4;
			else if (commands[i] == -2)
				Cur_dire = (Cur_dire + 3) % 4 == 0 ? 4 : (Cur_dire + 3) % 4;
			else {
				move(commands[i]);
			}
		}
		int ans=Math.abs(Cur_line)*Math.abs(Cur_line)+Math.abs(Cur_row)*Math.abs(Cur_row);
		return ans;
	}

	public static void move(int dire) {
		boolean flag=false;
		int dire_line = 0;
		int dire_row=0;
		if (Cur_dire == 1) {
			dire_line = Cur_line + dire;
			Set<Integer> set = map_row.get(Cur_row);
			if(set==null) {
				Cur_line=dire_line;
				return;
			}
			Iterator it = set.iterator();
			while (it.hasNext()) {
				int obs = (int) it.next();
				if (obs > dire_line)
					break;
				else if (obs > Cur_line && obs <= dire_line) {
					flag=true;
					Cur_line = obs - 1;
					break;
				}
			}
			if(flag)
				return;
			else
				Cur_line=dire_line;
		}
		else if(Cur_dire == 2){
			dire_row=Cur_row+dire;
			Set<Integer> set = map_line.get(Cur_line);
			if(set==null) {
				Cur_row=dire_row;
				return;
			}
			Iterator it = set.iterator();
			while (it.hasNext()) {
				int obs = (int) it.next();
				if (obs > dire_row)
					break;
				else if (obs > Cur_row && obs <= dire_row) {
					flag=true;
					Cur_row = obs - 1;
					break;
				}
			}
			if(flag)
				return;
			else
				Cur_row=dire_row;
		}
		else if (Cur_dire == 3) {
			dire_line = Cur_line - dire;
			Set<Integer> set = map_row.get(Cur_row);
			if(set==null) {
				Cur_line=dire_line;
				return;
			}
			Iterator it = set.iterator();
			while (it.hasNext()) {
				int obs = (int) it.next();
				if (obs >Cur_line)
					break;
				else if (obs >= dire_line && obs < Cur_line) {
					flag=true;
					Cur_line = obs +1;
					break;
				}
			}
			if(flag)
				return;
			else
				Cur_line=dire_line;
		}
		else {
			dire_row=Cur_row-dire;
			Set<Integer> set = map_line.get(Cur_line);
			if(set==null) {
				Cur_row=dire_row;
				return;
			}
			Iterator it = set.iterator();
			while (it.hasNext()) {
				int obs = (int) it.next();
				if (obs > Cur_row)
					break;
				else if (obs >= dire_row && obs <Cur_row) {
					flag=true;
					Cur_row = obs + 1;
					break;
				}
			}
			if(flag)
				return;
			else
				Cur_row=dire_row;
		}
	}
	public static void main(String[] args) {
		int[] cm= {7,-2,-2,7,5};
		int[][] s={{-3,2},{-2,1},{0,1},{-2,4},{-1,0},{-2,-3},{0,-3},{4,4},{-3,-3},{2,2}};
		System.out.println(robotSim(cm,s));
	}
}
