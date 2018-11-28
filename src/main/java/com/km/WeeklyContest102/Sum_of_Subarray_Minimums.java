package com.km.WeeklyContest102;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Sum_of_Subarray_Minimums {
	public static int sumSubarrayMins(int[] A) {
		int[] left=new int[A.length];
		int[] right=new int[A.length];
		Stack<int[]> stack=new Stack<>();
		for(int i=0;i<A.length;i++) {
			int len=1;
			while(!stack.isEmpty()&&stack.peek()[0]>=A[i]) {
				len+=stack.pop()[1];
			}
			stack.push(new int[]{A[i], len});
			left[i]=len;
		}
		List<Integer> list=new ArrayList<>();
		for(int i=0;i<A.length;i++)
			list.add(A[i]);
		Collections.reverse(list);
		stack=new Stack<>();
		for(int i=0;i<A.length;i++) {
			int len=1;
			while(!stack.isEmpty()&&stack.peek()[0]>list.get(i)) {
				len+=stack.pop()[1];
			}
			stack.push(new int[]{list.get(i), len});
			right[A.length-i-1]=len;
		}
		int ans=0;
		for(int i=0;i<A.length;i++)
			ans=(ans+left[i]*right[i]*A[i])%1000000007;
		return ans;
	}
	public static void main(String[] args) {
		int[] A= {71,55,82,55};
		System.out.println(sumSubarrayMins(A));
	}
}
