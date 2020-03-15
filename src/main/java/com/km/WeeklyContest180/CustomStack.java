package com.km.WeeklyContest180;

import java.util.ArrayList;
import java.util.List;

public class CustomStack {
    List<Integer> nums;
    int size;
    public CustomStack(int maxSize) {
        nums = new ArrayList<>();
        size = maxSize;
    }

    public void push(int x) {
        if(nums.size()!=size)
            nums.add(x);
    }

    public int pop() {
        if(nums.size()==0)
            return -1;
        return nums.remove(nums.size()-1);
    }

    public void increment(int k, int val) {
        for(int i = 0;i<k&&i<nums.size();i++){
            nums.set(i,nums.get(i)+val);
        }
    }
}
