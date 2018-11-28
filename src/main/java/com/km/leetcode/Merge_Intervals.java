package com.km.leetcode;

import java.util.ArrayList;
import java.util.List;

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

public class Merge_Intervals {
	public static List<Interval> merge(List<Interval> intervals) {
		List<Interval> ans = new ArrayList<>();
		if (intervals == null || intervals.size() <= 1)
			return intervals;
		for(int i=0;i<intervals.size();i++) {
			for(int j=0;j<intervals.size();j++) {
				if(intervals.get(i).start<intervals.get(j).start) {
					int temp=intervals.get(i).start;intervals.get(i).start=intervals.get(j).start;intervals.get(j).start=temp;
					temp=intervals.get(i).end;intervals.get(i).end=intervals.get(j).end;intervals.get(j).end=temp;
				}
				else if(intervals.get(i).start==intervals.get(j).start) {
					if(intervals.get(i).end>=intervals.get(j).end) {
						int temp=intervals.get(i).start;intervals.get(i).start=intervals.get(j).start;intervals.get(j).start=temp;
						temp=intervals.get(i).end;intervals.get(i).end=intervals.get(j).end;intervals.get(j).end=temp;
					}
				}
			}
		}
		Interval start = intervals.get(0);
		Interval next = intervals.get(1);
		int index = 2;
		if (intervals.size() > 2) {
			while (index < intervals.size()) {
				if (next.end <= start.end) {
					next = intervals.get(index);
				} else if (next.start <= start.end) {
					start.end = next.end;
					next = intervals.get(index);
				} else {
					Interval inter = new Interval();
					inter.start = start.start;
					inter.end = start.end;
					ans.add(inter);
					start.start = next.start;
					start.end = next.end;
					next = intervals.get(index);
				}
				index++;
			}
		}
		if(next.start>=start.start&&next.start<=start.end) {
			start.end=start.end>next.end?start.end:next.end;
			ans.add(start);
		}
		else {
			ans.add(start);
			ans.add(next);
		}
		return ans;
	}

	public static void main(String[] args) {
		List<Interval> list = new ArrayList<>();
		Interval i1 = new Interval();
		i1.start = 1;
		i1.end = 4;
		list.add(i1);
		Interval i2 = new Interval();
		i2.start = 0;
		i2.end = 2;
		list.add(i2);
		 Interval i3=new Interval();
		 i3.start=3;i3.end=5;
		 list.add(i3);
//		 Interval i4=new Interval();
//		 i4.start=15;i4.end=18;
//		 list.add(i4);
		for (Interval i : merge(list)) {
			System.out.println(i.start + "  " + i.end);
		}
	}
}
