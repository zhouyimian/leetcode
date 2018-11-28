package com.km.leetcode;

public class Max_Consecutive_Ones {

	public static void main(String[] args) {
		int[] a= {1};
		int max=0;
		int count=0;
		for(int i=0;i<a.length;i++) {
			if(a[i]==1)
				count++;
			else{
				if(count>max)
					max=count;
				count=0;
			}	
		}
//		if(count>max)
//			max=count;
		System.out.println(max);
	}

}
