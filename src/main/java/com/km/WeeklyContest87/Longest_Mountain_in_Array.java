package com.km.WeeklyContest87;

public class Longest_Mountain_in_Array {
	public int longestMountain(int[] A) {
		if(A.length<=2)
			return 0;
		int[] increase=new int[A.length];
		int[] decrease=new int[A.length];
		increase[0]=1;
		decrease[A.length-1]=1;
		for(int i=1;i<A.length;i++) {
			if(A[i]>A[i-1])
				increase[i]=increase[i-1]+1;
			else
				increase[i]=1;
		}
		for(int i=A.length-2;i>=0;i--) {
			if(A[i]>A[i+1])
				decrease[i]=decrease[i+1]+1;
			else
				decrease[i]=1;
		}
		int max=0;
		for(int i=0;i<A.length;i++) {
			if(increase[i]>1&&decrease[i]>1&&(increase[i]+decrease[i]-1>max)) {
				max=increase[i]+decrease[i]-1;
			}
		}
		
		return max;
	}
}
