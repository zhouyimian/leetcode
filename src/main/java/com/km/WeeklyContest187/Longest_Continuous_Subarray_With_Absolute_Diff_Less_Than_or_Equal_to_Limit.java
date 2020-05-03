package com.km.WeeklyContest187;

import java.util.*;

public class Longest_Continuous_Subarray_With_Absolute_Diff_Less_Than_or_Equal_to_Limit {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxQueue = new LinkedList<>();
        Deque<Integer> minQueue = new LinkedList<>();
        int ans = 1;
        int start = 0;
        int end = 0;
        maxQueue.add(0);
        minQueue.add(0);
        while (end+1<nums.length){
            while (end+1<nums.length&&Math.abs(nums[maxQueue.getFirst()]-nums[minQueue.getFirst()])<=limit){
                ans = Math.max(ans,end-start+1);
                end++;
                if(!maxQueue.isEmpty()){
                    while (!maxQueue.isEmpty()&&nums[maxQueue.getLast()]<nums[end]){
                        maxQueue.removeLast();
                    }
                }
                if(!minQueue.isEmpty()){
                    while (!minQueue.isEmpty()&&nums[minQueue.getLast()]>nums[end]){
                        minQueue.removeLast();
                    }
                }
                maxQueue.add(end);
                minQueue.add(end);
            }
            while (start<end&&Math.abs(nums[maxQueue.getFirst()]-nums[minQueue.getFirst()])>limit){
                if(start==maxQueue.getFirst())
                    maxQueue.removeFirst();
                if(start==minQueue.getFirst())
                    minQueue.removeFirst();
                start++;
            }
            if(Math.abs(nums[maxQueue.getFirst()]-nums[minQueue.getFirst()])<=limit){
                ans = Math.max(ans,end-start+1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Longest_Continuous_Subarray_With_Absolute_Diff_Less_Than_or_Equal_to_Limit test = new Longest_Continuous_Subarray_With_Absolute_Diff_Less_Than_or_Equal_to_Limit();
        int[] nums = {1,2};
        System.out.println(test.longestSubarray(nums,5));
    }
}
