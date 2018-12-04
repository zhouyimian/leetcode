package com.km.leetcode;

import java.awt.*;

public class MyCircularDeque {
        int[] nums;
        int size;
        int first;
        int end;
        int count;
        /** Initialize your data structure here. Set the size of the deque to be k. */
        public MyCircularDeque(int k) {
            nums=new int[k];
            size=k;
            first=end=count=0;
        }

        /** Adds an item at the front of Deque. Return true if the operation is successful. */
        public boolean insertFront(int value) {
            if(count==size)
                return false;
            nums[first]=value;
            count++;
            if(count==1)
                end=end==size-1?0:end+1;
            first=first-1==-1?size-1:first-1;
            return true;
        }

        /** Adds an item at the rear of Deque. Return true if the operation is successful. */
        public boolean insertLast(int value) {
            if(count==size)
                return false;
            nums[end]=value;
            count++;
            if(count==1)
                first=first==0?size-1:first-1;
            end=end+1==size?0:end+1;
            return true;
        }

        /** Deletes an item from the front of Deque. Return true if the operation is successful. */
        public boolean deleteFront() {
            if(count==0)
                return false;
            first=(first+1)==size?0:first+1;
            count--;
            if(count==0)
                end=first;
            return true;
        }

        /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
        public boolean deleteLast() {
            if(count==0)
                return false;
            end=(end-1)==-1?size-1:end-1;
            count--;
            if(count==0)
                first=end;
            return true;
        }

        /** Get the front item from the deque. */
        public int getFront() {
            return count==0?-1:first==size-1?nums[0]:nums[first+1];
        }

        /** Get the last item from the deque. */
        public int getRear() {
            return count==0?-1:end==0?nums[size-1]:nums[end-1];
        }

        /** Checks whether the circular deque is empty or not. */
        public boolean isEmpty() {
            return count==0;
        }

        /** Checks whether the circular deque is full or not. */
        public boolean isFull() {
            return count==size;
        }
    public static void main(String[] args) {
        MyCircularDeque test=new MyCircularDeque(2);
        System.out.println(test.insertFront(7));
        System.out.println(test.insertLast(0));
        /*System.out.println(test.insertFront(3));
        System.out.println(test.getRear());
        System.out.println(test.isFull());
        System.out.println(test.deleteLast());
        System.out.println(test.insertFront(4));
        System.out.println(test.getFront());*/
        System.out.println(test.getFront());
//["MyCircularDeque","insertFront","deleteLast","getFront","insertLast","insertFront","getFront","getRear","getFront","getFront","getRear","insertLast"]
//[[2],[7],[],[],[5],[0],[],[],[],[],[],[0]]
    }
}
