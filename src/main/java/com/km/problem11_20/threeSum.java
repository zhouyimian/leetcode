package com.km.problem11_20;

import java.util.*;

public class threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;
        for(int i = 0;i<length;i++){
            if(i!=0&&nums[i]==nums[i-1]) continue;
            int start = i+1;
            int end = length-1;
            while(start<end){
                int res = nums[i]+nums[start]+nums[end];
                if(res==0){
                    ans.add(Arrays.asList(nums[i],nums[start],nums[end]));
                }
                if(res>=0){
                    end--;
                    while(start<end&&nums[end]==nums[end+1]) end--;
                }
                else{
                    start++;
                    while(start<end&&nums[start]==nums[start-1]) start++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1};
        threeSum test = new threeSum();
        test.threeSum(nums);
    }
}
