package com.km.leetcode;

import java.util.*;

class Interval {
	int start;
	int end;
	
	Interval() {
		start = 0;
		end = 0;
	}
	
	Interval(int s, int e) {
		start = s;
		end = e;
	}
}
public class Employee_Free_Time {

	public static List<Interval> employeeFreeTime(List<List<Interval>> avails) {
		int min = Integer.MAX_VALUE;
		List<Interval> temp = avails.get(avails.size() - 1);
		int max=Integer.MIN_VALUE;
		for(int i=0;i<avails.size();i++) {
			int size=avails.get(i).size();
			max=Math.max(max, avails.get(i).get(size-1).end);
			min=Math.min(min,avails.get(i).get(0).start);
		}
		List<List<Interval>> freetime = new ArrayList<>();
		for (int i = 0; i < avails.size(); i++) {
			temp = avails.get(i);
			List<Interval> ft = new ArrayList<>();
			int start=avails.get(i).get(0).start;
			if(start!=min) {
				Interval s = new Interval(min, start);
				ft.add(s);
			}
			for (int j = 0; j < temp.size() - 1; j++) {
				int firststart = temp.get(j).start;
				int firstend = temp.get(j).end;
				int secondstart = temp.get(j + 1).start;
				int secondend = temp.get(j + 1).end;
				if (firstend != secondstart) {
					Interval s = new Interval(firstend, secondstart);
					ft.add(s);
				}
			}
			int end=temp.get(temp.size()-1).end;
			if(end!=max) {
				Interval s = new Interval(end, max);
				ft.add(s);
			}
			freetime.add(ft);
		}
		temp = new ArrayList<>(freetime.get(0));
		if(avails.size()==1)
			return temp;
		List<Interval> ans = new ArrayList<>();
		for (int i = 1; i < avails.size(); i++) {
			List<Interval> temp2 = freetime.get(i);
			for (int j = 0; j < temp.size(); j++) {
				int tempstart = temp.get(j).start;
				int tempend = temp.get(j).end;
				for (int k = 0; k < temp2.size(); k++) {
					int temp2start = temp2.get(k).start;
					int temp2end = temp2.get(k).end;
					if (tempend <= temp2start) {
						break;
					} else if (tempstart >= temp2end) {
						continue;
					} else {
						Interval interval = new Interval(Math.max(temp2start, tempstart), Math.min(tempend, temp2end));
						ans.add(interval);
					}
				}
			}
			temp.clear();
			temp.addAll(ans);
			if (i != avails.size() - 1) {
				ans.clear();
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		List<List<Interval>> list=new ArrayList<>();
		List<Interval> temp=new ArrayList<>();
		Interval i=new Interval(1,3);
		Interval j=new Interval(6,7);
		temp.add(i);temp.add(j);
		list.add(temp);
		
		List<Interval> temp2=new ArrayList<>();
		Interval i2=new Interval(2,4);
		temp2.add(i2);
		list.add(temp2);
		
		List<Interval> temp3=new ArrayList<>();
		Interval i3=new Interval(2,5);
		Interval j3=new Interval(9,12);
		temp3.add(i3);
		temp3.add(j3);
		list.add(temp3);
		
		System.out.println(employeeFreeTime(list).size());
	}
}
