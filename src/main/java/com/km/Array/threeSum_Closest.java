package com.km.Array;

import java.util.Arrays;

public class threeSum_Closest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int ans = 0;
        int length = nums.length;
        for(int i = 0 ;i<length;i++){
            int start = i+1;
            int end = nums.length-1;
            while(end>start){
                int res = target - (nums[i]+nums[start]+nums[end]);
                if(Math.abs(res)<=diff){
                    diff = Math.abs(res);
                    ans = nums[i]+nums[start]+nums[end];
                    if(diff==0)
                        return target;
                }
                if(res<0)
                    end--;
                else
                    start++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {0,-16,-11,-4,6,20,-17,10,14,-11,-16,17,-14,-11,8,-4,0,-2,10,15,0,-2,-3,19,17,-18,8,-16,-4,-16,-20,16,-16,5,-3,-18,-12,-18,-9,11,3,-14,-18,8,11,-9,-1,6,1,-17,-9,-7,11,-10,18,-1,4,-8,1,-20,-19,-19,12,13,14,15,0,18,3,8,-4,18,-1,6,-19,-11,11,14,12,11,-15,2,4,-1,5,3,-17,15,-1,-15,3,16,-11,-14,14,4,-7,-20,-2,-14,-8,-12,-12,18,4,-12,16};
        threeSum_Closest test = new threeSum_Closest();
        System.out.println(test.threeSumClosest(nums,-31));
    }
}
