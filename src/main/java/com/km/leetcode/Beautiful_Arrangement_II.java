package com.km.leetcode;

public class Beautiful_Arrangement_II {

	public static void main(String[] args) {
		int n=10,k=3;
		int[] ans=new int[n];
		int count=0;
		if(k==1) {
			for(int i=1;i<=n;i++)
				ans[count++]=i;
		}
		else if(n-1==k) {
			int i=1,j=n;
			while(count!=n) {
				ans[count++]=j--;
				if(count!=n)
					ans[count++]=i++;
				else
					break;
			}
		}
		else {
			int i=1,j=n;
			while(count!=k) {
				ans[count++]=j--;
				if(count!=k)
					ans[count++]=i++;
				else
					break;
			}
			if (k % 2 == 1) {
				for (int an = count; an < n; an++) {
					ans[an] = j--;
				}
			}
			else {
				for (int an = count; an < n; an++) {
					ans[an] = i++;
				}
			}
		}
		for(int i=0;i<ans.length;i++)
			System.out.print(ans[i]);

	}

}
