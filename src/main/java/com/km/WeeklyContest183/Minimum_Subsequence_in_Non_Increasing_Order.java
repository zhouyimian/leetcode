package com.km.WeeklyContest183;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Minimum_Subsequence_in_Non_Increasing_Order {
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2-o1);
        int sum = 0;
        for(int num:nums) {
            queue.add(num);
            sum += num;
        }
        int cur = 0;
        while (queue.size()!=0&&cur<=sum/2){
            int num = queue.poll();
            ans.add(num);
            cur+=num;
        }
        return ans;
    }
}
