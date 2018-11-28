package com.km.WeeklyContest112;

import java.util.Arrays;

public class Bag_of_Tokens {
	public static int bagOfTokensScore(int[] tokens, int P) {
		int ans=1;
		int get=0;
		Arrays.sort(tokens);
		if(tokens.length==0||P<tokens[0])
			return 0;
		if(tokens.length==1)
			return 1;
		int first=0;
		int last=tokens.length-1;
		int[] sum=new int[tokens.length];
		sum[0]=tokens[0];
		for(int i=1;i<tokens.length;i++)
			sum[i]=sum[i-1]+tokens[i];
		while(first<last) {
			P-=tokens[first];
			P+=tokens[last];
			for(int i=first+1;i<=last;i++) {
				for(int j=i+1;j<=last;j++) {
					if(P>=sum[j]-sum[i]+tokens[i])
						ans=Math.max(ans, j-i+1);
					else
						break;
				}
			}
			first++;
			last--;
		}
		return ans;
	}

	public static void main(String[] args) {
		int[]nums= {100,200};
		System.out.println(bagOfTokensScore(nums,150));

	}

}
