package com.km.leetcode;

public class Trapping_Rain_Water {
    int result=0;
    public int trap(int[] height) {
        if(height.length==0) return result;
        int side1=height[0], side2=height[height.length-1], max=height[0], peak=0;
        for(int i=0; i<height.length; i++) {
            if(height[i]>max){
                max=height[i];
                peak=i;
            }
        }
        for(int i=0; i<peak; i++){
            if(height[i]>=side1) side1=height[i];
            else result+=side1-height[i];
        }
        for(int i=height.length-1; i>peak; i--){
            if(height[i]>=side2) side2=height[i];
            else result+=side2-height[i];
        }

        return result;
    }
}
