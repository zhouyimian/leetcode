package com.km.leetcode;

import java.util.*;

public class Valid_Parentheses {
	public boolean isValid(String s) {
		Stack<Character> left=new Stack<>();
		Stack<Character> right=new Stack<>();
		for(int i=0;i<s.length();i++) {
			char c=s.charAt(i);
			if((c=='('||c=='['||c=='{')&&left.isEmpty()) {
				left.push(c);
				continue;
			}
			if((c==')'||c==']'||c=='}')&&left.isEmpty()) {
				return false;
			}
			if((c==')'&&left.peek()!='(')||(c==']'&&left.peek()!='[')||(c=='}'&&left.peek()!='{')) 
				return false;
			if((c==')'&&left.peek()=='(')||(c==']'&&left.peek()=='[')||(c=='}'&&left.peek()=='{')) {
				left.pop();
				continue;
			}
			left.push(c);
		}
		if(!left.isEmpty()||!right.isEmpty())
			return false;
		return true;
	}
}
