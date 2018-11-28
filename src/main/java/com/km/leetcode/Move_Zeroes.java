package com.km.leetcode;

public class Move_Zeroes {

	public static void main(String[] args) {
		int index=0;
		int num[]= {0,1,0,3,0,12};
		for(int i=0;i<num.length;i++) {
			if(num[i]!=0) {
				num[index]=num[i];
				if(i!=index)
					num[i]=0;
				index++;
			}
		}
		for(int i=0;i<num.length;i++) {
			System.out.println(num[i]);
		}
	}

}
