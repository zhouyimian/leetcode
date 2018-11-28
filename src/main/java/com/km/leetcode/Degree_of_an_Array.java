package com.km.leetcode;

import java.util.*;

public class Degree_of_an_Array {
	class degree{
		int start;
		int end;
		int time;
		public int getStart() {
			return start;
		}
		public void setStart(int start) {
			this.start = start;
		}
		public int getEnd() {
			return end;
		}
		public void setEnd(int end) {
			this.end = end;
		}
		public int getTime() {
			return time;
		}
		public void setTime(int time) {
			this.time = time;
		}
		
	}
	public int findShortestSubArray(int[] nums) {
		Map<Integer,degree> map=new HashMap<>();
		int maxtime = 0;
		int minstart = 0,minend = 0;
		for(int i=0;i<nums.length;i++) {
			degree temp=new degree();
			if(map.containsKey(nums[i])) {
				temp=map.get(nums[i]);
				temp.setEnd(i);
				temp.setTime(temp.getTime()+1);
				if(temp.getTime()==maxtime&&((temp.getEnd()-temp.getStart())<(minend-minstart))){
					maxtime=temp.getTime();
					minstart=temp.getStart();
					minend=temp.getEnd();
				}
				else if(temp.getTime()>maxtime) {
					maxtime=temp.getTime();
					minstart=temp.getStart();
					minend=temp.getEnd();
				}
				map.put(nums[i], map.get(nums[i]));
			}
			else {
				temp.setStart(i);
				temp.setEnd(i);
				temp.setTime(1);
				map.put(nums[i], temp);
			}
		}
		return (minend-minstart+1);
	}
}
