package com.km.leetcode;

public class Poor_Pigs {
	public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
		if(buckets==1)
			return 0;
		int len=minutesToTest/minutesToDie+1;
		int ans=0;
		int sum=1;
		while(sum<buckets) {
			ans++;
			sum*=len;
		}
		return ans;
	}
}
