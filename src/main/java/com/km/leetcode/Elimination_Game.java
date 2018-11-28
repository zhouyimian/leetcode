package com.km.leetcode;

public class Elimination_Game {
	public static int lastRemaining(int n) {
		if(n==1)
			return 1;
		int distanct=0;
		int time=0;
		int ans=1;
		while(n!=1) {
			if(distanct==0)
				distanct++;
			else
				distanct*=2;
			time++;
			if(time%2==1||(time%2==0&&n%2==1))
				ans+=distanct;
			n/=2;
		}
		return ans;
	}
	public static void main(String[] args) {
		System.out.println(lastRemaining(9));
	}
}
