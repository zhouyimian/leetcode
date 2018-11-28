package com.km.WeeklyContest89;

public class Peak_Index_in_a_Mountain_Array {

	public int peakIndexInMountainArray(int[] A) {
		boolean flag=true;
		for(int i=1;i<A.length-1;i++) {
			if(A[i]>A[i+1])
				return i;
		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
