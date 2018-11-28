package com.km.leetcode;

public class Queue_Reconstruction_by_Height {
	public int[][] reconstructQueue(int[][] people) {
		for(int i=0;i<people.length;i++) {
			for(int j=i+1;j<people.length;j++) {
				if(people[i][0]<people[j][0]) {
					exchange(people,i,j);
				}
				else if(people[i][0]==people[j][0]) {
					if(people[i][1]>people[j][1]) {
						exchange(people,i,j);
					}
				}
			}
		}
		
		int[][] ans=new int[people.length][2];
		for(int i=0;i<people.length;i++) {
			if(ans[people[i][1]][0]==0) {
				ans[people[i][1]][0]=people[i][0];
				ans[people[i][1]][1]=people[i][1];
			}
			else {
				for(int j=people.length-2;j>=people[i][1];j--) {
					exchange(ans,j,j+1);
				}
				ans[people[i][1]][0]=people[i][0];
				ans[people[i][1]][1]=people[i][1];
			}
		}
		return ans;
	}
	void exchange(int[][] people,int i,int j) {
		int temp=people[i][0];people[i][0]=people[j][0];people[j][0]=temp;
		temp=people[i][1];people[i][1]=people[j][1];people[j][1]=temp;
	}
}
