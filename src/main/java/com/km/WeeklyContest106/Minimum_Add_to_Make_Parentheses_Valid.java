package com.km.WeeklyContest106;

import java.util.Stack;

public class Minimum_Add_to_Make_Parentheses_Valid {
	public int minAddToMakeValid(String S) {
		int ans=0;
		Stack<Character> stack=new Stack<>();
		int len=S.length();
		int i=0;
		while(i<len) {
			if(S.charAt(i)=='(')
				stack.push('(');
			else if(S.charAt(i)==')'&&stack.isEmpty()) ans++;
			else if(S.charAt(i)==')'&&stack.peek()=='(') stack.pop();
			i++;
		}
		return ans+stack.size();
	}

	public static void main(String[] args) {
		Minimum_Add_to_Make_Parentheses_Valid test=new Minimum_Add_to_Make_Parentheses_Valid();
		System.out.println(test.minAddToMakeValid("()))(("));
	}

}
