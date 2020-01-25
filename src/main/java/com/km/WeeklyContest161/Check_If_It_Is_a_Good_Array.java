package com.km.WeeklyContest161;

public class Check_If_It_Is_a_Good_Array {
    public boolean isGoodArray(int[] nums) {
        int cur_gcd = nums[0];
        for(int i = 1;i<nums.length;i++){
            cur_gcd = gcd(nums[i],cur_gcd);
        }
        return cur_gcd==1;
    }
    private int gcd(int a,int b){
        if(a<b){
            int temp = a;
            a = b;
            b = temp;
        }
        int r=a%b;
        while(r!=0) {
            a=b;
            b=r;
            r=a%b;
        }
        return b;
    }
}
