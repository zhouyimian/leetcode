package com.km.leetcode;

public class Reach_a_Number {
	public int reachNumber(int target) {
		int n=1;
		target=Math.abs(target);
		while(true) {
			if((1+n)*n/2>=target)
				break;
			n++;
		}
		if(target==(1+n)*n/2)
			return n;
		n--;
		n+=(target-(1+n)*n/2)*2;
		return n;
	}
}
