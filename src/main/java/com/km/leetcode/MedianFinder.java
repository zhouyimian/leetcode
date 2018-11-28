package com.km.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {
	/** initialize your data structure here. */
	Queue<Integer> small,large;
	
    public MedianFinder() {
    	small=new PriorityQueue<Integer>();
    	large=new PriorityQueue<Integer>();
    }
    
    public void addNum(int num) {
        small.add(num);
        large.add(-small.peek());
        small.poll();
        if(small.size()<large.size()) {
        	small.add(-large.poll());
        }
    }
    
    public double findMedian() {
    	return small.size() > large.size() ? small.peek() : 0.5 *(small.peek() - large.peek());
    }
    public static void main(String[] args) {
    	MedianFinder test=new MedianFinder();
    	test.addNum(1);
    	test.addNum(2);
    	test.addNum(3);
    	System.out.println(test.findMedian());
    }
}
