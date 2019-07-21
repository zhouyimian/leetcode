package com.km.leetcode;

import java.util.Arrays;

public class Wiggle_Sort_II {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] temp = Arrays.copyOf(nums,nums.length);
        int j = nums.length,k = (nums.length+1)/2;
        for(int i = 0;i<nums.length;i++){
            nums[i] = (i&1)==1?temp[--j]:temp[--k];
        }
    }

    public static void main(String[] args) {
        Wiggle_Sort_II test = new Wiggle_Sort_II();
        int[] nums = {2,3,4};
        test.wiggleSort(nums);
    }
}
