package com.km.leetcode;

public class Minimum_Moves_to_Equal_Array_Elements {
    public int minMoves(int[] nums) {
        int ans=0,min=Integer.MAX_VALUE;
        for(int num:nums)
            min=Math.min(num,min);
        for(int num:nums)
            ans+=(num-min);
        return ans;
    }
}
