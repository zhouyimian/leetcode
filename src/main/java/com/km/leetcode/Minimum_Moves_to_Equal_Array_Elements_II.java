package com.km.leetcode;

import sun.nio.cs.ext.MacThai;

import java.util.Arrays;

public class Minimum_Moves_to_Equal_Array_Elements_II {
    public int minMoves2(int[] nums) {
        int ans=0;
        Arrays.sort(nums);
        int i=0,j=nums.length-1;
        while(i<j)
            ans+=(nums[j--]-nums[i++]);
        return ans;
    }
}
