package com.km.WeeklyContest94;

public class Koko_Eating_Bananas {
	public static int minEatingSpeed(int[] piles, int H) {
		int max = 0;
		int ans=0;
		for (int i = 0; i < piles.length; i++) {
			if (piles[i] > max)
				max = piles[i];
		}
		if (H == piles.length)
			return max;
		else {
			int low = 1;
			int high = max;
			int mid = (low + high) / 2;
			while (low < high) {
				if (ok(mid,piles,H)) {
					ans=mid;
					high=mid-1;
					mid = (low + high) / 2;
				}else {
					low=mid+1;
					mid = (low + high) / 2;
				}
			}
		}
		return ans;
	}

	public static boolean ok(int speed,int[]piles,int time) {
		int cost=0;
		for(int i=0;i<piles.length;i++) {
			if(piles[i]%speed==0)
				cost+=piles[i]/speed;
			else
				cost=(cost+piles[i]/speed+1);
		}
		if(cost<=time)
			return true;
		else 
			return false;
	}
	public static void main(String[] args) {
		int[] time= {30,11,23,4,20};
		int H=6;
		System.out.println(minEatingSpeed(time,H));
	}
}
