package com.km.leetcode;

import java.util.*;

public class Baseball_Game {
	public int calPoints(String[] ops) {
		int ans=0;
		int num;
		Stack stack=new Stack();
		for(int i=0;i<ops.length;i++) {
			if(ops[i].equals("C")) {
				stack.pop();
			}
			else if(ops[i].equals("D")) {
				num=(int)stack.peek();
				num*=2;
				stack.push(num);
			}
			else if(ops[i].equals("+")) {
				int num1,num2;
				num1=(int) stack.pop();
				num2=(int) stack.pop();
				num=num1+num2;
				stack.push(num2);
				stack.push(num1);
				stack.push(num);
			}
			else {
				stack.push(Integer.parseInt(ops[i]));
			}
		}
		while(!stack.isEmpty()) {
			ans+=(int)stack.pop();
		}
		return ans;
	}
}
