package com.km.leetcode;

public class Maximum_Length_of_Pair_Chain {
	public static int findLongestChain(int[][] pairs) {
		int[] vis=new int[pairs.length];
		for(int i=0;i<pairs.length;i++) {
			if(vis[i]==1)
				continue;
			for(int j=i+1;j<pairs.length;j++) {
				if(pairs[i][0]<=pairs[j][0]&&pairs[i][1]>=pairs[j][1]) {
					vis[i]=1;
					break;
				}
				else if(pairs[j][0]<=pairs[i][0]&&pairs[j][1]>=pairs[i][1])
					vis[j]=1;
					
			}
		}
		int len=0;
		int[][] temp=new int[vis.length][2];
		for(int i=0;i<vis.length;i++) {
			if(vis[i]==0) {
				temp[len][0]=pairs[i][0];
				temp[len][1]=pairs[i][1];
				len++;
			}
		}
		for(int i=0;i<len;i++) {
			for(int j=i+1;j<len;j++) {
				if(temp[j][1]<temp[i][1]) {
					int t=temp[j][0];temp[j][0]=temp[i][0];temp[i][0]=t;
					t=temp[j][1];temp[j][1]=temp[i][1];temp[i][1]=t;
				}
			}
		}
		int left=temp[0][0];
		int right=temp[0][1];
		int length=1;
		int maxlength=1;
		for(int i=0;i<len;i++) {
			for(int j=i+1;j<len;j++) {
				if(temp[j][0]>right) {
					length++;
					right=temp[j][1];
				}
			}
			if(length>maxlength)
				maxlength=length;
			length=0;
		}
		return maxlength;
	}
	public static void main(String[] args) {
		int[][] s= {{1,2}, {2,3}, {3,4}};
		System.out.println(findLongestChain(s));
	}
}
