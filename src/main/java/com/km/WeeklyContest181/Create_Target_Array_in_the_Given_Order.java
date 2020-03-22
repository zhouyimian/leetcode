package com.km.WeeklyContest181;

import java.util.ArrayList;
import java.util.List;

public class Create_Target_Array_in_the_Given_Order {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i<nums.length;i++){
            if(list.size()==index[i]){
                list.add(nums[i]);
                continue;
            }
            list.add(index[i],nums[i]);
        }
        int[] ans = new int[nums.length];
        for(int i = 0;i<nums.length;i++)
            ans[i] = list.get(i);
        return ans;
    }

    public static void main(String[] args) {
        Create_Target_Array_in_the_Given_Order test = new Create_Target_Array_in_the_Given_Order();
        int[] nums = {0,1,2,3,4};
        int[] index = {0,1,2,2,1};
        System.out.println(test.createTargetArray(nums,index));
    }
}
