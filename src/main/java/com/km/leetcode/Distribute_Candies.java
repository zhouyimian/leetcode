package com.km.leetcode;

import java.util.*;

public class Distribute_Candies {
	public int distributeCandies(int[] candies) {
		int ans=0;
		int[] temp=new int[200010];
		for(int i=0;i<candies.length;i++) {
			if(temp[candies[i]+100000]==0) {
				ans++;
				if(ans>=candies.length/2)
					return candies.length/2;
				temp[candies[i]+100000]++;
			}
			else {
				continue;
			}
		}
		
		return ans;
	}
}
