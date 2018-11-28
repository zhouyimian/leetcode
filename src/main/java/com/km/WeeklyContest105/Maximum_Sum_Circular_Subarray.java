package com.km.WeeklyContest105;

public class Maximum_Sum_Circular_Subarray {
	public int maxSubarraySumCircular(int[] A) {
		int temp_max=0;
		int ans=A[0];
		for(int i=0;i<A.length;i++) {
			temp_max+=A[i];
			if(temp_max>=ans)
				ans=temp_max;
			if(temp_max<=0)
				temp_max=0;
		}
		int temp_min=0;
		int min=Integer.MIN_VALUE;
		for(int i=0;i<A.length;i++) {
			A[i]=-A[i];
		}
		for(int i=0;i<A.length;i++) {
			temp_min+=A[i];
			if(temp_min>=min)
				min=temp_min;
			if(temp_min<=0)
				temp_min=0;
		}
		int sum=0;
		for(int n:A)
			sum+=-n;
		if(sum+min>=ans&&sum+min!=0)
			return sum+min;
		return ans;
	}
	public static void main(String[] args) {
		Maximum_Sum_Circular_Subarray c=new Maximum_Sum_Circular_Subarray();
		int[] nums= {5,-1,5};
		System.out.println(c.maxSubarraySumCircular(nums));
		
	}
}
