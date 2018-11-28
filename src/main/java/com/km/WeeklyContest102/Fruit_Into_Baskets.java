package com.km.WeeklyContest102;

public class Fruit_Into_Baskets {
	public static int totalFruit(int[] tree) {
		int type=0;
		int j=0;
		int ans=0;
		int[] cnt=new int[tree.length];
		for(int i=0;i<tree.length;i++) {
			if(++cnt[tree[i]]==1) {
				type++;
			}
			while(type>2) {
				if(--cnt[tree[j++]]==0) {
					type--;
				}
			}
			ans=Math.max(ans, i-j+1);
		}
		return ans;
	}
	public static void main(String[] args) {
		int[] tree= {1,2,3,2,2};
		System.out.println(totalFruit(tree));
	}
}
