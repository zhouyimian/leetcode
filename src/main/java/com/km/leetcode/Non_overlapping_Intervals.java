package com.km.leetcode;



public class Non_overlapping_Intervals {
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
	public int eraseOverlapIntervals(Interval[] intervals) {
		for(int i=0;i<intervals.length;i++) {
			for(int j=0;j<intervals.length-1;j++) {
				if(intervals[j].end>intervals[j+1].end) {
					exchange(intervals,j,j+1);
				}
				else if(intervals[j].end==intervals[j+1].end) {
					if(intervals[j].start<intervals[j+1].start) {
						exchange(intervals,j,j+1);
					}
				}
			}
		}
		if(intervals.length==0||intervals.length==1)
			return 0;
		int ans=0;
		int now=0;
		for(int i=1;i<intervals.length;i++) {
			if(intervals[i].start>=intervals[now].end) {
				now=i;
				continue;
			}
			else
				ans++;
		}
		return ans;
	}
	public void exchange(Interval[] intervals, int i, int j) {
		int temp;
		temp=intervals[i].start;intervals[i].start=intervals[j].start;intervals[j].start=temp;
		temp=intervals[i].end;intervals[i].end=intervals[j].end;intervals[j].end=temp;
	}
	
}
