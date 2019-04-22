package com.km.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets_II {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums.length==0)
            return ans;
        Arrays.sort(nums);
        ans.add(new ArrayList<>());
        ans.add(Arrays.asList(nums[0]));
        int last = 1;
        for(int i = 1;i<nums.length;i++){
            int size = ans.size();
            if(nums[i]!=nums[i-1])
                last = size;
            for(int j = size-last;j<size;j++){
                List<Integer> temp = new ArrayList<>(ans.get(j));
                temp.add(nums[i]);
                ans.add(temp);
            }
        }
        return ans;
    }
}
