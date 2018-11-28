package com.km.WeeklyContest103;

import java.util.Arrays;

public class Smallest_Range_II {
	public static int smallestRangeII(int[] A, int K) {
		Arrays.sort(A);
		int min=A[0];
		int len=A.length;
		int max=A[len-1];
		int ans=max-min;
		for(int i=0;i<len-1;i++){
			max=Math.max(A[i]+2*K,max);
			min=Math.min(A[0]+2*K,A[i+1]);
			ans=Math.min(ans,max-min);
		}
		return ans;
	}
	public static void main(String[] args) {
		int[] A= {1,3,6};
		System.out.println(smallestRangeII(A,3));
	}
}
