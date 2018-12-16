package com.km.leetcode;

import java.util.Arrays;

public class Sort_Colors {
    public void sortColors(int[] nums) {
        int zerocount=0;
        int onecount=0;
        for(int num:nums){
            if(num==0)
                zerocount++;
            else if(num==1)
                onecount++;
        }
        for(int i=0;i<nums.length;i++){
            if(i<zerocount)
                nums[i]=0;
            else if(i<zerocount+onecount)
                nums[i]=1;
            else
                nums[i]=2;
        }
    }
}
