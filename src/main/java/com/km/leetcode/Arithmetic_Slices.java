package com.km.leetcode;

public class Arithmetic_Slices {
	public int numberOfArithmeticSlices(int[] A) {
		if(A.length<=2)
			return 0;
		int len=2;
		int ans=0;
		for(int i=2;i<A.length;i++) {
			if(A[i]-A[i-1]==A[i-1]-A[i-2]) {
				len++;
			}
			else {
				ans+=cal(len);
				len=2;
			}
		}
		ans+=cal(len);
		return ans;
	}
	int cal(int num) {
		if(num==2)
			return 0;
		else
			return (num-1)*(num-2)/2;
	}
}
