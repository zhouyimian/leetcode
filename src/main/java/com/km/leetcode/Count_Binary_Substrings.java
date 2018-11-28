package com.km.leetcode;

public class Count_Binary_Substrings {
	public static int countBinarySubstrings(String s) {
		int[] left_0=new int[s.length()];
		int[] right_0=new int[s.length()];
		int[] left_1=new int[s.length()];
		int[] right_1=new int[s.length()];
		int len=s.length();
		left_0[0]=0;
		left_1[0]=0;
		right_0[s.length()-1]=0;
		right_1[s.length()-1]=0;
		for(int i=1;i<len;i++) {
			if(s.charAt(i-1)=='0')
				left_0[i]=left_0[i-1]+1;
			if(s.charAt(i-1)=='1')
				left_1[i]=left_1[i-1]+1;
		}
		for(int i=len-2;i>=0;i--) {
			if(s.charAt(i+1)=='0')
				right_0[i]=right_0[i+1]+1;
			if(s.charAt(i+1)=='1')
				right_1[i]=right_1[i+1]+1;
		}
		int ans=0;
		for(int i=1;i<len;i++) {
			if(s.charAt(i)=='0') {
				if(s.charAt(i-1)=='0') {
					ans+=Math.min(left_0[i]+1, right_1[i]);
					i+=Math.min(left_0[i], right_1[i]);
				}
				else {
					ans+=Math.min(left_1[i], right_0[i]+1);
					i+=Math.min(left_1[i], right_0[i]);
				}
			}
			else {
				if(s.charAt(i-1)=='1') {
					ans+=Math.min(left_1[i]+1, right_0[i]);
					i+=Math.min(left_1[i], right_0[i]);
				}
				else {
					ans+=Math.min(left_0[i], right_1[i]+1);
					i+=Math.min(left_0[i], right_1[i]);
				}
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		String s="00110";
		countBinarySubstrings(s);
	}
}
