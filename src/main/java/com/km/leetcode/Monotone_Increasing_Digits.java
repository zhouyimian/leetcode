package com.km.leetcode;

public class Monotone_Increasing_Digits {
	static String s;
	static String temp="";
	static String ans=null;
	public static int monotoneIncreasingDigits(int N) {
		s=N+"";
		for(int i=s.charAt(0)-'0';i>=0;i--) {
				temp = temp + i;
				f(i, 1);
				if(ans==null) {
					ans=""+(i-1);
					for(int j=1;j<s.length();j++)
						ans+=9;
					return Integer.parseInt(ans);
				}
		}
		return Integer.parseInt(ans);
	}
	static void f(int before,int now) {
		if (now == s.length()) {
			if (ans == null) {
				ans = new String(temp);
			}
			return;
		}
		int i=0;
		i=s.charAt(now)-'0';
		for(;i>=before;i--) {
			temp+=i;
			f(i,now+1);
			temp=temp.substring(0,temp.length()-1);
			if(ans!=null)
				return;
			if(i-1<before) {
				return;
			}
			else {
				temp=temp+(i-1);
				for(int j=now+1;j<s.length();j++)
					temp+=9;
				ans=temp;
				return ;
			}
		}
	}
	public static void main(String[] args) {
		System.out.println(monotoneIncreasingDigits(332));
	}
}
