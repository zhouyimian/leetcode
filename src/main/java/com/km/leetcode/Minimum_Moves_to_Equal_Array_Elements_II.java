package com.km.leetcode;

import sun.nio.cs.ext.MacThai;

public class Minimum_Moves_to_Equal_Array_Elements_II {
    public int minMoves2(int[] nums) {
        int ans=Integer.MAX_VALUE,min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        int sum=0;
        for(int num:nums){
            sum+=num;
            if(num>max)
                max=num;
            if(num<min)
                min=num;
        }
        for(int i=min;i<=max;i++){
            ans= Math.min(ans,Math.abs(nums.length*i-sum));
        }
        return ans;
    }
}
