package com.km.leetcode;

import java.util.*;

public class MyQueue {
	/** Initialize your data structure here. */
	Stack<Integer> s1=new Stack<>();
	Stack<Integer> s2=new Stack<>();
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while(s1.size()!=1) {
        	s2.push(s1.pop());
        }
        int num=s1.pop();
        while(!s2.isEmpty()) {
        	s1.push(s2.pop());
        }
        return num;
    }
    
    /** Get the front element. */
    public int peek() {
    	while(s1.size()!=1) {
        	s2.push(s1.pop());
        }
        int num=s1.pop();
        s1.push(num);
        while(!s2.isEmpty()) {
        	s1.push(s2.pop());
        }
        return num;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty();
    }
}
