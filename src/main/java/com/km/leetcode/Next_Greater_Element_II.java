package com.km.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class Next_Greater_Element_II {
    public int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(ans, -1);
        for (int i = 0; i < nums.length*2; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % nums.length])
                ans[stack.pop()] = nums[i % nums.length];
            stack.push(i % nums.length);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2,1};
        Next_Greater_Element_II test = new Next_Greater_Element_II();
        int[] res = test.nextGreaterElements(nums);
        for (int num : res)
            System.out.println(num);
    }
}
