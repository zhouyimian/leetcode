package com.km.WeeklyContest94;

import java.util.HashSet;
import java.util.Set;

public class Length_of_Longest_Fibonacci_Subsequence {
	public int lenLongestFibSubseq(int[] A) {
		Set<Integer> set=new HashSet<>();
		int max=0;
		for(int i=0;i<A.length;i++)
			set.add(A[i]);
		for(int i= 0;i<A.length;i++) {
			for(int j=i+1;j<A.length;j++) {
				int one=A[i];
				int two=A[j];
				int three=one+two;
				int len=2;
				while(set.contains(three)) {
					one=two;
					two=three;
					three=one+two;
					len++;
				}
				if(len>max&&len>=3)
					max=len;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		

	}

}
