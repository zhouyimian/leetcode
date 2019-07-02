package com.km.problem21_30;

import java.util.*;

public class Generate_Parentheses {
	public List<String> generateParenthesis(int n) {
		List<String> list = new ArrayList<String>();
		backtrack(list, "", 0, 0, n);
		return list;
	}

	public void backtrack(List<String> list, String str, int open, int close, int max){

		if(str.length() == max*2){
			list.add(str);
			return;
		}

		if(open < max)
			backtrack(list, str+"(", open+1, close, max);
		if(close < open)
			backtrack(list, str+")", open, close+1, max);
	}

	public static void main(String[] args) {
		Generate_Parentheses test = new Generate_Parentheses();
		List<String> ans = test.generateParenthesis(3);
		for(String s:ans)
			System.out.println(s);
	}
}
