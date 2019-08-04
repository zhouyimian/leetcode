package com.km.WeeklyContest148;

import java.util.Arrays;

public class Decrease_Elements_To_Make_Array_Zigzag {
    public static void main(String[] args) {
        Decrease_Elements_To_Make_Array_Zigzag test = new Decrease_Elements_To_Make_Array_Zigzag();
        int[] nums = {9,6,1,6,2};
        System.out.println(test.movesToMakeZigzag(nums));
    }
    public int movesToMakeZigzag(int[] nums) {
        int ans = Integer.MAX_VALUE;
        int temp = 0;
        if(nums.length==1)
            return 0;
        int[] copy = new int[nums.length];
        for(int i = 0;i<nums.length;i++)
            copy[i] = nums[i];
        for(int i = 0;i<nums.length;i+=2) {
            if (i >= 1) {
                if ((nums[i - 1] >= nums[i])) {
                    temp += (nums[i - 1] - nums[i] + 1);
                    nums[i - 1] = nums[i] - 1;
                }
            }
            if (i <= nums.length - 2) {
                if (nums[i + 1] >= nums[i]) {
                    temp += (nums[i + 1] - nums[i] + 1);
                    nums[i + 1] = nums[i] - 1;
                }
            }
        }
        ans = temp;
        temp = 0;
        for(int i = 0;i<copy.length;i++)
            nums[i] = copy[i];
        for(int i = 1;i<nums.length;i+=2) {
            if (i >= 1) {
                if ((nums[i - 1] >= nums[i])) {
                    temp += (nums[i - 1] - nums[i] + 1);
                    nums[i - 1] = nums[i] - 1;
                }
            }
            if (i <= nums.length - 2) {
                if (nums[i + 1] >= nums[i]) {
                    temp += (nums[i + 1] - nums[i] + 1);
                    nums[i + 1] = nums[i] - 1;
                }
            }
        }
        return Math.min(ans,temp);
    }
}
