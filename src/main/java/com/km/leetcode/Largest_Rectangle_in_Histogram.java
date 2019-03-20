package com.km.leetcode;

import java.util.Stack;

public class Largest_Rectangle_in_Histogram {
    public int largestRectangleArea(int[] heights) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= heights.length; i++) {
            int h = (i==heights.length?0:heights[i]);
            if(stack.size()==0||h>=heights[stack.peek()])
                stack.push(i);
            else{
                int tp = stack.pop();
                ans = Math.max(ans,heights[tp]*(stack.size()==0?i:i-1-stack.peek()));
                i--;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Largest_Rectangle_in_Histogram test = new Largest_Rectangle_in_Histogram();
        int[] nums = {1,2,3};
        System.out.println(test.largestRectangleArea(nums));
    }
}
