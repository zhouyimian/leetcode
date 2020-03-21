package com.Biweekly.BiweeklyContest22;

public class Find_the_Distance_Value_Between_Two_Arrays {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int ans = 0;
        for(int numA:arr1){
            boolean flag = false;
            for(int numB:arr2){
                if(Math.abs(numA-numB)<=d){
                    flag = true;
                    break;
                }
            }
            if(!flag)
                ans++;
        }
        return ans;
    }
}
