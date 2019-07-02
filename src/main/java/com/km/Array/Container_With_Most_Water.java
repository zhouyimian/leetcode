package com.km.Array;

public class Container_With_Most_Water {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int ans = 0;
        while(left<right){
            ans = Math.max(ans,(right-left)*Math.min(height[left],height[right]));
            if(height[left]>height[right]){
                right--;
            }else{
                left++;
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
