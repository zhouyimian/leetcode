package com.km.WeeklyContest166;

public class Find_the_Smallest_Divisor_Given_a_Threshold {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = 1000000;
        int ans = -1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(solve(mid,nums,threshold)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
    public boolean solve(int div,int[] nums,int threshold){
        int count = 0;
        for(int num:nums){
            if(num%div==0){
                count+=num/div;
            }else{
                count+=(num/div+1);
            }
        }
        return count<=threshold;
    }
}
