package com.km.leetcode;

public class Beautiful_Arrangement {
	int ans=0;
	int[] vis;
	int num;
	public int countArrangement(int N) {
		vis=new int[N+1];
		num=N;
		for(int i=1;i<=N;i++) {
			vis[i]=1;
			dfs(2);
			vis[i]=0;
		}
		return ans;
	}
	void dfs(int count) {
		if(count==num+1) {
			ans++;
			return ;
		}
		for(int i=1;i<=num;i++) {
			if(vis[i]==0&&(i%count==0||count%i==0)) {
				vis[i]=1;
				dfs(count+1);
				vis[i]=0;
			}
		}
	}
}
