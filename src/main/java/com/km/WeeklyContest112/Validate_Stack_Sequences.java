package com.km.WeeklyContest112;

import java.util.Stack;

public class Validate_Stack_Sequences {

	public boolean validateStackSequences(int[] pushed, int[] popped) {
		Stack<Integer> stack=new Stack();
		int index=0;
		for(int i=0;i<pushed.length;i++) {
			stack.push(pushed[i]);
			while(!stack.isEmpty()&&stack.peek()==popped[index]) {
				index++;
				stack.pop();
			}
		}
		return stack.size()==0?true:false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
