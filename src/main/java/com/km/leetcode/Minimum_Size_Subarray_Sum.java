package com.km.leetcode;

public class Minimum_Size_Subarray_Sum {
    public int minSubArrayLen(int s, int[] nums) {
        int start = 0, end = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        while(start<nums.length){
            if(end>=nums.length&&sum<s)
                break;
            if(sum<s) {
                sum += nums[end++];
            }
            else if(sum==s) {
                ans = Math.min(ans, end - start);
                sum-=nums[start++];
            }
            else{
                sum-=nums[start++];
            }
        }
        return ans==Integer.MAX_VALUE?0:ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        Minimum_Size_Subarray_Sum test = new Minimum_Size_Subarray_Sum();
        System.out.println(test.minSubArrayLen(11,nums));
    }
}
