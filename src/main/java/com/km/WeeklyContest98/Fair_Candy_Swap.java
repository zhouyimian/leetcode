package com.km.WeeklyContest98;

import java.util.HashSet;
import java.util.Set;

public class Fair_Candy_Swap {
	public int[] fairCandySwap(int[] A, int[] B) {
		int[] ans=new int[2];
		int sumA=0,sumB=0;
		Set<Integer> set=new HashSet<>();
		for(int i=0;i<A.length;i++)
			sumA+=A[i];
		for(int i=0;i<B.length;i++) {
			sumB+=B[i];
			set.add(B[i]);
		}
		int average=(sumA+sumB)>>1;
		for(int i=0;i<A.length;i++) {
			int targe=average-sumA+A[i];
			if(set.contains(targe)) {
				ans[0]=A[i];
				ans[1]=targe;
				return ans;
			}
		}
		return ans;
	}
}
