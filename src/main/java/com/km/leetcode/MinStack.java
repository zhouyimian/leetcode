package com.km.leetcode;

import java.util.Stack;

public class MinStack {
    Stack<Integer> min = new Stack<Integer>();
    Stack<Integer> stack = new Stack<Integer>();
    /** initialize your data structure here. */
    public MinStack() {
    }

    public void push(int x) {
        stack.push(x);
        if(min.size()==0)
            min.push(x);
        else
            min.push(Math.min(x,min.peek()));
    }

    public void pop() {
        stack.pop();
        min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }

    public static void main(String[] args) {
        MinStack test = new MinStack();
        test.push(-2);
        test.push(0);
        test.push(-3);
        System.out.println(test.getMin());
        test.pop();
        System.out.println(test.top());
        System.out.println(test.getMin());
    }
}
