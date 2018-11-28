package com.km.WeeklyContest102;

public class Super_Palindromes {
	static int ans=0;
	public static int superpalindromesInRange(String L, String R) {
		long left=Long.valueOf(L);
		long right=Long.valueOf(R);
		dfs("",left,right);
		for(int i=0;i<10;i++) {
			dfs(""+i,left,right);
		}
		return ans;
	}
	public static void dfs(String s,long left,long right) {
		if(s.length()>9)
			return;
		if(s.length()>0&&s.charAt(0)!=0) {
			long num=Long.valueOf(s);
			num*=num;
			if(num>right)
				return;
			if(num>=left&&check(num))
				ans++;
		}
		for(int i=0;i<9;i++) {
			dfs(i+s+i,left,right);
		}
	}
	public static boolean check(long num) {
		String s=num+"";
		int i=0,j=s.length()-1;
		while(i<=j) {
			if(s.charAt(i)!=s.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}
	public static void main(String[] args) {
		System.out.println(superpalindromesInRange(1+"",19028+""));
	}
}
