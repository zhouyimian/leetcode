package com.km.leetcode;

import java.util.*;

public class Generate_Parentheses {
	List<String> ans = new ArrayList<>();
	int currleft=1;
	int currright=0;
	int sum;

	public List<String> generateParenthesis(int n) {
		StringBuilder sb=new StringBuilder();
		sb.append("(");
		sum=n;
		search(sb);
		return ans;
	}
	void search(StringBuilder sb) {
		if(currleft+currright==sum*2) {
			ans.add(new String(sb));
			return;
		}
		else {
			StringBuilder sb1 = new StringBuilder(sb);
			if (currleft < sum) {
				sb1.append("(");
				currleft++;
				search(sb1);
				currleft--;
			}
			if (currleft > currright) {
				currright++;
				StringBuilder sb2 = new StringBuilder(sb);
				sb2.append(")");
				search(sb2);
				currright--;
			}
		}
	}
}
