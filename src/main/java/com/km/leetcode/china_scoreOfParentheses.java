package com.km.leetcode;

public class china_scoreOfParentheses {
	/*static int pos=0;
	public static int scoreOfParentheses(String S) {
		int ans=0;
		for(pos=0;pos<S.length();) {
			if(S.charAt(pos)=='(') {
				pos++;
				int n=stacks(S,1,0);
				ans+=n==1?1:2*n;
			}
		}
		return ans;
	}*/

	public static int scoreOfParentheses(String S) {
		if(S.equals("()"))
			return 1;
		if(S.equals("()"))
			return 0;
		int left=0,right=0;
		int leftcount=0,rightcount=0;
		int ans=0;
		for(int i=0;i<S.length();i++) {
			if(S.charAt(i)=='(') {
				if(leftcount==0)
					left=i;
				leftcount++;
			}
			if(S.charAt(i)==')')
				rightcount++;
			if(leftcount==rightcount) {
				right=i;
				int n=scoreOfParentheses(S.substring(left+1, right));
				ans+=n==0?1:2*n;
				leftcount=0;
				rightcount=0;
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		System.out.println(scoreOfParentheses("(()(()))"));

	}
}
