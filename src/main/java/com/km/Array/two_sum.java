package com.km.Array;

import java.util.HashMap;
import java.util.Map;

public class two_sum {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        int length = nums.length;
        for(int i = 0;i<length;i++){
            if(map.containsKey(nums[i])){
                ans[0] = map.get(nums[i]);
                ans[1] = i;
                return ans;
            }
            map.put(target-nums[i],i);
        }
        return ans;
    }
}
