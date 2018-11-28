package com.km.WeeklyContest93;

public class Binary_Gap {
	public static int binaryGap(int N) {
		String s=Integer.toBinaryString(N);
		int ans=0;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='0')
				continue;
			else {
				int j=i+1;
				while(j<s.length()&&s.charAt(j)=='0') j++;
				if(j==s.length())
					break;
				ans=Math.max(ans,j-i);
				i=j-1;
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		System.out.println(binaryGap(5));
	}
}
