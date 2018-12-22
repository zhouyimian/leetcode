package com.km.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Majority_Element_II {
    public List<Integer> majorityElement(int[] nums) {
        if(nums.length==0)
            return new ArrayList<>();
        int A=nums[0],B=nums[0],countA=0,countB=0;
        for(int num:nums){
            if(num==A){
                countA++;
                continue;
            }
            if(num==B){
                countB++;
                continue;
            }
            if(countA==0){
                A=num;
                countA=1;
                continue;
            }
            if(countB==0){
                B=num;
                countB=1;
                continue;
            }
            countA--;
            countB--;
        }
        countA=0;
        countB=0;
        for(int num:nums){
            if(num==A)
                countA++;
            else if(num==B)
                countB++;
        }
        List<Integer> ans=new ArrayList();
        if(countA>nums.length/3)
            ans.add(A);
        if(countB>nums.length/3)
            ans.add(B);
        return ans;
    }
}
