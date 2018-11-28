package com.km.WeeklyContest68;

import java.util.Arrays;

public class Max_Chunks_to_Make_Sorted_2 {
	static int[] temp;
	public static int maxChunksToSorted(int[] arr) {
		temp=arr.clone();
		Arrays.sort(temp);
		int ans=0;
		for(int i=0;i<arr.length;i++) {
			for(int j=i;j<arr.length;j++) {
				if(check(arr,i,j)) {
					i=j;
					ans++;
					break;
				}
			}
		}
		return ans;
	}
	static boolean check(int[] arr,int start,int end) {
		int[] s=new int[end-start+1];
		for(int i=0;i<s.length;i++) {
			s[i]=arr[i+start];
		}
		Arrays.sort(s);
		for(int i=start;i<=end;i++) {
			if(s[i-start]!=temp[i])
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		int[] num= {5,4,3,2,1};
		System.out.println(maxChunksToSorted(num));
	}
}
