package com.km.WeeklyContest112;

import java.util.Arrays;

public class Minimum_Increment_to_Make_Array_Unique {
	public static int minIncrementForUnique(int[] A) {
		int ans = 0;
		if(A.length==0)
			return 0;
		Arrays.sort(A);
		int index = 0;
		int[] sum=new int[A.length];
		sum[0]=A[0];
		for(int i=1;i<A.length;i++)
			sum[i]=sum[i-1]+A[i];
		while (true) {
			int first=index;
			while (index < A.length - 1 && (A[index] == A[index + 1] || A[index] + 1 == A[index + 1]||A[first]+(index-first)>=A[index+1]))
				index++;
			ans+=((A[first]+(A[first]+index-first))*(index-first+1)/2)-(sum[index]-sum[first]+A[first]);
			if(index>=A.length-1)
				break;
			index++;
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] nums= {3,2,1,2,1,7};
		System.out.println(minIncrementForUnique(nums));
	}

}
