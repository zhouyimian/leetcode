package com.km.leetcode;

public class Container_With_Most_Water {
    int ans = 0;
    public int maxArea(int[] height) {
        for(int i = 0;i<height.length;i++){
            for(int j = height.length-1;j>i;j--){
                if((j-i)*height[i]<=ans)
                    break;
                ans = Math.max(ans,(j-i)*Math.min(height[i],height[j]));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Container_With_Most_Water test = new Container_With_Most_Water();
        int[] nums = {1,8,6,2,5,4,8,3,7};
        System.out.println(test.maxArea(nums));
    }
}
