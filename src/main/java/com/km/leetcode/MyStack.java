package com.km.leetcode;

import java.util.*;

public class MyStack {
	/** Initialize your data structure here. */
	Queue<Integer> q1 = new LinkedList<Integer>();
	Queue<Integer> q2 = new LinkedList<Integer>();
	public MyStack() {
		
	}

	/** Push element x onto stack. */
	public void push(int x) {
		q1.add(x);
	}

	/** Removes the element on top of the stack and returns that element. */
	public int pop() {
		while(q1.size()!=1) {
			q2.add(q1.poll());
		}
		int num=q1.poll();
		while(!q2.isEmpty()) {
			q1.add(q2.poll());
		}
		return num;
	}

	/** Get the top element. */
	public int top() {
		while(q1.size()!=1) {
			q2.add(q1.poll());
		}
		int num=q1.poll();
		while(!q2.isEmpty()) {
			q1.add(q2.poll());
		}
		q1.add(num);
		return num;
	}

	/** Returns whether the stack is empty. */
	public boolean empty() {
		return q1.isEmpty();
	}
}
