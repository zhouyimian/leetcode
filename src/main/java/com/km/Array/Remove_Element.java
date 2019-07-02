package com.km.Array;

public class Remove_Element {
    public int removeElement(int[] nums, int val) {
        int newstart = 0;
        for(int num:nums){
            if(num!=val){
                nums[newstart++]=num;
            }
        }
        return newstart;
    }
}
