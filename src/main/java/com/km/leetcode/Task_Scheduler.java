package com.km.leetcode;

import java.util.Arrays;

public class Task_Scheduler {
	public int leastInterval(char[] tasks, int n) {
		int[] times=new int[26];
		for(char c:tasks) {
			times[c-'A']++;
		}
		Arrays.sort(times);
		int maxcount=1;
		for(int i=24;i>=0;i--) {
			if(times[i]==times[25])
				maxcount++;
			else
				break;
		}
		return Math.max(tasks.length, (n+1)*(times[25]-1)+maxcount);
	}
}
