package com.km.leetcode;

public class Plus_One {
	public static int[] plusOne(int[] digits) {
		boolean flag=false;
		for(int i=digits.length-1;i>=0;i--) {
			if(i==digits.length-1) {
				digits[i]++;
				if (digits[i] == 10) {
					digits[i] = 0;
					if(digits.length==1) {
						int[] ans=new int[2];
						ans[0]=1;
						ans[1]=0;
						return ans;
					}
					flag = true;
				}
				else
					return digits;
			}
			else if(flag==true) {
				digits[i]++;
				if(digits[i]==10&&i!=0)
					digits[i]=0;
				else if(digits[i]!=10){
					return digits;
				}
				else if(i==0) {
					digits[0]=0;
					int[] ans=new int[digits.length+1];
					ans[0]=1;
					for(int j=0;j<digits.length;j++) {
						ans[j+1]=digits[j];
					}
					return ans;
				}
			}
		}
		return digits;
	}
	public static void main(String[] args) {
		int[] n= {9,9,9,9};
		for(int i:plusOne(n)) {
			System.out.print(i);
		}
	}
}
