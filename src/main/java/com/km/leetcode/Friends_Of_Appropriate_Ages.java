package com.km.leetcode;

import java.util.Arrays;

public class Friends_Of_Appropriate_Ages {
	public static int numFriendRequests(int[] ages) {
		int ans = 0;
		int[] count=new int[121];
		for(int i=0;i<ages.length;i++)
			count[ages[i]]++;
		for(int i=15;i<121;i++)
			if(count[i]>=2)
				ans+=(count[i]*(count[i]-1));
		for(int i=0;i<121;i++) {
			for(int j=0;j<121;j++) {
				if(j>i||j<=0.5*i+7||(j>100&&i<100)||count[i]==0||count[j]==0||i==j)
					continue;
				else {
					ans+=count[i]*count[j];
				}
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		int[] test= {16,16};
		System.out.println(numFriendRequests(test));
	}
}
