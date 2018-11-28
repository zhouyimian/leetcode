package com.km.WeeklyContest91;

public class Lemonade_Change {
	public static boolean lemonadeChange(int[] bills) {
		int[] num=new int[3];
		for(int i=0;i<bills.length;i++) {
			if(bills[i]==5) {
				num[0]++;
			}
			else if(bills[i]==10){
				if(num[0]==0)
					return false;
				else {
					num[0]--;
					num[1]++;
				}
			}
			else {
				if(num[0]==0)
					return false;
				if(num[1]>=1&&num[0]>=1) {
					num[1]--;
					num[0]--;
					num[2]++;
				}
				else if(num[0]<3)
					return false;
				else {
					num[0]-=3;
					num[2]++;
				}
			}
		}
		return true;
	}
	public static void main(String[] args) {
		int[] n= {5,5,5,10,5,5,10,20,20,20};
		System.out.println(lemonadeChange(n));
	}
}
