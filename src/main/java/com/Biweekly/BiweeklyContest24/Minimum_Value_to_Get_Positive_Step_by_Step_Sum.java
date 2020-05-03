package com.Biweekly.BiweeklyContest24;

import com.sun.org.apache.bcel.internal.generic.RETURN;

public class Minimum_Value_to_Get_Positive_Step_by_Step_Sum {
    public int minStartValue(int[] nums) {
        int ans = Integer.MAX_VALUE;
        int low = 0;
        int high = 10010;
        while (low<high){
            int mid = high+(high-low)>>1;
            if(deal(mid,nums)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return  ans;
    }

    private boolean deal(int start, int[] nums) {
        for(int num:nums){
            start+=num;
            if(start<1)
                return false;
        }
        return true;
    }
}
