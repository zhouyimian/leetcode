package com.km.WeeklyContest68;

public class Max_Chunks_To_Make_Sorted_ver_ {
	public static int maxChunksToSorted(int[] arr) {
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
		if(start==end) {
			if(arr[start]==start)
				return true;
			return false;
		}
		else {
			int max=arr[start];
			int min=arr[start];
			for(int i=start;i<=end;i++) {
				if(arr[i]>max)
					max=arr[i];
				if(arr[i]<min)
					min=arr[i];
			}
			if(start==min&&end==max)
				return true;
			else
				return false;
		}
	}
	public static void main(String[] args) {
		int[] n= {2,0,1,3,4};
		System.out.println(maxChunksToSorted(n));
	}
}
