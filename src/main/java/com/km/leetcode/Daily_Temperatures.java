package com.km.leetcode;

import java.util.*;

public class Daily_Temperatures {
	public static int[] dailyTemperatures(int[] temperatures) {
		int[] ans = new int[temperatures.length];
		if (temperatures.length == 0)
			return ans;
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> stack_count = new Stack<>();
		for (int i = 0; i < temperatures.length; i++) {
			if (stack.isEmpty()) {
				stack.push(temperatures[i]);
				stack_count.push(i);
			} else {
				while (!stack.isEmpty() && temperatures[i] > stack.peek()) {
					ans[stack_count.peek()] = i - stack_count.peek();
					stack.pop();
					stack_count.pop();
				}
				stack.push(temperatures[i]);
				stack_count.push(i);
			}
		}
		while(!stack_count.isEmpty()) {
			ans[stack_count.peek()]=0;
			stack_count.pop();
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] n = { 73, 74, 75, 71, 69, 72, 76, 73 };
		System.out.println(dailyTemperatures(n).length);
	}
}
