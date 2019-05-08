package com.km.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Largest_Divisible_Subset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        ArrayList<Integer> ans = new ArrayList<>();
        if(nums[0]==1){
            for(int num:nums)
                ans.add(num);
            return ans;
        }
        return ans;
    }
}
