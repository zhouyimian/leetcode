package com.km.WeeklyContest184;

import java.util.ArrayList;
import java.util.List;

public class Queries_on_a_Permutation_With_Key {
    public int[] processQueries(int[] queries, int m) {
        int[] ans = new int[queries.length];
        List<Integer> nums = new ArrayList<>();
        for(int i = 1;i<=m;i++)
            nums.add(i);
        for(int i = 0;i<queries.length;i++){
            int index = findNum(nums,queries[i]);
            ans[i] = index;
            int num = nums.remove(index);
            nums.add(0,num);
        }
        return ans;
    }

    private int findNum(List<Integer> nums, int query) {
        for(int i = 0;i<nums.size();i++){
            if(nums.get(i)==query)
                return i;
        }
        return -1;
    }

}
