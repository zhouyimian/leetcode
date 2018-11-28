package com.km.WeeklyContest103;

import java.util.Arrays;

public class Smallest_Range_I {
	public int smallestRangeI(int[] A, int K) {
		int ans=0;
		Arrays.sort(A);
		int temp=A[A.length-1]-A[0];
		return temp-2*K<=0?0:temp-2*K;
	}
}
