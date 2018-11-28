package com.km.leetcode;

public class Binary_Subarrays_With_Sum {
	public int numSubarraysWithSum(int[] A, int S) {
		int ans = 0;
		int[] counts = new int[A.length];
		int[] next_1 = new int[A.length];
		next_1[A.length-1]=-1;
		counts[0] = A[0] == 0 ? 0 : 1;
		for (int i = 1; i < A.length; i++)
			counts[i] = A[i] == 0 ? counts[i - 1] : counts[i - 1] + 1;
		for(int i=A.length-2;i>=0;i--)
			next_1[i]=A[i+1]==1?i+1:next_1[i+1];
		int first = 0, second = 0;
		while (first <= second && second < A.length) {
			if (S == 0) {
				while (first < A.length && A[first] != 0)
					first++;
				second = first + 1;
				while (second < A.length && A[second] == 0)
					second++;
				second--;
				if (first == second)
					ans++;
				else
					ans += Math.pow(2, (second - first)) - 1;
				first = second + 1;
				second = first + 1;
			} else {
				if (counts[second] - counts[first] + A[first] == S) {
					int len_second=next_1[second]-second;
					int len_first=next_1[first]-first;
					if(A[first]==0&&A[second]==0) {
						
					}
					else {
						
					}
				} else if (counts[second] - counts[first] + A[first] < S)
					second++;
				else
					first++;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		Binary_Subarrays_With_Sum test = new Binary_Subarrays_With_Sum();
		int[] nums = { 1, 0, 1, 0, 1 };
		System.out.println(test.numSubarraysWithSum(nums, 2));
	}

}
