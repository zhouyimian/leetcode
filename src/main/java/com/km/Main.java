package com.km;


public class Main {
    public int largestRectangleArea(int[] heights) {
        int ans = 0;
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        for(int i = 0;i<left.length;i++){
            int end = i;
            while (end>=0&&heights[end]>=heights[i]) end--;
            if(end==-1)
                left[i] = 0;
            else
                left[i] = end+1;
        }
        for(int i = 0;i<right.length;i++){
            int end = i;
            while (end<heights.length&&heights[end]>=heights[i]) end++;
            if(end==heights.length)
                right[i] = heights.length-1;
            else
                right[i] = end-1;
        }
        for(int i = 0;i<left.length;i++)
            ans = Math.max(ans,heights[i]*(right[i]-left[i]+1));
        return ans;
    }

    public static void main(String[] args) {
        Main test = new Main();
        int[] heights = {2,3};

        System.out.println(test.largestRectangleArea(heights));
    }
}
