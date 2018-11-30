package com.km.leetcode;

public class Best_Time_to_Buy_and_Sell_Stock_III {
	int[] min;
	int[] max;
	public int maxProfit(int[] prices) {
		if(prices.length<=1)
			return 0;
		min=new int[prices.length];
		max=new int[prices.length];
		min[0]=prices[0];
		int ans=0;
		max[prices.length-1]=prices[prices.length-1];
		for(int i=1;i<prices.length;i++) {
			if(prices[i]<min[i-1])
				min[i]=prices[i];
			else
				min[i]=min[i-1];
		}
		for(int i=prices.length-2;i>=0;i--) {
			if(prices[i]>max[i+1])
				max[i]=prices[i];
			else
				max[i]=max[i+1];
		}
		for(int i=0;i<prices.length;i++) {
			ans=Math.max(ans, find(0,i-1,prices)+find(i,prices.length-1,prices));
		}
		return ans;
    }

	public int find(int start, int end,int[] prices) {
		if(start>=end)
			return 0;
		return 0;

	}
}
